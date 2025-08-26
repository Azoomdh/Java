import java.util.Scanner;

public class J01002 {
    public static Scanner sc1 = new Scanner(System.in);
    
    public static void xuLy(){
        Long n = sc1.nextLong();

        System.out.println(n*(n+1)/2);
    }
    public static void main(String[] args) {

        Integer sobotest= sc1.nextInt();

        while(sobotest-- >0){
            xuLy();
        }
    }
}
