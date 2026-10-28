package practice.pain;

import java.io.*;
import java.util.*;

/**
 * Handling
 */
public class Handling {

    public static void main(String[] args) throws Exception { // mandatory to write throws Exception
        try {
            File f = new File("abc.txt");
            if (!f.exists()) {
                // f.createNewFile();
                throw new FileNotFoundException("File not found");
            }
        } catch (FileNotFoundException f) {
            System.out.println(f.getMessage());
        } catch (EOFException e) {
            System.out.println(e.getMessage());
        }
    }
}
