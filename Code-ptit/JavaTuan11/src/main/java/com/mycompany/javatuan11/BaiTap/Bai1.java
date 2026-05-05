/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javatuan11.BaiTap;

import java.util.*;

/**
 *
 * @author azoom
 */
public class Bai1 {
    
    private static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        Integer sobotest = Integer.valueOf(sc.nextLine());
        
        while(sobotest-- >0 ){
            xuLy();
        }
    }

    private static void xuLy() {
        String s = sc.nextLine();
        
        Stack<String> stackA1 = new Stack<>();
        
        Scanner sc2 = new Scanner(s);
        
        while(sc2.hasNext()==true ){
            stackA1.push(sc2.next());
        }
        
        while(stackA1.isEmpty()==false ){
            String s2 = stackA1.pop();
            System.out.print(s2 + " ");
        }
        System.out.println("");
    }
}
