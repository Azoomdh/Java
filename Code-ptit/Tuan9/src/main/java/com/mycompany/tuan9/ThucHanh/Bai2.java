/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tuan9.ThucHanh;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author azoom
 */
public class Bai2 {
    
    private static  Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        Integer n = sc.nextInt();
        
        BigInteger tong = new BigInteger("0");
        
        ArrayList<BigInteger> listA1 = new ArrayList<>();
        for(int i=0; i<n; i++){
            BigInteger temp = sc.nextBigInteger();
            listA1.add(temp);
            tong = tong.add(temp);
        }
        
        Collections.sort(listA1);
        
        System.out.println(listA1.get(0).toString());
        System.out.println(listA1.get(n-1).toString());
        System.out.println(tong.toString());
    }
}
/*
5
213
2435
653224
34326
6467
*/