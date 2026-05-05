/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javatuan7.javatuan7;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author azoom
 */
public class J07017 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("DATA.in"));
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            boolean check = false;
            for(int i = 2; i <= 2*Math.sqrt(n); i++){
                Pair<Integer, Integer> p = new Pair<>(i, n-i);
                if(p.isPrime()){
                    System.out.println(p);
                    check = true;
                    break; 
                }
            }
            if(!check) System.out.println(-1);
        }
    }
    
    static class Pair<T1, T2>{
        private T1 t1;
        private T2 t2;

        public Pair(T1 t1, T2 t2) {
            this.t1 = t1;
            this.t2 = t2;
        }
        
        public Boolean isPrime(Integer n){
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
            for(int i=3; i<=sqrt_n; i++){
                if(n%i==0){
                    return false;
                }
            }
            
            return true;
        }
        
        public Boolean isPrime(){
            Integer so1 = (Integer) t1;
            Integer so2 = (Integer) t2;
            
            if(this.isPrime(so1)==true && this.isPrime(so2)==true ){
                return true;
            }
            return false;
        }

        @Override
        public String toString() {
            return t1 + " " + t2;
        }
        
        
    }
}