package practice;

/**
 * Student
 */
public class Batch1 {

    // m and n do define the state of Batch, so they must be defined in batch itself
    private int m; // cannot be called from main function
    private int n;
    private int[][] marks;

    // has-a relation => aggregation (hence not inheritance)
    // Entity classes vs. utility classes: entity classes are created for real-world stuff, basically nouns. They don't contain any utility functions, they only contain the info that is related just to them, rest all functionalities are to be created in a separate utility class. It only contains the functions and variables that directly implements any of it's states. For eg: displayTopper() is a utility that should not be associated with Student class

    int getM(){
        return m;
    }

    int getN(){
        return n;
    }

    int[][] getMarks(){
        return marks;
    }

    Batch(int m, int n, int[] stud1, int[] stud2) {
        this.m = m;
        this.n = n;
        // m = marks.length;
        // n = marks[0].length;
        // this.marks = marks; // would this work just for copying a 2d array into a local 2d array
        marks = new int[m][n];
        copy(marks, 0, stud1);
        copy(marks, 1, stud2);
   }

   void setM(int m){
       this.m = m;
   }

   void setN(int n){
       this.n = n;
   }

   void setMarks(int[][] marks){
       this.marks = marks;
   }

    void copy(int[][] marks, int m, int[] stud) {
        for (int i = 0; i < stud.length; i++) {
            marks[m][i] = stud[i];
        }
    }

    void displayMarks() {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(marks[i][j] + " ");
            }
            System.out.println();
        }
    }

    /*
    int calculateTotal() {
        int total = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                total += marks[i][j];
            }
        }
        return total;
    }

    void sortMarks() {}

    int findTopper() {
        int max = 0;
        int curr = 0;
        int stu = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                curr += marks[i][j];
            }
            if (curr > max) {
                max = curr;
                stu = i;
            }
            curr = 0;
        }
        return stu + 1;
    }
    */

    public static void main(String[] args) {
        /*
        int[][] marks = {
            { 20, 30, 80, 70 },
            { 2, 3, 4, 5 },
            { 30, 60, 90, 90 },
            { 100, 100, 100, 100 },
        };
        */

        int m = 2;
        int n = 4;
        int[] stu1 = { 20, 30, 80, 70 };
        int[] stu2 = { 2, 3, 4, 5 };
        Batch a = new Batch(m, n, stu1, stu2);
        // Batch b = new Batch(m, n, new int[] {1, 2, 3, 4}, new int[] {4, 5, 6, 7}); // can pass arrays as arguments like this too!
        a.displayMarks();
        // System.out.println(val);
    }
}
