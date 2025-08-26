import java.util.Scanner;

public class J01025 {
    private static Scanner sc1= new Scanner(System.in);

    public static void main(String[] args) {
        Integer a0, a1, a2, a3;
        a0 = sc1.nextInt();
        a1 = sc1.nextInt();

        a2 = sc1.nextInt();
        a3 = sc1.nextInt();

        Integer b0, b1, b2, b3;
        b0 = sc1.nextInt();
        b1 = sc1.nextInt();

        b2 = sc1.nextInt();
        b3 = sc1.nextInt();

        Integer c0 = Math.min(a0, b0);
        Integer c1 = Math.min(a1, b1);
        Integer c2 = Math.max(a2, b2);
        Integer c3 = Math.max(a3, b3);

        Integer d= Math.max(
            Math.abs(c0-c2),
            Math.abs(c1-c3)
        );

        System.out.println(d*d);
    }
}
