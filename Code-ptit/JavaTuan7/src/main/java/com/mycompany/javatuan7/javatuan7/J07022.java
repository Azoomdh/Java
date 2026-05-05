/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javatuan7.javatuan7;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author azoom
 */
public class J07022 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("DATA.in"));
        
        ArrayList<String> dsT = new ArrayList<>();
        while(sc.hasNext()==true){
            String s =sc.next();
            try{
                Integer temp = Integer.parseInt(s);
            }
            catch(NumberFormatException e){
                dsT.add(s);
            }
        }
        
        Collections.sort(dsT);
        
        for(String t : dsT){
            System.out.print(t + " ");
        }
    }
}
