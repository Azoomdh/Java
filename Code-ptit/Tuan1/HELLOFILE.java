package Tuan1;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HELLOFILE {
    public static void main(String[] args) {
        try 
            (
                Scanner sc1 = new Scanner(new File("Hello.txt"))
            ) 
            {
                while(sc1.hasNext()){
                    System.out.println(sc1.nextLine());
                }
            }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
