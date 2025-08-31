package Tuan1;

import java.util.Scanner;

public class J01001 {
    public static void main(String[] args) {
        try
            (Scanner sc1 = new Scanner(System.in)) 
            {
                int cd = sc1.nextInt();
                int cr = sc1.nextInt();

                if(cd<=0 || cr<=0){
                    System.out.println("0");
                }
                else {
                    System.out.println(2*(cd+cr) + " " +cd*cr);
                }
            }
    }
}
