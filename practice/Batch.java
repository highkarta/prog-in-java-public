package practice;

/**
 * Batch
 */
public class Batch {

    private Student[] stu;
    private int groupNo;
    private int year;

    int getGroupNo() {
        return groupNo;
    }

    int getYear() {
        return year;
    }

    void setGroupNo(int groupNo) {
        this.groupNo = groupNo;
    }

    void setYear(int year) {
        this.year = year;
    }

    Batch(int batchSize, int grp, int year) {
        this.stu = new Student[batchSize];
        this.groupNo = grp;
        this.year = year;
    }

    public static void main(String[] args) {
        Batch b1 = new Batch(50, 1, 2029);
        Batch b2 = new Batch(60, 2, 2028);
    }
}
