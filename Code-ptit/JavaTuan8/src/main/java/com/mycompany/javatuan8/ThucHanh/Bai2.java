/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javatuan8.ThucHanh;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author azoom
 */
public class Bai2 {
    
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new FileInputStream("SONGUYEN.IN"));
            
            Integer sobotest = Integer.valueOf(sc.nextLine());
            
            for(int i=0; i<sobotest; i++){
                Integer n = Integer.valueOf(sc.nextLine());
                if(n%7==0 && n%13==0){
                    System.out.println("Both");
                }
                else if(n%7==0){
                    System.out.println("Div 7");
                }
                else if(n%13==0){
                    System.out.println("Div 13");
                }
                else {
                    System.out.println("None");
                }
            }
        }
        catch (FileNotFoundException ex) {
            // doesnt do
        }
    }
}
/*
5
7
13
91
10
14
*/