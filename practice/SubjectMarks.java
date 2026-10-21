package practice;

/**
 * SubjectMarks
 */
public class SubjectMarks {

    private String subjectName;
    private int subjectMarks;

    void setSubjectName(String subjectName){
        this.subjectName = subjectName;
    }

    void setMarks(int subjectMarks){
        this.subjectMarks = subjectMarks;
    }

    String getSubjectName(){
        return subjectName;
    }

    int getSubjectMarks(){
        return subjectMarks;
    }

    SubjectMarks(String subjectName, int subjectMarks) {
        this.subjectName = subjectName;
        this.subjectMarks = subjectMarks;
    }
}
