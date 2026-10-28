package practice.pain;

/**
 * Student
 */
public class Student {
        String name;
        int roll;

        Student(String name, int roll){
            this.name = name;
            this.roll = roll;
        }
    public static void main(String[] args) {
        Student s1 = new Student("karta", 191);
        Student s2 = new Student("whatever", 203);
    }
}