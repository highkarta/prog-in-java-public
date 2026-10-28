package practice;

import java.io.*;
// import java.io.FileWriter;
// import java.io.IOException;
import java.util.Scanner;

class MyThread extends Thread {

    // @Override
    public void run() {
        // we are overriding an already existing function
        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            // n(n+1)/2
            sum = sum + i;
            System.out.println(this.getName() + " " + sum); // getName() returns the thread's name
        }
    }
}

class FileThread extends Thread {

    // it's a worker thread

    FileWriter fw;
    String name;
    String pwd;
    boolean isWriting = true;

    FileThread(String name, String pwd, FileWriter fw) {
        this.name = name;
        this.pwd = pwd;
        this.fw = fw;
    }

    public void run() {
        synchronized (fw) {
            try {
                /*
                File f = new File("login.txt");
                if (!f.exists()) {
                    f.createNewFile();
                }

                FileWriter fw = new FileWriter(f);
                fw.close();
                */

                fw.write("name  " + this.name); // this is optional
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                fw.write(" pwd " + this.pwd + "\n");
                fw.flush();

                /*
            BufferedWriter bw = new BufferedWriter(fw);
            bw.append(name);
            bw.append(" ");
            bw.append(pwd);
            // String s = fr.readAllAsString();
            // System.out.println(s);
            bw.close();
            isWriting = false;
            */
            } catch (IOException e) {
                e.printStackTrace();
                // System.out.println(IOException.getMessage());
            } finally {
                // fw.close();
                // bw.close();
            }
        }
    }

    /*
    boolean writingStatus() {
        return isWriting;
    }
    */
}

class ObjectCreator extends Thread {

    public Student ref = null;

    // ObjectCreator(Student[] ref){
    // this.ref = ref;
    // }

    public void run() {
        // take input from user
        Student s = new Student(20, "Hello");
        ref = s;
        // System.out.println(s.getName());
    }

    Student getRef() {
        return ref;
    }
}

/*
// fix this
class FileHandle extends Thread {

    public void run() {
        File f = new File("Hello.txt");
        if (!f.exists()) {
            f.createNewFile();
        }
        FileReader fr = new FileReader(f);
        String s = fr.readAllAsString();
        System.out.println(s);
        fr.close();
    }
}
*/

class Student {

    private int roll;
    private String name;

    Student(int roll, String name) {
        this.roll = roll;
        this.name = name;
    }

    void setRoll(int roll) {
        this.roll = roll;
    }

    void setName(String name) {
        this.name = name;
    }

    int getRoll() {
        return roll;
    }

    String getName() {
        return name;
    }
}

class Calculator extends Thread {

    public void run() {
        Scanner sc = new Scanner(System.in);

        int count = 0;
        int res = 0;
        int a, b;

        while (count < 10) {
            if (count == 0) {
                System.out.println("enter operands: ");
                a = sc.nextInt();
                b = sc.nextInt();
            } else {
                a = res;
                System.out.println("add 2nd operand: ");
                b = sc.nextInt();
            }

            System.out.println("enter operation: ");
            int op = sc.nextInt();

            switch (op) {
                case 1:
                    res = a + b;
                    break;
                case 2:
                    res = a - b;
                    break;
                case 3:
                    res = a * b;
                    break;
                case 4:
                    res = a / b;
                    break;
                default:
                    System.out.println("error");
                    break;
            }
            count++;
        }
        System.out.println(res);
        sc.close();
    }
}

class SumTill100 extends Thread {

    public void run() {
        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            sum += i;
        }
        System.out.println(sum);
    }
}

class MultiThreading {

    public static void main(String[] args)
        throws InterruptedException, IOException {
        // or just right throws Exception
        /*
        MyThread mt = new MyThread();
        mt.start(); // it only takes the thread to ready state. Running only happens when processor wants it, we have no control on the running state.

        MyThread mt1 = new MyThread();
        mt1.start(); // creating multiple threads and context switch happens whenever the processor wants to

        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            sum = sum + i;
            System.out.println(Thread.currentThread().getName() + " " + sum);
        }
        */

        // Calculator c = new Calculator();
        // c.start();

        // SumTill100 s = new SumTill100();
        // s.start();

        // Student[] s = new Student[10];
        ObjectCreator oc = new ObjectCreator();
        oc.start();
        oc.join(); // have to handle the InterruptedException. If you wouldn't have join here, it might have happened that main thread would execute before oc thread and hence student s will store a null reference. join() tells the processor to first complete finishing oc and then execute the main thread further. Kinda like async-await from js
        // System.out.println(oc.getRef()); // oc.ref
        Student s = oc.ref; // this line might get executed before oc.start() even occurs because main and oc objectcreatoro threads are working independently
        // Student s = oc.getRef(); // still null
        System.out.println(s.getName()); // null

        Scanner sc = new Scanner(System.in);
        FileWriter fw = new FileWriter("new.txt");
        String name, pwd;
        int count = 0;

        while (count < 5) {
            System.out.print("Enter name: ");
            name = sc.nextLine();
            System.out.print("Enter pwd: ");
            pwd = sc.nextLine(); // nextLine() necessary
            FileThread ft = new FileThread(name, pwd, fw);
            ft.start();
            count++;
        }

        // boolean isWriting = true;
        /*
        while (ft.writingStatus()) {
            System.out.print('*');
        }
        */

        // till the time name and all is being written in the file, show ****
        sc.close();
    }
}
