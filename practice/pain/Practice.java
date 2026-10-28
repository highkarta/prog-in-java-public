package practice.pain;

import java.util.*;

/**
 * Practice
 */
public class Practice {

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        a.add(10);
        a.add(20);
        a.add(30);
        a.add(40); // results in ConcurrentModificationException. Even if you write 20, still error
        /*
        for (Integer el : a) { // if you use int, it results in an exception (Wrapper -> Primitive is unboxing)
            // foreach doesn't maintain a cursor, so once you remove an element, the cursor is not updated and hence results in Concurrent...
            if (el == 20) {
                a.remove(el);
            }
        }
        */

        Iterator<Integer> it = a.iterator(); // unidirectional while listIterator is bidirectional
        while(it.hasNext()){
            if(it.next().equals(20)){ // it.next() == 20 also works
                // a.remove(it.next()); // doesn't work with iterator
                it.remove();
            }
        }
        
        System.out.println(a);

        List<Integer> b = new ArrayList<>();
        Collections.addAll(b, 2, 3, 4, 5);
        System.out.println(b); 

        List<Student> stu = new ArrayList<>(); // sort based on Student's roll no
        // stu.roll;
        Comparator<Integer> asc = new Comparator<>(){
            public int compare(Integer a, Integer b){
                if(a < b) return -1;
                else if(a > b) return 1;
                else return 0;
            }
        };

        Map<Character, Integer> count = new HashMap<>();
        
        Collections.sort(stu, asc);
        sortAsc(stu);
        /*
        count.put(null, 200);
        count.putIfAbsent(key, value)
        count.compu
        */
        // null a = null;
    }

    static void sortAsc(List<Student> arr){
        for (Student el : arr) {
            System.out.println(el + " ");
        }
    }
}
