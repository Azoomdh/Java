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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author azoom
 */
public class Bai2 {
    
    public static Boolean isOk(Integer n){
        String s =n.toString();
        if(s.length()<2){
            return false;
        }
        
        for(int i=0; i<s.length()-1; i++){
            Character c1 = s.charAt(i);
            Character c2 = s.charAt(i+1);
            if(c1.compareTo(c2)>0){
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream input1 = new ObjectInputStream(new FileInputStream("DATA1.in"));
        ObjectInputStream input2 = new ObjectInputStream(new FileInputStream("DATA2.in"));

        ArrayList<Integer> ds1 = (ArrayList<Integer>) input1.readObject();
        ArrayList<Integer> ds2 = (ArrayList<Integer>) input2.readObject();

        int[] arr1 = new int[10_000];
        int[] arr2 = new int[10_000];
        
        for(Integer t1 : ds1){
            arr1[t1]++;
        }
        for(Integer t2 : ds2){
            arr2[t2]++;
        }
        
        for(int i=0; i<arr1.length; i++){
            if(isOk(i)==true){
                System.out.println(i + " " + arr1[i] + " " + arr2[i]);
            }
        }

    }
}
