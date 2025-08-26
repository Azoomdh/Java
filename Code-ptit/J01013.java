import java.util.Scanner;

public class J01013 {
    private static Scanner sc1= new Scanner(System.in);

    public static void main(String[] args) {
        Integer n = sc1.nextInt();
        Integer sum =0;
        while(n-- >0){
            Integer k = sc1.nextInt();

            Double sqrt_k = Math.sqrt(k);
            for(Integer i=2; i<=sqrt_k; i++){
                while(k%i==0){
                    sum= sum+i;
                    k=k/i;
                }
            }
            if(k>1){
                sum=sum+k;
            }
        }
        System.out.println(sum);
    }
}
