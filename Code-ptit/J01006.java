import java.util.ArrayList;
import java.util.Scanner;

public class J01006 {

    public static Scanner sc1= new Scanner(System.in);
    public static ArrayList<Long> fibo= new ArrayList<>();

    public static void chuanBi(){
        fibo.add(1L);
        fibo.add(1L);
        for(int i=2; i<92; i++){
            Long a = fibo.get(i-1)+ fibo.get(i-2);
            fibo.add(a);
        }
        // System.out.println(fibo.toString());
    }

    public static void xuLy(){
        Integer n = sc1.nextInt();

        System.out.println(fibo.get(n-1));
    }

    public static void main(String[] args) {
        Integer sobotest = sc1.nextInt();
        
        chuanBi();
        
        while(sobotest-- >0){
            xuLy();
        }
    }
}
