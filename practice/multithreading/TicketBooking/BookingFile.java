package practice.multithreading.TicketBooking;
/**
 * Test
 */
class TicketInventory {

    int availableTickets;
    boolean bookingStatus;

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
            synchronized (sharedInventory) {
                /*
                for (int i = sharedInventory.availableTickets; i >= 0; i--) { // better to use a while loop instead
                    System.out.println(
                        "Booking ticket no. " + i
                    );
                    Thread.sleep(100);
                }
                */
                
                while(sharedInventory.availableTickets > 0){
                    System.out.println("Booking ticket no. " + sharedInventory.availableTickets);
                    sharedInventory.availableTickets--;
                    Thread.sleep(100);
                }
                
                sharedInventory.bookingStatus = false;
                sharedInventory.notifyAll();
            }
        } catch (InterruptedException e) {
            e.getMessage();
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
                while (sharedInventory.bookingStatus) {
                    System.out.println("Bookings are still under process");
                    sharedInventory.wait();
                }
                System.out.println("Closing booking status, under process...");
                Thread.sleep(1000);
                System.out.println("Final processes remain...");
            } catch (InterruptedException e) {
                e.getMessage();
            }
        }
    }
}

public class BookingFile{

    public static void main(String[] args) {
        TicketInventory ti = new TicketInventory(25, true);
        InventoryAllocator ia = new InventoryAllocator(ti);
        BookingProcessor bp = new BookingProcessor(ti);

        try {
            bp.start();
            Thread.sleep(1000);
            ia.start();
            bp.join(); // not .wait() here, we want ia to finish executing first before main outputs bookings closed
        } catch (InterruptedException e) {
            e.getMessage();
        }
        System.out.println("Sorry the bookings have been closed");
    }
}
