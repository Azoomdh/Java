import java.math.BigInteger;
import java.util.Scanner;

public class J03011 {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Integer sobotest = sc.nextInt();

        while(sobotest-- >0){
            BigInteger a = sc.nextBigInteger();
            BigInteger b = sc.nextBigInteger();

            BigInteger ucln_ab = a.gcd(b);

            System.out.println(ucln_ab);
        }
    }
}
