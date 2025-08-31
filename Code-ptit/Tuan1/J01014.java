package Tuan1;

import java.util.Scanner;

public class J01014 {
    private static Scanner sc1= new Scanner(System.in);

    public static void xuLy(){
        Long n= sc1.nextLong();

        Long uocSntMax = 0L;

        Double sqrt_n = Math.sqrt(n);
        for(Long i=2L; i<=sqrt_n; i++){
            while(n%i==0L){
                uocSntMax = i;
                n=n/i;
            }
            if(n==1){
                break;
            }
        }
        if(n>1){
            uocSntMax=n;
        }
        System.out.println(uocSntMax);
    }

    public static void main(String[] args) {
        Integer sobotest= sc1.nextInt();

        while(sobotest-- >0){
            xuLy();
        }
    }
}
