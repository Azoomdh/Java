import java.util.Scanner;

public class J02008 {
    private static Scanner sc1 = new Scanner(System.in);

    public static Long getUcln(Long a, Long b){
        while(a!=0 && b!=0){
            if(a>b){
                a=a%b;
            }
            else{
                b=b%a;
            }
        }
        // if(a!=0){
        //     return a;
        // }
        // else {
        //     return b;
        // }

        return a+b;
    }

    public static Long getBcnn(Long a, Long b){
        return a/getUcln(a, b) *b;
    }

    public static void xuLy(){
        Long n = sc1.nextLong();

        Long bcnn = 1L; 

        for(Long i=1L; i<=n; i++){
            bcnn = getBcnn(i, bcnn);
        }

        System.out.println(bcnn);
    }

    public static void main(String[] args) {
        Integer sobotest = sc1.nextInt();

        while(sobotest-- >0){
            xuLy();
        }
    }
}
