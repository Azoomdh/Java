/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tuan10.BaiTap;

import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author azoom
 */
public class Bai3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), a[] = new int[n], b[] = new int[m];
        for(int i = 0; i<n; i++) a[i] = sc.nextInt();
        for(int i = 0; i<m; i++) b[i] = sc.nextInt();
        IntSet s1 = new IntSet(a);
        IntSet s2 = new IntSet(b);
        IntSet s3 = s1.union(s2);
        System.out.println(s3);
    }
    
    static class IntSet{
        private TreeSet<Integer> treeSet;

        public IntSet(int[] listA) {
            this.treeSet = new TreeSet<>();
            for(int a : listA){
                this.treeSet.add(a);
            }
        }

        public IntSet(TreeSet<Integer> treeSet) {
            this.treeSet= new TreeSet<>();
            this.treeSet.addAll(treeSet);
        }
        
        

        public TreeSet<Integer> getTreeSet() {
            return treeSet;
        }


        
        public IntSet union(IntSet s2){
            TreeSet<Integer> treeSetA = new TreeSet<>();
            
            treeSetA.addAll(this.treeSet);
            treeSetA.addAll(s2.getTreeSet());
            
            return new IntSet(treeSetA);
        }

        @Override
        public String toString() {
            String s = "";
            for(Integer a : this.treeSet){
                s = s + a + " ";
            }
            
            s = s.trim();
            
            return s;
        }
        
        
    }
}

/*
5 6
1 2 3 4 5
3 4 5 6 7 8
*/