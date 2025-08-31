package Tuan3;

import java.util.ArrayList;
import java.util.Scanner;

public class J02017_copy {
    private static Scanner sc1 = new Scanner(System.in);

    public static Boolean laSoLe(Integer n){
        if(n%2==0){
            return false;
        }
        else{
            return true;
        }
    }

    public static void main(String[] args) {
        Integer n = sc1.nextInt();
        ArrayList<Integer> a = new ArrayList<>();

        for(int i=0; i<n; i++){
            Integer temp1 = sc1.nextInt();
            a.add(temp1);
        }

        ArrayList<Integer> a2 = new ArrayList<>();

        Boolean chonNextLaSoLe= null;
        if(laSoLe(a.get(0))== true) {
            chonNextLaSoLe = true;
            a2.add(a.get(0));
            chonNextLaSoLe = !chonNextLaSoLe;
        }
        else if(laSoLe(a.get(0))== false) {
            chonNextLaSoLe = false;
            a2.add(a.get(0));
            chonNextLaSoLe = !chonNextLaSoLe;
        }
        

        for(int i=1; i<a.size(); i++){
            if(chonNextLaSoLe == true && laSoLe(a.get(i))==true){
                a2.add(a.get(i));
                chonNextLaSoLe = !chonNextLaSoLe;
            }
            else if (chonNextLaSoLe==true && laSoLe(a.get(i))==false){
                continue;
            }
            else if (chonNextLaSoLe==false && laSoLe(a.get(i))==false ){
                a2.add(a.get(i));
                chonNextLaSoLe = !chonNextLaSoLe;
            }
            else if (chonNextLaSoLe==false && laSoLe(a.get(i))==true){
                continue;
            }
        }

        // System.out.println(a2.toString());

        System.out.println(a2.size());
    }
}
