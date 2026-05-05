/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tuan10.BaiTap;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author azoom
 */
public class Bai1 {
    
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
    
    static class Pair<T0, T1> {


        private T0 t0;
        private T1 t1;

        public Pair(T0 t0, T1 t1) {
            this.t0 = t0;
            this.t1 = t1;
        }
        
        public boolean isPrime() {
            if(Util_CheckSnt.isPrime((Integer)t0)==true && Util_CheckSnt.isPrime((Integer)t1)==true ){
                return true;
            }
            else{
                return false;
            }
        }

        @Override
        public String toString() {
            return this.t0 + " " + this.t1;
        }
        
        
        
    }
    
    static class Util_CheckSnt {
        public static Boolean isPrime(Integer n) {
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
    }
}
