package practice;
import java.util.*;

/**
 * Batch2
 */
public class Batch2 extends Batch{
    Map<Student1, int[]> data = new HashMap<>();
    Student1 s = new Student1();

    void addValues(){
        for(int i = 0; i < m; i++){
            data.put(s, marks);
        }
    }

    public static void main(String[] args) {
	
    }
}