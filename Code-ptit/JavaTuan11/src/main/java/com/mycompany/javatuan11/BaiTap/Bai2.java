/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javatuan11.BaiTap;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author azoom
 */
public class Bai2 {
    private static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        int sobotest = sc.nextInt();
        
        while(sobotest-- >0){
            xuLy();
        }
    }

    private static void xuLy() {
        String xauDangXet = sc.nextLine();
        
        Stack<Character> stackA1 = new Stack<>();
        
        String danhSachDauNgoac= "";
                
        for(int i=0; i<xauDangXet.length(); i++){
            Character cDangXet = xauDangXet.charAt(i);
            if(cDangXet.equals('(') && cDangXet.equals(')') ){
                danhSachDauNgoac= danhSachDauNgoac + cDangXet;
            }
        }
    }
}

/*
2
(a + (b *c) ) + (d/e)
( ( () ) ( () ) )
*/