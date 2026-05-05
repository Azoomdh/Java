/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javatuan8.LuyenTap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 *
 * @author azoom
 */
public class J07032_v2 {
    
    public static Integer countNumberItem(ArrayList<Integer> listA, Integer x){
        Integer num=0;
        for(Integer a : listA){
            if(a.equals(x)==true ){
                num++;
            }
        }
        return num;
    }
    
    public static Boolean isOkPart1(Integer n){
        String s = n.toString();
        if(s.length() < 2){
            return false;
        }
        if(s.length()%2==0){
            return false;
        }
        for(Character c : s.toCharArray()){
            if
            /*condition*/(
                    c.equals('0')
                    || c.equals('2')
                    || c.equals('4')
                    || c.equals('6')
                    || c.equals('8')
            )
            {
                return false;
            }
            else {
                // doesnt do
            }
        }
        return true;
    }
    
//    public static ArrayList<Integer> generateArrayList(Integer memberNum){
//        ArrayList<Integer> listA1 = new ArrayList<>();
//        for(int i=0; i<memberNum; i++){
//            listA1.add(new Random().nextInt(0, 1_000_000));
//        }
//        
//        return listA1;
//    }
    
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
//        ObjectOutputStream outputA = new ObjectOutputStream(new FileOutputStream("DATA1.in"));
//        ObjectOutputStream outputB = new ObjectOutputStream(new FileOutputStream("DATA2.in"));
//        
//        ArrayList<Integer> listA1 = generateArrayList(1_000_000);
//        ArrayList<Integer> listB1 = generateArrayList(1_000_000);
//        
//        outputA.writeObject(listA1);
//        outputB.writeObject(listB1);
//        
////        System.out.println("A1");
        // ---------------------------------------------
        
        ObjectInputStream inputA = new ObjectInputStream(new FileInputStream("DATA1.in"));
        ObjectInputStream inputB = new ObjectInputStream(new FileInputStream("DATA2.in"));
        
        ArrayList<Integer> listA2 = (ArrayList<Integer>) inputA.readObject();
        ArrayList<Integer> listB2 = (ArrayList<Integer>) inputB.readObject();
        
        TreeMap<Integer, Integer> listA3 = new TreeMap<>();
        TreeMap<Integer, Integer> listB3 = new TreeMap<>();

        for(Integer a : listA2){
            if(isOkPart1(a)==true){
                if(listA3.containsKey(a)==true){
                    Integer index = listA3.get(a);
                    index++;
                    listA3.put(a, index);
                } 
                else {
                    listA3.put(a, 1);
                }
            }
        }
        
        for(Integer b : listB2){
            if(isOkPart1(b)==false){
                continue;
            }
            if(listA3.containsKey(b)==false){
                continue;
            }
            if(listB3.containsKey(b)==true){
                Integer index = listB3.get(b);
                index++;
                listB3.put(b, index);
            }
            else {
                listB3.put(b, 1);
            }
        }
        
//        Integer dem = 0;
//        for(Integer a : listA3.keySet()){
//            if(listB3.containsKey(a)==true){
//                Integer soluong = listA3.get(a) + listB3.get(a);
//                System.out.println(a + " " + soluong);
//                dem++;
//            }
//            if(dem==10){
//                break;
//            }
//        }
        Integer dem = 0;
        for(Integer b : listB3.keySet()){
            if(true){
                Integer soluong = listA3.get(b) + listB3.get(b);
                System.out.println((int)b + " " + (int)soluong);
                dem++;
            }
            if(dem==10){
                break;
            }
        }
    }
}
