import java.util.Scanner;

public class J01021_x {
    private static Scanner sc1= new Scanner(System.in);
    private static final int MOD = (int) 1e9 +7;

    // public static long pow(long a, long b){
    //     if(b==0){
    //         return 1;
    //     }
    //     if(b==1){
    //         return a%MOD;
    //     }
    //     long temp1 = pow(a, b/2);
    //     if(b%2==0){
    //         return (temp1*temp1)%MOD;
    //     }
    //     return ((temp1*temp1)%MOD )%MOD;
    // }

    public static void main(String[] args) {
        while(true){
            long a = sc1.nextLong();
            long b = sc1.nextLong();
            if(a==0 && b==0){
                return;
            }
            System.out.println((long) (Math.pow(a,b)%MOD));
        }
    }
}
