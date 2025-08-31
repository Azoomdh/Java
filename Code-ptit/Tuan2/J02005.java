import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;

public class J02005 {
    private static Scanner sc1 = new Scanner(System.in);

    public static void main(String[] args) {
        Integer n = sc1.nextInt();
        Integer m = sc1.nextInt();

        HashSet<Integer> a = new HashSet<>();
        HashSet<Integer> b = new HashSet<>();

        for(int i=0; i<n; i++){
            Integer temp = sc1.nextInt();
            a.add(temp);
        }

        for(int i=0; i<m; i++){
            Integer temp = sc1.nextInt();
            b.add(temp);
        }

        ArrayList<Integer> c= new ArrayList<>();

        for(Integer x : a){
            if(b.contains(x)==true){
                c.add(x);
            }
        }

        Comparator<Integer> comparator1 = new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
            
        };

        Collections.sort(c, comparator1);

        for(int i=0; i<c.size(); i++){
            System.out.print(c.get(i)+ " ");
        }
        System.out.println("");
    }
}
