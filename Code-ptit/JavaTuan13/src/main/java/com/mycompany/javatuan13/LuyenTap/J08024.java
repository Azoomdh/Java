/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javatuan13.LuyenTap;

import java.util.Scanner;

/**
 *
 * @author azoom
 */
public class J08024 {
    
    private static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
//        String s= Integer.toBinaryString(4);
//        System.out.println(s);
        
        Integer sobotest = sc.nextInt();
        
        while(sobotest-- >0){
            xuLy();
        }
    }
    
    private static Long convertToAbcTypeNumber(String s){
        Long so = 0L;
        for(int i=0; i<s.length(); i++){
            Long nTemp = 0L;
            Character cTemp = s.charAt(i);
            
            if(cTemp.equals('0')==true ){
                nTemp = 0L;
            }
            else if(cTemp.equals('1')==true ){
                nTemp = 9L;
            }
            else{
                return null;
            }
            
            so = so*10L + nTemp;
        }
        
        return so;
    }
    
    private static Long convertToAbcTypeNumber(Integer x){
        String s= Integer.toBinaryString(x);
        
        return convertToAbcTypeNumber(s);
    }

    private static void xuLy() {
        Integer n = sc.nextInt();
        
        Integer byteArray = 1;
        Long so = convertToAbcTypeNumber(byteArray);
        
        while(true){
            
            if(so%n==0){
                 break;
            }
            
            byteArray++;
            so = convertToAbcTypeNumber(byteArray);
        }
        
        System.out.println(so);
    }
}

/*
2
5
7
*/