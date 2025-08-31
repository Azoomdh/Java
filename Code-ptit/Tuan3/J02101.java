package Tuan3;

import java.util.ArrayList;
import java.util.Scanner;

public class J02101 {
    private static Scanner sc= new Scanner(System.in);

    public static void inra(ArrayList<Integer> motHang, Boolean sangPhai){
        if(sangPhai== true){
            for(int i=0; i<motHang.size(); i++){
                System.out.print(motHang.get(i)+ " ");
            }
            System.out.println("");
        }
        else if(sangPhai== false){
            for(int i=motHang.size()-1; i>-1; i--){
                System.out.print(motHang.get(i)+ " ");
            }
            System.out.println("");
        }
    }

    public static void xuLy(){
        Integer n = sc.nextInt();
        ArrayList< ArrayList<Integer> > a= new ArrayList<>();

        for(int i=0; i<n; i++){
            ArrayList<Integer> motHang = new ArrayList<>();
            for(int j=0; j<n; j++){
                Integer temp1 = sc.nextInt();
                motHang.add(temp1);
            }
            a.add(motHang);
        }

        Boolean sangPhai = true;
        for(int i=0; i<a.size(); i++){
            inra(a.get(i), sangPhai);
            sangPhai = !sangPhai;
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        Integer sobotest = sc.nextInt();

        while(sobotest-- >0){
            xuLy();
        }
    }
}
