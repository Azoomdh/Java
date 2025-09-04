import java.math.BigInteger;
import java.util.Scanner;

public class J03013 {
    
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Integer sobotest = sc.nextInt();

        while(sobotest-- >0){
            BigInteger a = sc.nextBigInteger();
            BigInteger b = sc.nextBigInteger();

            BigInteger absHieu_ab = a.subtract(b).abs();

            Integer maxlen = Math.max(a.toString().length(), b.toString().length());
            
            StringBuilder stringBuilder_absHieu_ab = new StringBuilder( absHieu_ab.toString() );

            while(stringBuilder_absHieu_ab.length() <maxlen){
                stringBuilder_absHieu_ab.insert(0, '0');
            }

            System.out.println(stringBuilder_absHieu_ab.toString());
        }
    }
}

/*
2
978
12977
100
1000000
*/