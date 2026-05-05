/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tuan10.LuyenTap;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author azoom
 */
public class Fail_J03019 {
    
    private static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        String s = sc.next();
        
        System.out.println(sinhXauLonNhat(s));
    }
    
    private static Integer timKyTuDauTienTrongXau(String s, Character c, Integer viTriBatDau){
        for(int i=viTriBatDau; i<s.length(); i++) {
            Character charTemp = s.charAt(i);
            if(charTemp.equals(c)==true ){
                return i;
            }
        }
        
        return -1;
    }
    
    private static String themKyTuVaoXau(String s, Character c){
        return s + c;
    }
    
    private static String sinhXauLonNhat(String s) {
        
        TreeMap<Character, Integer> mapA1 = new TreeMap<>();
        
        for(Character c : s.toCharArray() ){
            if(mapA1.containsKey(c)==true ){
                Integer soLuong = mapA1.get(c);
                soLuong++;
                mapA1.replace(c, soLuong);
            }
            else{
                mapA1.put(c, 1);
            }
        }
        
        ArrayList<Character> listA2 = new ArrayList<>();
        
        for(Character c : mapA1.keySet()){
            listA2.add(c);
        }
        
        String xauLonNhat = "";
        Integer viTriConTro = 0;
        
        for(int i=listA2.size()-1; i>-1; i--){
            Character charDangXet = listA2.get(i);
            
            Integer viTri = timKyTuDauTienTrongXau(s, charDangXet, viTriConTro);
            
            while(viTri!=-1){
                xauLonNhat = themKyTuVaoXau(xauLonNhat, charDangXet);
            
                viTri++;
                
                viTriConTro = viTri;
                
                viTri = timKyTuDauTienTrongXau(s, charDangXet, viTri);
            }
        }
        
        return xauLonNhat;
        
    }
}
