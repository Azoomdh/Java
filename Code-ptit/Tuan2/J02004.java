import java.util.ArrayList;
import java.util.Scanner;

public class J02004 {
    private static Scanner sc1 = new Scanner(System.in);

    public static Boolean isOk(ArrayList<Integer> a){
        for(int i=0; i<a.size()/2; i++){
            if(a.get(i) != a.get(a.size()-i-1) ){
                return false;
            }
        }
        return true;
    }

    public static void xuLy(){
        Integer a_length = sc1.nextInt();

        ArrayList<Integer> a = new ArrayList<>();

        for(int i=0; i<a_length; i++){
            Integer temp= sc1.nextInt();
            a.add(temp);
        }

        if(isOk(a)==true){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }
    }

    public static void main(String[] args) {
        Integer sobotest = sc1.nextInt();

        while (sobotest-- >0) {
            xuLy();
        }
    }
}
