import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

public class J03010 {

    private static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {
        Integer sobotest = Integer.valueOf(sc.nextLine());

        ArrayList<String> dsTienToEmail = new ArrayList<>();

        while(sobotest-- >0){
            String hoTenChuaChuanHoa = sc.nextLine();

            StringTokenizer stringTokenizer1 = new StringTokenizer(hoTenChuaChuanHoa, " ");

            ArrayList<String> a = new ArrayList<>();

            while(stringTokenizer1.hasMoreTokens()==true ){
                String o1 = stringTokenizer1.nextToken().toLowerCase();
                a.add(o1);
            }

            StringBuilder hoTenDaChuanHoa = new StringBuilder();

            hoTenDaChuanHoa.append(a.get(a.size()-1) );
            for(int i=0; i<a.size()-1; i++){
                hoTenDaChuanHoa.append(a.get(i).charAt(0) );
            }



            Integer soluong = Collections.frequency(dsTienToEmail, hoTenDaChuanHoa.toString());
            if(soluong >=1){
                System.out.println(hoTenDaChuanHoa.toString()+ (soluong+1) + "@ptit.edu.vn");
            }
            else {
                System.out.println(hoTenDaChuanHoa.toString()+ "@ptit.edu.vn");
            }

            dsTienToEmail.add(hoTenDaChuanHoa.toString());

        }
    }
}

/*
4
    nGUYEn    quaNG   vInH  
   tRan   thi THU    huOnG
   nGO   quoC  VINH
 lE            tuAn    aNH
*/