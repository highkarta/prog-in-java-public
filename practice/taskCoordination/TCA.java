package practice.taskCoordination;

/**
 * Report
 */

class Report { // this object can act like a lock to navigate between the two threads

    boolean reportStatus = false; // create a common variable accessible via both threads
}

class TaskA extends Thread {

    Report sharedReport;

    TaskA(Report sharedReport) {
        this.sharedReport = sharedReport;
    }

    public void run() {
        try {
            System.out.println("Generating report...");
            Thread.sleep(1000);

            for (int i = 1; i <= 10; i++) {
                System.out.println("Working on " + i + "th section");
                Thread.sleep(500);
            }

            synchronized (sharedReport) {
                sharedReport.reportStatus = true;
                System.out.println("Report ready to read...");
                sharedReport.notifyAll();
            }
        } catch (InterruptedException e) {
            e.getMessage();
        }
    }
}

class TaskB extends Thread {

    Report sharedReport;

    TaskB(Report sharedReport) {
        this.sharedReport = sharedReport;
    }

    public void run() {
        synchronized (sharedReport) {
            try {
                while (!sharedReport.reportStatus) {
                    System.out.println(
                        "Still processing the report, not ready yet..."
                    );
                    sharedReport.wait(); // TaskB enters waiting state permanently until it's notified again by TaskA once it finishes it's execution
                }
                System.out.println("Task B in process...");
                Thread.sleep(1000);
                System.out.println("Task B completed processing");
            } catch (InterruptedException e) {
                e.getMessage();
            }
        }
    }
}

public class TCA {

    public static void main(String[] args) throws Exception {
        Report r = new Report();
        TaskA t1 = new TaskA(r);
        TaskB t2 = new TaskB(r);

        try {
            t2.start();
            Thread.sleep(500);
            // TaskA.sleep(500); // correct way to access it statically
            t1.start();
            t2.join();
        } catch (InterruptedException e) {
            e.getMessage();
        }
        System.out.println("Program finished executing");
    }
}
