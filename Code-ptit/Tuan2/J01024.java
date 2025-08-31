import java.util.Scanner;

public class J01024 {
    private static Scanner sc1 = new Scanner(System.in);

    public static Boolean isOk(String s){
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)!='0' && s.charAt(i)!='1' && s.charAt(i)!='2'){
                return false;
            }
        }
        return true;
    }

    public static void xuLy(){
        String s = sc1.next();
        if(isOk(s)==true){
            System.out.println("YES");
        }
        else{
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
