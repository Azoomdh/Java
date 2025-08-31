package Tuan3;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

// https://chatgpt.com/share/68af35b1-dd48-8007-929c-f4a56219734f
// hướng dẫn bằng chat gpt

public class J03004 {
    
    private static Scanner sc= new Scanner(System.in);

    public static void xuLy(){
        String hoten = sc.nextLine();

        StringBuilder stringBuilder = new StringBuilder();

        hoten = hoten.trim();
        hoten = hoten.toLowerCase();
        StringTokenizer stringTokenizer = new StringTokenizer(hoten);

        while(stringTokenizer.hasMoreTokens()== true){
            String motTu = stringTokenizer.nextToken();

            stringBuilder.append(Character.toUpperCase(motTu.charAt(0)));
            stringBuilder.append(motTu.substring(1));
            stringBuilder.append(" ");
        }
        String hotenDaChuanHoa = stringBuilder.toString().trim();
        System.out.println(hotenDaChuanHoa);
    }

    public static void main(String[] args) {
        Integer sobotest = Integer.parseInt(sc.nextLine());

        while(sobotest-- >0){
            xuLy();
        }
    }
}
