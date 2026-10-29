package practice.taskCoordination;

/**
 * Report
 */

class Report {

    boolean reportStatus = false;
}

class TaskA extends Thread {

    boolean localStatus;

    TaskA(boolean receivedStatus) {
        this.localStatus = receivedStatus;
    }

    public void run() {
        // while (!reportStatus) {
        // }
        for (int i = 0; i < 50; i++) {
            System.out.println("printing...");
        }
        System.out.println("report is ready");
        localStatus = true;
    }
}

class TaskB extends Thread {

    boolean t1;

    TaskB(boolean t1) {
        this.t1 = t1;
    }

    public void run() {
        System.out.println(t1);
        while (!t1) {
            System.out.println("waiting for taskA to finish executing");
        }
        System.out.println("final processing done");
    }
}

public class TaskCoordination {

    public static void main(String[] args) throws Exception {
        Report r = new Report();
        TaskA t1 = new TaskA(r.reportStatus);
        TaskB t2 = new TaskB(t1.localStatus);
        try {
            t1.start();
            TaskA.sleep(1000); // correct way to access it statically
            t1.join();
            t2.start();
            t2.join();
        } catch (InterruptedException e) {
            e.getMessage();
        }
        System.out.println("Task Report is ready");
    }
}
