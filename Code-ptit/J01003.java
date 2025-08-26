import java.util.Scanner;

public class J01003 {
    public static Scanner sc1= new Scanner(System.in);
    public static void main(String[] args) {
        Float a = sc1.nextFloat();
        Float b = sc1.nextFloat();

        if(a==0f && b==0f){
            System.out.println("VSN");
        }
        else if (a==0f && b!=0f){
            System.out.println("VN");
        }
        else {
            System.out.println(String.format("%.2f", -b/a));
        }
    }
}
