package Tuan1;

import java.util.Scanner;

public class J01010 {
    public static Scanner sc1 = new Scanner(System.in);

    public static Long solve(String s){
        Long result=0L;

        for(int i=0; i< s.length(); i++){
            if(s.charAt(i)=='0' || s.charAt(i)=='8' || s.charAt(i)=='9'){
                result = result*10L;
            }
            else if( s.charAt(i)=='1' ){
                result = result*10L +1L;
            }
            else {
                result= -1L;
                return result;
            }
        }
        return result;
    }

    public static void xuLy(){
        String s = sc1.next();

        Long a = solve(s);
        if(a>0){
            System.out.println(a);
        }
        else{
            System.out.println("INVALID");
        }
    }

    public static void main(String[] args) {
        Integer sobotest = sc1.nextInt();

        for(int i=0; i<sobotest; i++){
            xuLy();
        }
    }
}
