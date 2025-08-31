package Tuan3;


import java.util.ArrayList;
import java.util.Scanner;

public class J02014 {
    private static Scanner sc1 = new Scanner(System.in);

    public static void xuLy(){
        Integer n = sc1.nextInt();
        ArrayList<Integer> a= new ArrayList<>();

        Integer sum=0;

        for(int i=0; i<n; i++){
            Integer temp1 = sc1.nextInt();
            a.add(temp1);
            sum = sum+ temp1;
        }

        Integer sum2=0;

        for(int i=0; i<a.size()-1; i++){
            // System.out.println("🟩"+sum2+"🟩"+a.get(i)+"🟩"+(sum-a.get(i)-sum2));
            if(sum2 == (sum-a.get(i)-sum2) ){
                System.out.println(i+1);
                return;
            }
            sum2 = sum2+ a.get(i);
        }
        System.out.println(-1);
        return;
    }

    public static void main(String[] args) {
        Integer sobotest = sc1.nextInt();

        while(sobotest-- >0){
            xuLy();
        }
    }
}
