package Tuan3;
import java.util.ArrayList;
import java.util.Scanner;

public class J02011 {
    private static Scanner sc1 = new Scanner(System.in);

    public static void inra(ArrayList<Integer> a){
        for(int i=0; i<a.size(); i++){
            System.out.print(a.get(i)+ " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        Integer n = sc1.nextInt();
        ArrayList<Integer> a = new ArrayList<>();

        for(int i=0; i<n; i++){
            Integer temp1 = sc1.nextInt();
            a.add(temp1);
        }

        for(int i=0; i<a.size()-1; i++){
            Integer id = i;

            for(int j=i+1; j<a.size(); j++){
                if(a.get(id)> a.get(j) ){
                    id = j;
                }
            }

            Integer temp1 = a.get(i);
            Integer temp2 = a.get(id);
            a.set(i, temp2);
            a.set(id, temp1);

            System.out.print("Buoc "+ (i+1)+ ": ");
            inra(a);
        }
    }
}
