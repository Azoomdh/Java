package Tuan3;

import java.util.ArrayList;
import java.util.Scanner;

public class J02017 {
    private static Scanner sc1 = new Scanner(System.in);

    public static Integer viTriKhongThoaMan(ArrayList<Integer> a){
        for(int i=0; i<a.size()-1; i++){
            if((a.get(i)+a.get(i+1))%2 ==0 ) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Integer n = sc1.nextInt();
        ArrayList<Integer> a = new ArrayList<>();

        for(int i=0; i<n; i++){
            Integer temp1 = sc1.nextInt();
            a.add(temp1);
        }

        Integer i = viTriKhongThoaMan(a);
        while(i!=-1){
            a.remove(i+1);
            a.remove(i);
            
            i = viTriKhongThoaMan(a);
        }
        System.out.println(a.size());
    }
}
