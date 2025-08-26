import java.util.Scanner;

public class J01026 {
    private static Scanner sc1= new Scanner(System.in);

    public static void xuLy(){
        Integer n = sc1.nextInt();

        Integer sqrt_n = (int)Math.sqrt(n);

        if(n== sqrt_n*sqrt_n){
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
    }

    public static void main(String[] args) {
        Integer sobotest= sc1.nextInt();

        while(sobotest-- >0){
            xuLy();
        }
    }
}
