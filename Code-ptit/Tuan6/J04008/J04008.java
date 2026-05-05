package Tuan6.J04008;

import java.util.Scanner;

public class J04008 {

    private static Scanner sc = new Scanner(System.in);

    public static Point readPoint(){
        return new Point(
            sc.nextDouble(), 
            sc.nextDouble()
        );
    }

    public static Boolean isOk1(Double distance_AB, Double distance_AC, Double distance_BC ) {
        if(
            distance_AB+distance_AC > distance_BC 
            && distance_AB+distance_BC > distance_AC 
            && distance_AC+distance_BC > distance_AB
        )
        {
            return true;
        }
        else{
            return false;
        }
    }

    public static void xuLy() {
        Point tA = readPoint();
        Point tB = readPoint();
        Point tC = readPoint();

        Double distance_AB = tA.distance(tB);
        Double distance_AC = tA.distance(tC);
        Double distance_BC = tB.distance(tC);

        if(isOk1(distance_AB, distance_AC, distance_BC)== true){
            Double chuvi = distance_AB+ distance_AC+ distance_BC;
            System.out.println(String.format("%.3f", chuvi));
        }
        else {
            System.out.println("INVALID");
        }

    }

    public static void main(String[] args) {
        Integer sobotest = sc.nextInt();

        while(sobotest-- >0){
            xuLy();
        }
    }
}

class Point{
    private Double x;
    private Double y;

    public Point() {
    }
    
    public Point(Double x, Double y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point t2) {
        this.x = t2.getX();
        this.y = t2.getY();
    }

    public Double getX() {
        return x;
    }
    
    public Double getY() {
        return y;
    }

    public Double distance(Point t2){
        Double deltaX = this.getX()- t2.getX();
        Double deltaY = this.getY()- t2.getY();
        
        return Math.sqrt(
            Math.pow(deltaX, 2) + Math.pow(deltaY, 2)
        );
    }

    public Double distance(Point t1, Point t2){
        Double deltaX = t1.getX() - t2.getX();
        Double deltaY = t1.getY() - t2.getY();
        
        return Math.sqrt(
            Math.pow(deltaX, 2) + Math.pow(deltaY, 2)
        );
    }

    @Override
    public String toString() {
        return "Point [x=" + x + ", y=" + y + "]";
    }

    
}

/*
3
0 0 0 5 0 199
1 1 1 1 1 1
0 0 0 5 5 0
*/