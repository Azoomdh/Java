import java.util.Scanner;

public class J03026 {

    private static Scanner sc = new Scanner(System.in);

    public static void xuLy(){
        String s1 = sc.next();
        String s2 = sc.next();

        if(s1.equals(s2)== true ) {
            System.out.println(-1);
            return;
        }
        else {
            System.out.println(Math.max(s1.length(), s2.length() ) );
            return;
        }
    }

    public static void main(String[] args) {
        Integer sobotest = sc.nextInt();

        while(sobotest-- >0){
            xuLy();
        }
    }
}

/*
2
abcd
defgh
a
a
*/