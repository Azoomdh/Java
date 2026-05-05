/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tuan10.LuyenTap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author azoom
 */
public class J02026 {
    
    private static Scanner sc = new Scanner(System.in);
    
    private static Integer n;
    private static Integer k;
    
    private static ArrayList<Integer> arlIntDauVao;
    private static ArrayList<Integer> arlIntDangXet;
    private static ArrayList< ArrayList<Integer> > arlArlIntDuocChon;
    
    public static void main(String[] args) {
        Integer sobotest = sc.nextInt();
        
        while(sobotest-- >0){
            xuLy();
        }
    }
    
    private static void xuLy(){
        n = sc.nextInt();
        k = sc.nextInt();
        
        arlIntDauVao = new ArrayList<>();
        arlIntDangXet = new ArrayList<>();
        arlArlIntDuocChon = new ArrayList<>();
        
        for(int i=0; i<n; i++){
            arlIntDauVao.add(sc.nextInt());
        }
        
        Collections.sort(arlIntDauVao);
        
        sinhChuoi(0);
        
        for(ArrayList<Integer> listA : arlArlIntDuocChon){
            System.out.println(arlIntToString(listA));
        }
    }
    
    private static Boolean isTangDan(ArrayList<Integer> listA1){
        for(int i=0; i<=listA1.size()-2; i++){
            if(listA1.get(i)<=listA1.get(i+1) ){
                // doesnt do
            }
            else{
                return false;
            }
        }
        return true;
    }
    
    private static ArrayList<Integer> cloneArlInt(ArrayList<Integer> listA1) {
        ArrayList<Integer> listA2 = new ArrayList<>();
        
        listA2.addAll(listA1);
        
        return listA2;
    }
    
    private static void sinhChuoi(Integer viTri){
        if(arlIntDangXet.size()>k){
            return;
        }
        else if(isTangDan(arlIntDangXet)==false){
            return;
        }
        
        if(arlIntDangXet.isEmpty()==false && arlIntDangXet.size()==k){
            arlArlIntDuocChon.add(cloneArlInt(arlIntDangXet));
            return;
        }

        for(int i=viTri; i<arlIntDauVao.size(); i++){
            arlIntDangXet.add(arlIntDauVao.get(i));
            sinhChuoi(i+1);
            arlIntDangXet.remove(arlIntDangXet.size()-1);
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
}

/*
1
4 3
3 2 5 4
*/