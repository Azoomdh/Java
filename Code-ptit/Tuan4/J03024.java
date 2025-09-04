import java.util.Scanner;

public class J03024 {

    private static Scanner sc = new Scanner(System.in);

    public static Integer check(String s){
        Integer soSoChan = 0;
        Integer soSoLe = 0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if( c <'0' || c >'9'){
                return -1;
            }
            else {
                int n = c-'0';
                if(n%2 ==0){
                    soSoChan++;
                }
                else{
                    soSoLe++;
                }
            }
        }

        if(s.length()%2==0 && soSoChan > soSoLe){
            return 1;
        }
        else if(s.length()%2==1 && soSoLe > soSoChan){
            return 1;
        }
        else {
            return 0;
        }
    }

    public static void xuLy(){
        String s = sc.next();

        if(check(s)==-1){
            System.out.println("INVALID");
        }
        else if(check(s)==0){
            System.out.println("NO");
        }
        else {
            System.out.println("YES");
        }
    }

    public static void main(String[] args) {
        Integer sobotest = sc.nextInt();

        while(sobotest-- >0) {
            xuLy();
        }
    }
}

/*
3
01234aa32432432432534545b987978
1234567890123456789000
999999999999999999999999999999
*/