/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tuan10.LuyenTap;

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
    
    private static ArrayList<Integer> arlIntDauVao;
    private static ArrayList<Integer> arlIntDangXet;
    private static ArrayList< ArrayList<Integer> > arlArlIntThoaMan;
    
    private static ArrayList<Integer> cloneDayDangXetDaoNguoc(ArrayList<Integer> listA1){
        ArrayList<Integer> listA2 = new ArrayList<>();
        
        for(int i=listA1.size()-1; i>-1; i--){
            listA2.add(listA1.get(i));
        }
        
        return listA2;
    }
    
    private static Integer tinhTong(ArrayList<Integer> listA1){
        Integer tong = 0;
        for(Integer a : listA1){
            tong = tong + a;
        }
        return tong;
    }
    
    private static void sinhChuoi(Integer viTri){
        if(tinhTong(arlIntDangXet)%2==1 ){
            arlArlIntThoaMan.add(cloneDayDangXetDaoNguoc(arlIntDangXet));
        }
        
//        System.out.println(arlIntDangXet);
        
        for(int i=viTri; i<arlIntDauVao.size(); i++){
            arlIntDangXet.add(arlIntDauVao.get(i));
            sinhChuoi(i+1);
            arlIntDangXet.remove(arlIntDangXet.size()-1);
        }
    }
    
    static class Comparator_ArlArlInt implements Comparator< ArrayList<Integer> > {

        @Override
        public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
            Integer n1 = o1.size();
            Integer n2 = o2.size();
            Integer n3 = Math.min(n1, n2);
            
            for(int i=0; i<n3; i++){
                Integer temp1 = o1.get(i);
                Integer temp2 = o2.get(i);
                
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
    
    private static String arlIntToString(ArrayList<Integer> listA1){
        String s = "";
        
        for(Integer a : listA1){
            s = s + a + " ";
        }
        
        s = s.trim();
        
        return s;
    }
    
    private static void xuLy() {
        Integer n = sc.nextInt();
        
        arlIntDauVao = new ArrayList<>();
        arlIntDangXet = new ArrayList<>();
        arlArlIntThoaMan = new ArrayList<>();
        
        for(int i=0; i<n; i++){
            arlIntDauVao.add(sc.nextInt());
        }
        
        Collections.sort(arlIntDauVao);
                
        sinhChuoi(0);
        
        Collections.sort(arlArlIntThoaMan, new Comparator_ArlArlInt());
        
        for(ArrayList<Integer> listA : arlArlIntThoaMan){
            System.out.println(arlIntToString(listA));
        }
    }
    
    public static void main(String[] args) {
        Integer sobotest = sc.nextInt();
        
        while(sobotest-- >0){
            xuLy();
        }
    }
}
/*
1
4
2 3 4 5
*/