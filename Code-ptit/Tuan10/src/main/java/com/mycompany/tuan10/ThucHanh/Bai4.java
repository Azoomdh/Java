/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tuan10.ThucHanh;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author azoom
 */
public class Bai4 {
    
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("VANBAN.in"));
        
        TreeSet<String> listA1 = new TreeSet<>();
        
        while(sc.hasNext()==true ){
            String s = sc.next();
            if(isOk(s)==true ){
                listA1.add(s);
            }
        }
        
        for(String a1 : listA1){
            System.out.println(a1);
        }
    }

    private static boolean isOk(String s) {
        if(s.contains(".")==true){
            return false;
        }
        if(s.contains(",")==true){
            return false;
        }
        if(s.contains("!")==true){
            return false;
        }
        if(s.contains("?")==true){
            return false;
        }
        if(s.contains(":")==true){
            return false;
        }
        
        if(s.contains("0")==true){
            return true;
        }
        if(s.contains("0")==true){
            return true;
        }
        if(s.contains("1")==true){
            return true;
        }
        if(s.contains("2")==true){
            return true;
        }
        if(s.contains("3")==true){
            return true;
        }
        if(s.contains("4")==true){
            return true;
        }
        if(s.contains("5")==true){
            return true;
        }
        if(s.contains("6")==true){
            return true;
        }
        if(s.contains("7")==true){
            return true;
        }
        if(s.contains("8")==true){
            return true;
        }
        if(s.contains("9")==true){
            return true;
        }
        return false;
    }
}
