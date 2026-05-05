/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javatuan8.ThucHanh;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author azoom
 */
public class Bai4 {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new FileInputStream("DATA.in"));
            
            String sTong = sc.nextLine();
            StringTokenizer sTokener = new StringTokenizer(sTong);
            TreeSet<BigInteger> treeSetTong = new TreeSet<>();
            while(sTokener.hasMoreTokens()==true ){
                String sTemp = sTokener.nextToken();
                BigInteger biTemp = new BigInteger(sTemp);
                treeSetTong.add(biTemp);
            }
            
            String sTich = sc.nextLine();
            StringTokenizer sTokener2 = new StringTokenizer(sTich);
            TreeSet<BigInteger> treeSetTich = new TreeSet<>();
            while(sTokener2.hasMoreTokens()==true ){
                String sTemp = sTokener2.nextToken();
                BigInteger biTemp = new BigInteger(sTemp);
                treeSetTich.add(biTemp);
            }
            
            BigInteger tong = new BigInteger("0");
            BigInteger tich = new BigInteger("1");

            for(BigInteger t : treeSetTong){
                tong = tong.add(t);
            }
            
            for(BigInteger t : treeSetTich){
                tich = tich.multiply(t);
            }
            
            System.out.println(tong.toString());
            System.out.println(tich.toString());
        } 
        catch (FileNotFoundException ex) {
            Logger.getLogger(Bai4.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
