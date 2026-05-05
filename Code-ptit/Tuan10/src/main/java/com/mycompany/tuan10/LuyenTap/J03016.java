/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tuan10.LuyenTap;

import java.util.Scanner;

/**
 *
 * @author azoom
 */
public class J03016 {
    
    private static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        Integer sobotest = sc.nextInt();
        
        while(sobotest-- >0){
            String n = sc.next();
            
            if(isOk(n)==true ){
                System.out.println("1");
            }
            else{
                System.out.println("0");
            }
        }
    }

    private static Integer getNum(Character c){
        return (int) c-'0';
    }
    
    private static Boolean isOk(String n) {
        
        Integer soDu = 0;
        for(int i=0; i<=n.length()-1; i++){
            Integer tong = soDu*10 + getNum(n.charAt(i));
            soDu = tong%11;
        }
//        System.out.println(">> so du : " + soDu);
        if(soDu==0){
            return true;
        }
        else{
            return false;
        }
    }
}
