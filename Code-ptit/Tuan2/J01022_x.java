import java.util.ArrayList;
import java.util.Scanner;

public class J01022_x {
    private static Scanner sc1 = new Scanner(System.in);
    private static ArrayList<String> dsString= new ArrayList<>();

    public static void chuanBi(){
        dsString.add("0");
        dsString.add("0");
        dsString.add("1");

        for(int i=3; i<=92; i++){
            String s3= dsString.get(i-1)+ dsString.get(i-2);
            dsString.add(s3);
        }
        return;
    }

    public static void xuLy(){
        Integer n = sc1.nextInt();
        Integer k = sc1.nextInt();

        System.out.println(dsString.get(n).charAt(k));
    }

    public static void main(String[] args) {
        chuanBi();
        Integer sobotest = sc1.nextInt();
        
        while(sobotest-- >0){
            xuLy();
        }
    }
}
