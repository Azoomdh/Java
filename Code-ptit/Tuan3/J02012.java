package Tuan3;
import java.util.ArrayList;
import java.util.Scanner;

public class J02012 {
    private static Scanner sc1 = new Scanner(System.in);

    public static void main(String[] args) {
        Integer n = sc1.nextInt();
        ArrayList<Integer> a= new ArrayList<>();

        for(int i=0; i<n; i++){
            Integer temp1 = sc1.nextInt();
            a.add(temp1);
        }

        for(int i=0; i<a.size(); i++){
            Integer id=i;

            while(id>0 && a.get(id-1) > a.get(id) ){
                Integer temp1 = a.get(id-1);
                Integer temp2 = a.get(id);
                a.set(id-1, temp2);
                a.set(id, temp1);
                id--;
            }

            System.out.print("Buoc "+ i+": ");
            for(int j=0; j<=i; j++){
                System.out.print(a.get(j)+ " ");
            }
            System.out.println("");
        }
    }
}
