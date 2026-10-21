package practice;

/**
 * Student
 */
public class Student {

    private String stuName;
    private int[] marks;

    Student(String stuName, int[] marks) {
        this.stuName = stuName;
        this.marks = marks;
    }

    void setStuName(String stuName) {
        this.stuName = stuName;
    }

    void setMarks(int[] marks) {
        this.marks = marks;
    }

    String getStuName() {
        return stuName;
    }

    int[] getMarks() {
        return marks;
    }
}
