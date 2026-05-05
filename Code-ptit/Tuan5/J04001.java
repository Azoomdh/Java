package Tuan5;

import java.util.Scanner;

public class J04001 {

    private static Scanner sc = new Scanner(System.in);

    public static Point read1Point(){
        Double x = sc.nextDouble();
        Double y = sc.nextDouble();

        return new Point(x, y);
    }

    public static void xuLy() {
        Point point1 = read1Point();
        Point point2 = read1Point();

        System.out.printf("%.4f \n", point1.distance(point2));
    }

    public static void main(String[] args) {
        Integer sobotest = sc.nextInt();

        while(sobotest-- >0){
            xuLy();
        }
    }
}

class Point {
    private Double x;
    private Double y;
    public Point() {
    }
    public Point(Double x, Double y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point p){
        this.x= p.getX();
        this.y= p.getY();
    }

    public Double getX() {
        return x;
    }
    public Double getY() {
        return y;
    }

    public Double distance(Point secondPoint){
        return this.distance(this, secondPoint);
    }

    public Double distance(Point p1, Point p2){
        Double deltaX = p1.getX()- p2.getX();
        Double deltaY = p1.getY()- p2.getY();

        return Math.sqrt(
            deltaX*deltaX
            + deltaY*deltaY
        );
    }
    @Override
    public String toString() {
        return "Point [x=" + x + ", y=" + y + "]";
    }

    
}

/*
2
0 0 0 5
0 199 5 6
*/