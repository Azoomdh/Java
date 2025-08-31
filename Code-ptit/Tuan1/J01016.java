package Tuan1;

import java.util.Scanner;

public class J01016 {
    private static Scanner sc1 = new Scanner(System.in);

    public static void main(String[] args) {
        String s = sc1.next();

        Integer sum=0;

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='4' || s.charAt(i)=='7'){
                sum++;
            }
            else{
                // doesn't do
            }
        }
        if(sum==4 || sum==7){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }
    }
}
