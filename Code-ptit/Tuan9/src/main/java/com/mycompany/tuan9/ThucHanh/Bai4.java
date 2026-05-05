/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tuan9.ThucHanh;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 *
 * @author azoom
 */
public class Bai4 {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream inputA = new ObjectInputStream(new FileInputStream("DATA1.in"));
        ObjectInputStream inputB = new ObjectInputStream(new FileInputStream("DATA2.in"));
        
        ArrayList<String> listA = (ArrayList<String>) inputA.readObject();
        ArrayList<Integer> listB = (ArrayList<Integer>) inputB.readObject();
        
    }
}
