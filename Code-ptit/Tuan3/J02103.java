package Tuan3;

import java.util.ArrayList;
import java.util.Scanner;

public class J02103 {
    
    private static Scanner sc = new Scanner(System.in);

    public static ArrayList< ArrayList<Integer> > getMtcv(ArrayList< ArrayList<Integer> > a){
        Integer n = a.size();
        Integer m = a.get(0).size();

        ArrayList< ArrayList<Integer> > a_T = new ArrayList<>();
        for(int i=0; i<m; i++){
            ArrayList<Integer> motHang= new ArrayList<>();

            for(int j=0; j<n; j++){
                Integer temp = a.get(j).get(i);

                motHang.add(temp);
            }
            a_T.add(motHang);
        }
        return a_T;
    }

    public static ArrayList< ArrayList<Integer> > getTichmatran
    (
        ArrayList< ArrayList<Integer> > a,
        ArrayList< ArrayList<Integer> > b
    )
    {
        Integer a_sohang = a.size();
        Integer a_socot = a.get(0).size();

        Integer b_sohang = b.size();
        Integer b_socot = b.get(0).size();

        if(a_socot != b_sohang){
            return null;
        }

        ArrayList< ArrayList<Integer> > ketqua = new ArrayList<>();
        for(int i=0; i<a_sohang; i++){
            ArrayList<Integer> motHang = new ArrayList<>();
            for(int j=0; j<b_socot; j++){
                motHang.add(0);
            }
            ketqua.add(motHang);
        }

        for(int i=0; i<a_sohang; i++){
            for(int j=0; j<b_socot; j++){
                Integer temp1 = 0;
                for(int k=0; k<a_socot; k++){
                    temp1 = temp1 + a.get(i).get(k) * b.get(k).get(j);
                }
                ketqua.get(i).set(j, temp1);
            }
        }

        return ketqua;
    }

    public static void inra(ArrayList< ArrayList<Integer> > a) {
        for(int i=0; i<a.size(); i++){
            for(int j =0; j<a.get(i).size(); j++){
                System.out.print(a.get(i).get(j)+ " ");
            }
            System.out.println("");
        }
    }

    public static void xuLy(Integer stt){
        Integer n = sc.nextInt();
        Integer m = sc.nextInt();

        ArrayList< ArrayList<Integer> > a = new ArrayList<>();

        for(int i=0; i<n; i++){
            ArrayList<Integer> motHang = new ArrayList<>();
            for(int j=0; j<m; j++){
                Integer temp1 = sc.nextInt();

                motHang.add(temp1);
            }
            a.add(motHang);
        }

        ArrayList< ArrayList<Integer> > a_T = getMtcv(a);

        ArrayList< ArrayList<Integer> > ketqua = getTichmatran(a, a_T);

        System.out.println("Test "+ (stt+1)+ ": ");
        inra(ketqua);
        // System.out.println(ketqua.toString());

    }

    public static void main(String[] args) {
        Integer sobotest = sc.nextInt();

        for(int i=0; i<sobotest; i++) {
            xuLy(i);
        }
    }
}
