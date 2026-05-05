/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tuan9.ThucHanh;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author azoom
 */
public class Bai1 {
    
    private static Scanner sc = new Scanner(System.in);
    
    private static void xuLy() {
        Integer n = sc.nextInt();
        
        ArrayList<Integer> listA1 = new ArrayList<>();
        for(int i=0; i<n; i++){
            Integer temp = sc.nextInt();
            listA1.add(temp);
        }
        
        TreeMap<Integer, Integer> treeMapA2 = new TreeMap<>();
        for(Integer a : listA1){
            if(treeMapA2.containsKey(a)==true ){
                Integer value = treeMapA2.get(a);
                value++;
                treeMapA2.replace(a, value);
            }
            else{
                treeMapA2.put(a, 1);
            }
        }
    }
    
    public static void main(String[] args) {
        Integer sobotest = sc.nextInt();
        
        while(sobotest-- >0){
            xuLy();
        }
    }


}
