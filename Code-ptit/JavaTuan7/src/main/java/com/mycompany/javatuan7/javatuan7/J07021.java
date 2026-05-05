/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javatuan7.javatuan7;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author azoom
 */
public class J07021 {
   
    public static String xuLyString(String s){
        s = s.trim();
        s = s.toLowerCase();
        StringTokenizer stringTokenizer1 = new StringTokenizer(s, " ");
        
        String result = "";
        while(stringTokenizer1.hasMoreTokens()==true ){
            String sTemp = stringTokenizer1.nextToken();
            
            sTemp = sTemp.substring(0,1).toUpperCase() + sTemp.substring(1, sTemp.length()).toLowerCase();
            result = result + " " + sTemp;
        }
        
        result = result.trim();
        
        return result;
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("DATA.in"));
        
        while(true){
            String s = sc.nextLine();
            if(s.equals("END")==true ){
                break;
            }
            
            String s2 = xuLyString(s);
            System.out.println(s2);
        }
    }
}
