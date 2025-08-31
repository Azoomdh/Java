package Tuan3;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
4
    nGUYEn    quaNG   vInH  
   tRan   thi THU    huOnG
   nGO   quoC  VINH
 lE            tuAn    aNH
*/

public class J03005 {
    
    private static Scanner sc = new Scanner(System.in);

    public static String bienDoiMotTu(String motTu){
        String motTu2 = 
            Character.toUpperCase(motTu.charAt(0)) 
            + motTu.substring(1);

        return motTu2;
    }

    public static void inra(ArrayList<String> hoTen_arraylist){
        StringBuilder stringBuilder = new StringBuilder();

        for(int i=1; i<hoTen_arraylist.size(); i++){
            stringBuilder.append(hoTen_arraylist.get(i));
            stringBuilder.append(" ");
        }

        String hoTen2= stringBuilder.toString().trim();

        hoTen2 = hoTen2 + ", "+ hoTen_arraylist.get(0).toUpperCase();

        System.out.println(hoTen2);
    }

    public static void xuLy(){
        String hoTen = sc.nextLine();
        
        hoTen = hoTen.trim();
        hoTen = hoTen.toLowerCase();

        StringTokenizer stringTokenizer = new StringTokenizer(hoTen);

        ArrayList<String> tenDaChuanHoa_arraylist = new ArrayList<>();

        while(stringTokenizer.hasMoreTokens()== true ){
            String motTu = stringTokenizer.nextToken();

            motTu = bienDoiMotTu(motTu);

            tenDaChuanHoa_arraylist.add(motTu);
        }
        // System.out.println(tenDaChuanHoa.toString());
        inra(tenDaChuanHoa_arraylist);
    }

    public static void main(String[] args) {
        Integer sobotest = Integer.parseInt(sc.nextLine());
        
        while(sobotest-- >0){
            xuLy();
        }
    }
}
