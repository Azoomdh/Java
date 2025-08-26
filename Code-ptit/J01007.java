import java.util.ArrayList;
import java.util.Scanner;

public class J01007 {
    public static Scanner sc1= new Scanner(System.in);

    public static ArrayList<Long> dayFibo = new ArrayList<>();

    public static void chuanBi(){
        dayFibo.add(0L);
        dayFibo.add(1L);

        for(int i=2 ; i<100; i++){
            Long fibo = dayFibo.get(i-1)+ dayFibo.get(i-2);
            dayFibo.add(fibo);
        }
        System.out.println(dayFibo.toString());
    }

    public static Boolean oTrongDayFibo(Long n){
        for(Long l1 : dayFibo){
            if(n== l1){
                return true;
            }
            else if (n <l1){
                return false;
            }
        }
        return false;
    }

    public static void xuLy(){
        long n = sc1.nextLong();
        
        if(oTrongDayFibo(n)== true){
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
    }

    public static void main(String[] args) {
        chuanBi();

        int sobotest = sc1.nextInt();

        while(sobotest-- >0){
            xuLy();
        }
    }
}
