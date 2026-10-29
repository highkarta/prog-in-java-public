package practice.taskCoordination;

class Report {

    // Shared state stored in the class
    boolean reportStatus = false;
}

class TaskA extends Thread {

    private final Report sharedReport;

    // Receive the shared object instance reference
    TaskA(Report sharedReport) {
        this.sharedReport = sharedReport;
    }

    @Override
    public void run() {
        try {
            // Make the operations sequence observable by introducing a brief work simulation delay
            System.out.println(
                "[Task A] Starting to generate the report data..."
            );
            Thread.sleep(1000);

            for (int i = 1; i <= 5; i++) {
                System.out.println("[Task A] Compiling section " + i + "...");
                Thread.sleep(200);
            }

            // Synchronize on the shared object to safely update its state and notify
            synchronized (sharedReport) {
                sharedReport.reportStatus = true;
                System.out.println(
                    "[Task A] Report status updated to READY. Notifying waiting threads..."
                );

                // Wake up Task B which is currently waiting on this lock
                sharedReport.notify();
            }
        } catch (InterruptedException e) {
            System.err.println("[Task A] Interrupted: " + e.getMessage());
        }
    }
}

class TaskB extends Thread {

    private final Report sharedReport;

    // Receive the exact same shared object instance reference
    TaskB(Report sharedReport) {
        this.sharedReport = sharedReport;
    }

    @Override
    public void run() {
        try {
            // Synchronize access when checking the shared status
            synchronized (sharedReport) {
                // Always check status in a while loop to handle potential spurious wakeups cleanly
                while (!sharedReport.reportStatus) {
                    System.out.println(
                        "[Task B] Report not ready yet. Task B entering wait state..."
                    );

                    // Suspends Task B and releases the 'sharedReport' lock so Task A can enter it
                    sharedReport.wait();
                }

                // Once awakened and lock re-acquired, execution resumes right here
                System.out.println(
                    "[Task B] Resumed! Beginning final processing of the report data..."
                );
            }

            // Simulating final processing work
            Thread.sleep(1000);
            System.out.println(
                "[Task B] Final processing completed successfully!"
            );
        } catch (InterruptedException e) {
            System.err.println("[Task B] Interrupted: " + e.getMessage());
        }
    }
}

public class TCGem {

    public static void main(String[] args) {
        // 1. Create the single shared instance reference
        Report sharedReport = new Report();

        // 2. Pass the SAME object instance to both separate execution blocks
        TaskA t1 = new TaskA(sharedReport);
        TaskB t2 = new TaskB(sharedReport);

        try {
            // 3. Start BOTH threads right away. Task B will pause itself internally until Task A signals it.
            t2.start();

            // Short sleep in main to explicitly observe Task B starting up first and waiting
            Thread.sleep(200);
            t1.start();

            // 4. Main thread blocks until Task B finishes its post-report work
            t2.join();
        } catch (InterruptedException e) {
            System.err.println(
                "[Main] Thread execution interrupted: " + e.getMessage()
            );
        }

        // 5. Final message prints strictly after Task B completes
        System.out.println(
            "[Main] Entire sequence completed. Task Report is finalized."
        );
    }
}
