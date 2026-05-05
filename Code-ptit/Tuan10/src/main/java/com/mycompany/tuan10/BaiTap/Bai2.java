/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tuan10.BaiTap;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author azoom
 */
public class Bai2 {
    
    private static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        Integer n = sc.nextInt();
        
        ArrayList< ArrayList<Integer> > listA1= new ArrayList<>();
        for(int i=0; i<n; i++){
            ArrayList<Integer> listTemp = new ArrayList<>();
            for(int j=0; j<n; j++){
                Integer temp = sc.nextInt();
                listTemp.add(temp);
            }
            listA1.add(listTemp);
        }
        
        ArrayList< Pair<Integer, Integer> > listB1 = new ArrayList<>();
        for(int i=0; i<listA1.size(); i++){
            
            for(int j=i+1; j<listA1.get(i).size(); j++){
                if(listA1.get(i).get(j)==1){
                    listB1.add(new Pair<>(i+1, j+1));
                }
            }
        }
        
        for(Pair<Integer, Integer> b : listB1){
            System.out.println(b.toString());
        }
    }
    
    static class Pair<T1, T2> {
        private T1 t1;
        private T2 t2;

        public Pair(T1 t1, T2 t2) {
            this.t1 = t1;
            this.t2 = t2;
        }

        @Override
        public String toString() {
            return "(" + this.t1 + "," + this.t2 + ")";
        }
        
    }
}

/*
6
0 1 1 0 1 0
1 0 1 0 1 0
1 1 0 1 0 0
0 0 1 0 1 1
1 1 0 1 0 1
0 0 0 1 1 0
*/