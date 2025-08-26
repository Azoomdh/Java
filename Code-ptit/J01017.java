import java.util.Scanner;

public class J01017 {
    private static Scanner sc1 = new Scanner(System.in);

    public static Boolean isOk(char a, char b){
        int x = a- '0';
        int y = b- '0';

        if(Math.abs(x-y)==1){
            return true;
        }
        else{
            return false;
        }
    }

    public static void xuLy(){
        String s = sc1.next();
        for(Integer i=0; i<s.length()-1; i++){
            if( isOk(s.charAt(i), s.charAt(i+1))==false ){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
        return;
    }

    public static void main(String[] args) {
        Integer sobotest = sc1.nextInt();

        while(sobotest-- >0){
            xuLy();
        }
    }
}
