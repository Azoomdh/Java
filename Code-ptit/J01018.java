import java.util.Scanner;

public class J01018 {
    private static Scanner sc1 = new Scanner(System.in);

    public static Boolean checkDK1(String s){
        // Tổng chữ số của N chia hết cho 10

        Integer sum=0;
        for(int i=0; i<s.length(); i++){
            int temp = s.charAt(i)-'0';
            sum = sum + temp;
        }

        if(sum%10 ==0){
            return true;
        }
        else{
            return false;
        }
    }

    public static Boolean isOk2(char a, char b){
        int x = a -'0';
        int y = b -'0';

        if(Math.abs(x-y)==2){
            return true;
        }
        else {
            return false;
        }
    }

    public static Boolean checkDK2(String s){
        // Các chữ số cạnh nhau đều khác nhau đúng 2 đơn vị

        for(int i=0; i<s.length()-1; i++){
            if(isOk2(s.charAt(i), s.charAt(i+1) )== false ){
                return false;
            }
        }
        return true;
    }

    public static void xuLy(){
        String s = sc1.next();

        if(checkDK1(s)==true && checkDK2(s)==true ){
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
