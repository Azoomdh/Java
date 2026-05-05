package Tuan6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class J07004 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("DATA.in"));

        TreeMap<Integer, Integer> dsT= new TreeMap<>();
        while(sc.hasNext()==true ){
            Integer t = Integer.parseInt(sc.next());
            if(dsT.containsKey(t)==true){
                dsT.replace(t, dsT.get(t)+1);
            }
            else{
                dsT.put(t, 1);
            }
        }

        for(Integer i : dsT.keySet()){
            System.out.println(i + " " + dsT.get(i));
        }
    }
}
