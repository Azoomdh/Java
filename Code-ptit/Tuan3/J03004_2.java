package Tuan3;

import java.util.Scanner;
import java.util.StringTokenizer;

public class J03004_2 {
    
    private static Scanner sc = new Scanner(System.in);

    public static void xuLy(){

        StringBuilder stringBuilder = new StringBuilder();

        String hoTen = sc.nextLine();
        hoTen = hoTen.trim();
        hoTen = hoTen.toLowerCase();

        StringTokenizer stringTokenizer = new StringTokenizer(hoTen);

        while(stringTokenizer.hasMoreTokens()== true){
            String motTu = stringTokenizer.nextToken();

            stringBuilder.append(Character.toUpperCase(motTu.charAt(0) ) );
            stringBuilder.append(motTu.substring(1) );
            stringBuilder.append(" ");
        }
        String hoTenDaChuanHoa = stringBuilder.toString().trim();
        System.out.println(hoTenDaChuanHoa);
    }

    public static void main(String[] args) {
        Integer sobotest = Integer.parseInt(sc.nextLine());

        while(sobotest-- >0){
            xuLy();
        }
    }
}
