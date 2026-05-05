/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javatuan7.javatuan7;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author azoom
 */
public class J07008_KoLamDuoc {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        DataInputStream input = new DataInputStream(new FileInputStream("DAYSO.in"));
        
        Integer n = input.readInt();
        
        ArrayList<Integer> dsT = new ArrayList<>();
        for(int i=0; i<n; i++){
            Integer temp = input.readInt();
            dsT.add(temp);
        }
    }
}
