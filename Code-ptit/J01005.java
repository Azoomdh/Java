import java.util.Scanner;

public class J01005 {
    
    public static Scanner sc1= new Scanner(System.in);

    public static void xuLy(){
        Long n = sc1.nextLong();
        Long h = sc1.nextLong();

        for(Double i= 1d; i<n; i++){
            Double khoangCach = h* Math.sqrt(i/n);
            String strSeIn = String.format("%.6f ", khoangCach);
            System.out.print(strSeIn);
        }
        System.out.println();

    }
    public static void main(String[] args) {
        Integer sobotest = sc1.nextInt();

        while(sobotest-- >0){
            xuLy();
        }
    }
}
