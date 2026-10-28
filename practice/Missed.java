package practice;

// Q1

class Student{
    String name;
    int age;

}

public class Missed {
    public static void main(String[] args) {
        Student s=new Student();
        s.name="Ankit";
        s.age=20;
        System.out.println(s.name);
    }
}

// // Q2 (Constructor function is undefined(Parameterised))
// // Identifiers(not reserved keywords) can be reused. The one found earlier in lexical scoping that one is used.

// class Employee{
//    String name;

//    Employee (String name)
//    {
//     this.name=name;
//    }
   
//    void Employee(String n)
//    {
//     name=n;
//    }
// }

// public class Main{
//     public static void main(String[] args) {
//         Employee e = new Employee("Amit");
//         System.out.println(e.name);
//     }
// }

// // Q3(Identifiers can be used with different different functions and variables. sam concept as previous question)

// class Book{
//     String title;
//     Book(String title)
//         {
//             // title=title (error was in this line)
//             this.title=title;
//         }
// }

// public class Main{
//     public static void main(String[] args) {
//         Book b = new Book("Java");
//         System.out.println(b.title);
//     }
// }


// // Q4

// class BankAccount{
//     double balance = 5000;
//     void displayBalance(){
//         System.out.println(balance);
//     }
// }
// public class Main{    
//     public static void main(String[] args) {
//         BankAccount account = null;
//     try {
//                 account.displayBalance();
//             }
//             catch(Exception e){
//                 System.out.println("error");
//             }
//         }
// }
    
// // Q5

// class Counter{
//     static int count =0;
//     void increment()
//     {
//         count++;
//     }
// }

// public class Main{
//     public static void main(String[] args) {
//         Counter c1 = new Counter();
//         Counter c2 = new Counter();

//         c1.increment();
//         c2.increment();
//         c1.increment();
//         System.out.println(c1.count);
//         System.out.println(c2.count);
//     }
// }

// // Q6(predefined expception pehle aayegi custom exception se kyuki hum vaha tak pohonch nhi payenge)

// public class Main{
//     public static void main(String[] args) {
//         {
//             try{
//                 int [] arr = new int[3];
//                 System.out.println(arr[5]);
//             }
//             catch(ArrayIndexOutOfBoundsException e)
//             {
//                 System.out.println("Invalid index");
//             }
//             catch(Exception e)
//             {
//              System.out.println("General Exc");   
//             }
//         }
//     }
// }


// File file = new File("abc.txt");
        
//         try {
//             FileReader fr = new FileReader(file); 
//             System.out.println("File opened successfully.");
//         } 
//          catch (FileNotFoundException e) 
//          {
//             System.out.println("Error: The specified file could not be found.");
//         }