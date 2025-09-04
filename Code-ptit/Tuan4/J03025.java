import java.util.Scanner;

public class J03025 {

    // số lỗi =1
    private static Scanner sc = new Scanner(System.in);

    public static Boolean checkOk(String s){
        Integer n = s.length();
        Integer soloi = 0;

        for(int i=0; i<=(n-1)/2; i++ ){
            if(s.charAt(i)!= s.charAt(n-1-i) ){
                soloi++;
            }
        }
        if(soloi ==1){
            return true;
        }
        else if(soloi==0 && s.length()%2==1){
            return true;
        }
        else {
            return false;
        }
    }

    public static void xuLy(){
        String s = sc.next();

        if(checkOk(s)==true ){
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
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
3
abccaa
abbcca
abcda
*/
