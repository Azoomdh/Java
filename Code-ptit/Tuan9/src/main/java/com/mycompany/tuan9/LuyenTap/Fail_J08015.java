/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tuan9.LuyenTap;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author azoom
 */
public class Fail_J08015 {
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
        
        ArrayList<Long> listB1 = new ArrayList<>(listA1.keySet());
        
        Integer soCapThoaMan = 0;
        
        for(int i=0; i<=listB1.size()-2; i++){
            for(int j=i+1; j<=listB1.size()-1; j++){
                Long tong = listB1.get(i) + listB1.get(j);
                if(tong>k){
                    // doesnt do
                }
                else{
                    Integer tongTemp = Integer.valueOf(tong.toString());
                    if(tongTemp==k){
                        soCapThoaMan = soCapThoaMan + listA1.get(listB1.get(i))*listA1.get(listB1.get(j));
                    }
                }
            }
        }
        
        Long kLong = Long.valueOf(k.toString());
        if(kLong%2==1){
            // doesnt do
        }
        else{
            Long kChia2 = kLong/2;
            if(listA1.containsKey(kChia2)==true ){
                Integer valueTemp = listA1.get(kChia2);
                soCapThoaMan = soCapThoaMan + valueTemp*(valueTemp-1)/2;
            }
        }
        
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