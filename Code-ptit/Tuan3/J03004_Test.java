package Tuan3;

import java.util.Scanner;
import java.util.StringTokenizer;

public class J03004_Test {
    
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String s = "  ;;;; nGuYEN    ;;;;;    vAN;;a;;    naM";
        StringTokenizer st = new StringTokenizer(s, "an;A"); 
        // bất kỳ ký tự nào trong delim đều là phân tách

        System.out.println(st.countTokens());
        
        while(st.hasMoreTokens()== true){
            System.out.println(st.nextToken());
        }

        // while(st.hasMoreElements()== true){
        //     System.out.println(st.nextElement());
        // }
    }
}
