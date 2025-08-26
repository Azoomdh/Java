import java.util.Scanner;

public class J01004 {
    public static Scanner sc1 = new Scanner(System.in);

    public static Boolean checkSNT(Long n){
        if(n<=1){
            return false;
        }
        if(n==2){
            return true;
        }
        if(n%2 == 0){
            return false;
        }
        Double cbh = Math.sqrt(n);
        for(Long i=3L; i<= cbh; i++){
            if(n%i == 0){
                return false;
            }
        }
        return true;
    }

    public static void xuLy(){
        Long n = sc1.nextLong();

        if(checkSNT(n)== true){
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
    }
    public static void main(String[] args) {
        Integer sobotest = sc1.nextInt();

        while(sobotest-- >0){
            xuLy();
        }
    }
}
