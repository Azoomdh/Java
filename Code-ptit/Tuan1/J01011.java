package Tuan1;

import java.util.Scanner;

public class J01011 {
    
    public static Scanner sc1 = new Scanner(System.in);

    public static Long getUcln(Long a, Long b){
        while(b!=0){
            Long temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }

    public static Long getBcnn(Long a, Long b){
        return a/getUcln(a, b) *b;
    }

    public static void xuLy(){
        Long a = sc1.nextLong();
        Long b = sc1.nextLong();

        Long ucln1 = getUcln(a, b);
        Long bcnn1 = a/ucln1 *b;

        System.out.println(bcnn1 + " "+ ucln1+" ");
    }

    public static void main(String[] args) {
        Integer sobotest = sc1.nextInt();

        for(int i=0; i< sobotest; i++){
            xuLy();
        }
    }
}
