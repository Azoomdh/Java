/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javatuan8.ThucHanh;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author azoom
 */
public class Bai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger n = sc.nextBigInteger();
        
        BigInteger ninetyNumber = new BigInteger("9");
        while(n.compareTo(ninetyNumber)>0){
            String s = n.toString();
            
            Integer length = s.length();
            BigInteger a = new BigInteger(s.substring(0, length/2));
            BigInteger b = new BigInteger(s.substring(length/2, s.length()));
            
            n = a.add(b);
            System.out.println(n.toString());
        }
        
    }
}
/*
123456
*/