/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tuan9.LuyenTap;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 *
 * @author azoom
 */
public class Fail_J08015_v2 {
    private static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        Integer sotest = sc.nextInt();
        
        while(sotest-- >0){
            xuLy();
        }
    }

    private static void xuLy() {
        Integer n = sc.nextInt();
        Integer k = sc.nextInt();
        
        TreeMap<Long, Integer> listA1= new TreeMap<>();
        for(int i=0; i<n; i++){
            Long temp = sc.nextLong();
            if(listA1.containsKey(temp)==true ){
                Integer value = listA1.get(temp);
                value++;
                listA1.replace(temp, value);
            }
            else{
                listA1.put(temp, 1);
            }
        }
        
        
        Integer soCapThoaMan = 0;
        
        Long kLong = Long.valueOf(k.toString());
        
        
        TreeSet<Long> listB1 = new TreeSet<>(listA1.keySet());
        
        
        for(Long a : listB1){
            
            Long b = kLong-a;
            
            if(listA1.containsKey(b)==true ){
                if(a==b){
                    Integer valueA = listA1.get(a);
                    Integer valueB = valueA;
                    soCapThoaMan = soCapThoaMan + valueA*(valueA-1);
                    
                }
                else{
                    Integer valueA = listA1.get(a);
                    Integer valueB = listA1.get(b);
                    soCapThoaMan = soCapThoaMan + valueA*valueB;
                    
                }
            }
        }
        
        soCapThoaMan = soCapThoaMan/2;
        
        System.out.println(soCapThoaMan);
    }
}

/*
4
4 6
1 5 7 -1
5 6
1 5 7 -1 5
4 2
1 1 1 1
13 11
10 12 10 15 -1 7 6 5 4 2 1 1 1
*/