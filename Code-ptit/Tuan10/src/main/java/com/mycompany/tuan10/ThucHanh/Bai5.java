/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tuan10.ThucHanh;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.TreeMap;

/**
 *
 * @author azoom
 */
public class Bai5 {
    
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        
        ObjectInputStream inputA = new ObjectInputStream(new FileInputStream("DATA1.in"));
        ObjectInputStream inputB = new ObjectInputStream(new FileInputStream("DATA2.in"));
        
        ArrayList<Integer> listA1 = (ArrayList<Integer>) inputA.readObject();
        ArrayList<Integer> listB1 = (ArrayList<Integer>) inputB.readObject();
        
        TreeMap<Integer, Integer> listA2 = new TreeMap<>();
        TreeMap<Integer, Integer> listB2 = new TreeMap<>();
        
        for(Integer a1 : listA1){
            if(listA2.containsKey(a1)==true){
                Integer soLuong = listA2.get(a1);
                soLuong++;
                listA2.replace(a1, soLuong);
            }
            else {
                listA2.put(a1, 1);
            }
        }
        
        for(Integer b1 : listB1){
            if(listB2.containsKey(b1)==true){
                Integer soLuong = listB2.get(b1);
                soLuong++;
                listB2.replace(b1, soLuong);
            }
            else {
                listB2.put(b1, 1);
            }
        }
        
        for(Integer a2 : listA2.keySet() ){
            if(listB2.containsKey(a2)==true ){
                if(isOk(a2)==true ){
                    System.out.println(a2 + " " + listA2.get(a2) + " " + listB2.get(a2));
                }
            }
        }
    }

    private static boolean isOk(Integer a2) {
        String s = a2.toString();
        
        for(int i=0; i<=s.length()-2; i++){
            char c1 = s.charAt(i);
            char c2 = s.charAt(i+1);
            if(c1<c2){
                // doesnt do
            }
            else if(c1==c2){
                // doesnt do
            }
            else{
                return false;
            }
        }
        
        return true;
    }
}
