/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javatuan8.ThucHanh;

import java.util.ArrayList;
import java.util.List;
import java.util.NavigableSet;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author azoom
 */
public class Bai3 {
    private static Scanner sc = new Scanner(System.in);
    
    private static void xuLy() {
        Integer n = sc.nextInt();
        TreeSet<Integer> setChan = new TreeSet<>();
        TreeSet<Integer> setLe = new TreeSet<>();
        for(int i=0; i<n; i++){
            Integer temp = sc.nextInt();
            if(temp%2==0){
                setChan.add(temp);
            }
            else {
                setLe.add(temp);
            }
        }
        
        ArrayList<Integer> arrListLe2 = new ArrayList<>();
        for(Integer le : setLe){
            arrListLe2.add(le);
        }
        
        
        ArrayList<Integer> arrListLe4 = new ArrayList<>();
        for(int i=arrListLe2.size()-1; i>-1; i--){
            arrListLe4.add(arrListLe2.get(i));
        }
        
        for(Integer chan : setChan){
            System.out.print(chan + " ");
        }
        System.out.println("");
        
        for(Integer le : arrListLe4){
            System.out.print(le + " ");
        }
        System.out.println("");
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
7
3 7 12 8 5 4 888
*/