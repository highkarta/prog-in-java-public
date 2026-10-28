package practice.multithreading;

/**
 * BookingSystem
 */

class Seats {
    int count;

    Seats(int count) {
        this.count = count;
    }

    public synchronized void setCount(Seats s) {
        try {
            Thread.sleep(1000); // employing this will force the processor to context switch as when the current thread sleeps for a while, the processor won't stop, it will switch to the other thread
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (s.count == 0) {
            System.out.println("seats are full");
            return;
        }

        s.count = s.count - 1;
    }
}

class MovieThread extends Thread {

    Seats s;

    MovieThread(Seats s) {
        this.s = s;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            s.setCount(s);
            System.out.println(Thread.currentThread().getName() + " " + s.count);
        }
    }
}

public class BookingSystem {

    public static void main(String[] args) {
        Seats s = new Seats(5);
        MovieThread mt1 = new MovieThread(s);
        MovieThread mt2 = new MovieThread(s);
        MovieThread mt3 = new MovieThread(s);
        MovieThread mt4 = new MovieThread(s);

        mt1.start();
        mt2.start();
        mt3.start();
        mt4.start();
    }
}
