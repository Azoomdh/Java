import java.math.BigInteger;
import java.util.Scanner;

public class J03015 {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        BigInteger a = sc.nextBigInteger();
        BigInteger b = sc.nextBigInteger();

        BigInteger hieu_ab = a.subtract(b);

        System.out.println(hieu_ab);
    }
}
