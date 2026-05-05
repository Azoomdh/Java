/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tuan10.BaiTap;

import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 *
 * @author azoom
 */
public class Bai4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        WordSet s1 = new WordSet(in.nextLine());
        WordSet s2 = new WordSet(in.nextLine());
        System.out.println(s1.union(s2));
        System.out.println(s1.intersection(s2));
    }
    
    static class WordSet{
        private TreeSet<String> treeSetString;

        public WordSet(String inputString) {
            inputString = inputString.toLowerCase();
            
            this.treeSetString= new TreeSet<>();
            
            StringTokenizer sTokenizer = new StringTokenizer(inputString, " ");
            while(sTokenizer.hasMoreTokens()==true ){
                this.treeSetString.add(sTokenizer.nextToken());
            }
            
        }

        public WordSet(TreeSet<String> treeSetString) {
            this.treeSetString = new TreeSet<>();
            this.treeSetString.addAll(treeSetString);
        }

        public TreeSet<String> getTreeSetString() {
            return treeSetString;
        }
        
        private WordSet union(WordSet s2) {
            TreeSet<String> s3 = new TreeSet<>();
            
            s3.addAll(this.treeSetString);
            s3.addAll(s2.getTreeSetString());
            
            return new WordSet(s3);
        }

        private WordSet intersection(WordSet s2) {
            TreeSet<String> list3 = new TreeSet<>();
            TreeSet<String> list1 = this.treeSetString;
            TreeSet<String> list2 = s2.getTreeSetString();
            
            for(String a1 : list1){
                if(list2.contains(a1)==true ){
                    list3.add(a1);
                }
            }
            
            return new WordSet(list3);
        }

        @Override
        public String toString() {
            String s = "";
            
            for(String a : this.getTreeSetString()){
                s = s + a + " ";
            }
            s= s.trim();
            
            return s;
        }
        
        
        
    }
}

/*
Lap trinh huong doi tuong
Ngon ngu lap trinh C++
*/