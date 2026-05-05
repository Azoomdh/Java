/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javatuan7.javatuan7thuchanh;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author azoom
 */
public class Bai1 {
    
    public static Boolean isOk(Integer n){
        if(n<100){
            return false;
        }
        String s = n.toString();
        for(int i=0; i<=s.length()/2-1; i++){
            Character c1 = s.charAt(i);
            Character c2 = s.charAt(n-1-i);
            if(c1.equals(c2)==false ){
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("DAYSO.DAT"));
            
            ArrayList<Integer> dsT = (ArrayList<Integer>) input.readObject();
            Set<Integer> dsT2 = new HashSet<>();
            
            for(Integer t : dsT){
                if(isOk(t)==true){
                    dsT2.add(t);
                }
            }
            
            ArrayList<Integer> dsT3 = new ArrayList<>();
            for(Integer t2 : dsT2){
                dsT3.add(t2);
            }
            
            Collections.sort(dsT3);
            
            for(Integer t3 : dsT3){
                System.out.println(t3);
            }

    }
}
