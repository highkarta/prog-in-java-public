package practice.multithreading.TicketBooking;

/**
 * BFGem
 */

class TicketInventory {
    int availableTickets;
    boolean bookingStatus; // true = open/calculating, false = finalized

    TicketInventory(int availableTickets, boolean bookingStatus) {
        this.availableTickets = availableTickets;
        this.bookingStatus = bookingStatus;
    }
}

class InventoryAllocator extends Thread {
    TicketInventory sharedInventory;

    InventoryAllocator(TicketInventory sharedInventory) {
        this.sharedInventory = sharedInventory;
    }

    public void run() {
        try {
            // Simulation logic runs OUTSIDE synchronization so we don't hog the lock
            System.out.println("[Allocator] Calculating and allocating tickets...");
            
            // Fix: Actually count down the structural tickets
            while (sharedInventory.availableTickets > 0) {
                System.out.println("Allocating ticket no. " + sharedInventory.availableTickets);
                sharedInventory.availableTickets--;
                Thread.sleep(100); 
            }

            // Open the block ONLY when updating state and signaling
            synchronized (sharedInventory) {
                sharedInventory.bookingStatus = false; 
                System.out.println("[Allocator] All tickets allocated. Notifying processor...");
                sharedInventory.notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class BookingProcessor extends Thread {
    TicketInventory sharedInventory;

    BookingProcessor(TicketInventory sharedInventory) {
        this.sharedInventory = sharedInventory;
    }

    public void run() {
        synchronized (sharedInventory) {
            try {
                // Loop correctly checks if status is still true (open/calculating)
                while (sharedInventory.bookingStatus) {
                    System.out.println("[Processor] Bookings are still under process. Waiting...");
                    sharedInventory.wait(); // Releases lock and sleeps cleanly
                }
                
                System.out.println("[Processor] Resumed! Closing booking status, processing records...");
                Thread.sleep(1000);
                System.out.println("[Processor] Final backend batch database updates completed.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class BFGem {
    public static void main(String[] args) {
        TicketInventory ti = new TicketInventory(25, true);
        InventoryAllocator ia = new InventoryAllocator(ti);
        BookingProcessor bp = new BookingProcessor(ti);

        try {
            bp.start();
            Thread.sleep(200); // Small delay to let the processor thread enter its wait loop first
            ia.start();

            // Fix: Wait for the CONSUMER (bp) to finish completely before closing the system
            bp.join(); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("[Main] System Closed: Sorry, all concert bookings have officially closed.");
    }
}
