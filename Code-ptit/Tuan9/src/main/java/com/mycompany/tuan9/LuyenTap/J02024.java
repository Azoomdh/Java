/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tuan9.LuyenTap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author azoom
 */
public class J02024 {
    
    private static Scanner sc = new Scanner(System.in);
    private static ArrayList<Integer> daySoCon= new ArrayList<>();
    private static ArrayList<Integer> daySo= new ArrayList<>();
    
    private static ArrayList< ArrayList<Integer> > listDaySoDuocChon= new ArrayList<>();
    
    public static void main(String[] args) {
        Integer sobotest = sc.nextInt();
//        Integer sobotest = 1;
        
        while(sobotest-- >0) {
            xuLy();
        }
    }

    private static void xuLy() {
        daySoCon = new ArrayList<>();
        daySo = new ArrayList<>();
        
        Integer n = sc.nextInt();
        
        
        for(int i=0; i<n; i++){
            Integer temp = sc.nextInt();
            daySo.add(temp);
        }
        
        Collections.sort(daySo);
        
        sinhChuoi(0);
        
        Collections.sort(listDaySoDuocChon, new ArlIntComparator());
        
        for(ArrayList<Integer> daySoDuocChonTemp : listDaySoDuocChon){
            System.out.println(daySoDuocChonTemp.toString());
        }
    }
    
    static class ArlIntComparator implements Comparator< ArrayList<Integer> > {

        @Override
        public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
            Integer n1 = o1.size();
            Integer n2 = o2.size();
            Integer n = Math.min(n1, n2);
            
            for(int i=0; i<n; i++){
                int temp1 = o1.get(i);
                int temp2 = o2.get(i);
                
                if(temp1>temp2){
                    return 1;
                }
                else if(temp1<temp2){
                    return -1;
                }
                else{
                    // doesnt do
                }
            }
            
            if(n1>n2){
                return 1;
            }
            else if(n1<n2){
                return -1;
            }
            else{
                return 0;
            }
        }
        
    }
            

    private static Integer tong(ArrayList<Integer> daySoCon) {
        Integer tong = 0;
        for(Integer a : daySoCon){
            tong = tong + a;
        }
        return tong;
    }
    
    private static Boolean isSnt(Integer n){
        if(n<2){
            return false;
        }
        if(n==2){
            return true;
        }
        if(n%2==0){
            return false;
        }
        Double sqrt_n = Math.sqrt(n);
        for(int i=3; i<=sqrt_n; i=i+2){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
    
    private static ArrayList<Integer> daoNguocDay(ArrayList<Integer> listA){
        ArrayList<Integer> listA2 = new ArrayList<>();
        
        for(int i= listA.size()-1; i>=0; i--){
            listA2.add(listA.get(i));
        }
        
        return listA2;
    }
    
    private static void sinhChuoi(Integer viTri){
        Integer tong = tong(daySoCon);
        if(isSnt(tong)==true && daySoCon.size()>0){
//            System.out.println(daySoCon.toString());
            listDaySoDuocChon.add(daoNguocDay(daySoCon));
        }
//        System.out.println(daySoCon.toString());

        for(int i=viTri; i<daySo.size(); i++){
            daySoCon.add(daySo.get(i));
            sinhChuoi(i+1);
            daySoCon.removeLast();
        }
    }
    
    
}

/*
5
2 3 5 7 11
*/

/*
1
4
3 2 5 4
*/

// 5 4 3 2