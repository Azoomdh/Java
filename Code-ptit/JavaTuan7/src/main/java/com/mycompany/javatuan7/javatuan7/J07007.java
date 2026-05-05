/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javatuan7.javatuan7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author azoom
 */
public class J07007 {
    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(new File("VANBAN.in"));
            
            Set<String> dsT1 = new HashSet<>();
            while(input.hasNext()==true ){
                String s = input.next().toLowerCase();
                dsT1.add(s);
            }
            
            ArrayList<String> dsT2 = new ArrayList<>();
            for(String t1 : dsT1){
                dsT2.add(t1);
            }
            
            Collections.sort(dsT2);
            
            for(String t2 : dsT2){
                System.out.println(t2);
            }
        }
        catch (FileNotFoundException ex) {
            Logger.getLogger(J07007.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
