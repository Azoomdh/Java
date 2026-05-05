/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javatuan7.javatuan7;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author azoom
 */
public class J07031 {
    
    public static Boolean isSnt(Integer n){
        if(n<2){
            return false;
        }
        if(n==2){
            return true;
        }
        if(n%2==0){
            return false;
        }
        Double sqrt_n = Math.sqrt(n);
        for(int i=3; i<=sqrt_n; i=i+2){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
    
    public static HashSet<Integer> bienDoi1(ArrayList<Integer> dsT1){
        HashSet<Integer> dsT2 = new HashSet<>();
        for(Integer t : dsT1){
            dsT2.add(t);
        }
        
        return dsT2;
    }
    
    public static ArrayList<Integer> bienDoi2(HashSet<Integer> dsT1){
        
        ArrayList<Integer> dsT2 = new ArrayList<>();
        for(Integer t1 : dsT1){
            dsT2.add(t1);
        }
        
        Collections.sort(dsT2);
        
        return dsT2;
    }
    
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
//        ObjectOutputStream output1 = new ObjectOutputStream(new FileOutputStream("DATA1.in"));
//        ObjectOutputStream output2 = new ObjectOutputStream(new FileOutputStream("DATA2.in"));
//        
//        ArrayList<Integer> list1 = new ArrayList<>();
//        ArrayList<Integer> list2 = new ArrayList<>();
//        
//        for(int i=0; i<100_000; i++){
//            list1.add(new Random().nextInt(2, 1_000_000));
//        }
//        for(int i=0; i<10_000; i++){
//            list2.add(new Random().nextInt(2, 1_000_000));
//        }
//        
//        output1.writeObject(list1);
//        output2.writeObject(list2);
        
        // ----------------------------------------------------------
        
        ObjectInputStream input1 = new ObjectInputStream(new FileInputStream("DATA1.in"));
        ObjectInputStream input2 = new ObjectInputStream(new FileInputStream("DATA2.in"));
        
        HashSet<Integer> ds1A = bienDoi1((ArrayList<Integer>) input1.readObject());
        HashSet<Integer> ds2A = bienDoi1((ArrayList<Integer>) input2.readObject());
        
        ArrayList<Integer> ds1B = bienDoi2(ds1A);
        ArrayList<Integer> ds2B = bienDoi2(ds2A);
        
        for(Integer n : ds1B){
            Integer m = 1_000_000-n;
            if(n>m){
                break;
            }
            if(
                    ds1A.contains(n)==true
                    && ds1A.contains(m)==true
                    && ds2A.contains(n)==false
                    && ds2A.contains(m)==false
                    && isSnt(n)==true
                    && isSnt(m)==true
            )
            {
                System.out.println(n + " " + m);
            }
        }

    }
}
