package Tuan5;

import java.util.Scanner;

public class J04002 {

    private static Scanner sc = new Scanner(System.in);

    public static Rectange readRectange(){
        Double width = sc.nextDouble();
        Double height = sc.nextDouble();
        String color = sc.next();

        return new Rectange(width, height, color);
    }

    public static void main(String[] args) {
        Rectange rect1 = readRectange();
        System.out.println(rect1.toString());
    }
}

class Rectange {
    private Double width;
    private Double height;
    private String color;
    public Rectange() {
    }
    public Rectange(Double width, Double height, String color) {
        this.width = width;
        this.height = height;
        this.color = Rectange.chuanHoaStr(color);
    }
    public Double getWidth() {
        return width;
    }
    public void setWidth(Double width) {
        this.width = width;
    }
    public Double getHeight() {
        return height;
    }
    public void setHeight(Double height) {
        this.height = height;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    
    public Double findArea(){
        return this.width * this.height;
    }

    public Double findPerimeter(){
        return 2*(this.width+ this.height);
    }

    public static String chuanHoaStr(String s){
        StringBuilder s2 = new StringBuilder(s.toLowerCase());
        s2.setCharAt(0, s2.toString().toUpperCase().charAt(0));

        return s2.toString();
    }

    public static Boolean numberIsValid(double n){
        if(n>0 && n==(int)n ){
            return true;
        }
        return false;
    }

    public String toString(){
        if(numberIsValid(this.width)==true && numberIsValid(this.height)==true ) {
            return (int)(double)this.findPerimeter() + " " + (int)(double)this.findArea() + " " + this.color ;
        }
        return "INVALID";
    }
}