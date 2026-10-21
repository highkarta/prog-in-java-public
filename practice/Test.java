package practice;
import java.util.*;
import java.io.*;

class Test{
    public static void main(String[] args) throws Exception{
        try{
            FileReader fr = new FileReader("file.txt");
            if(fr.read() == -1){
                throw new FileNotFoundException("File not found");
            }
            int val = 10 / 0;
            System.out.println(val);
            // throw new ArithmeticException("invalid division"); // no need to throw it?
        }catch(FileNotFoundException f){
            System.out.println(f.getMessage());
        }catch(ArithmeticException e){
            System.out.prinln(e.getMessage());
        }finally{
            fr.close();
        }
    }
}