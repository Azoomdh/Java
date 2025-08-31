import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;

public class J02006 {
    private static Scanner sc1 = new Scanner(System.in);

    public static void main(String[] args) {
        Integer n = sc1.nextInt();
        Integer m = sc1.nextInt();

        HashSet<Integer> a = new HashSet<>();


        for(int i=0; i<n; i++){
            Integer temp1 = sc1.nextInt();
            a.add(temp1);
        }

        for(int i=0; i<m; i++){
            Integer temp1 = sc1.nextInt();
            a.add(temp1);
        }

        ArrayList<Integer> c = new ArrayList<>();
        c.addAll(a);

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
