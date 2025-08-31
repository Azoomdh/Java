import java.util.ArrayList;
import java.util.Scanner;

// class PhanTu {
//     private Integer so;
//     private Integer soLanXuatHien;
//     public PhanTu(Integer so, Integer soLanXuatHien) {
//         this.so = so;
//         this.soLanXuatHien = soLanXuatHien;
//     }
//     public Integer getSo() {
//         return so;
//     }
//     public void setSo(Integer so) {
//         this.so = so;
//     }
//     public Integer getSoLanXuatHien() {
//         return soLanXuatHien;
//     }
//     public void setSoLanXuatHien(Integer soLanXuatHien) {
//         this.soLanXuatHien = soLanXuatHien;
//     }
//     @Override
//     public String toString() {
//         return "" + so + " xuat hien " + soLanXuatHien + "lan ";
//     }

    
// }

public class J02007 {
    private static Scanner sc1 = new Scanner(System.in);

    public static void xuLy(Integer i){
        Integer n = sc1.nextInt();

        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> soLan_a = new ArrayList<>();

        for(int j=0; j<n; j++){
            Integer temp1 = sc1.nextInt();
            Integer viTriTemp1 = a.indexOf(temp1);
            if(viTriTemp1 == -1){
                a.add(temp1);
                soLan_a.add(1);
            }
            else {
                // a.set(viTriTemp1, a.get(viTriTemp1))
                soLan_a.set(viTriTemp1, soLan_a.get(viTriTemp1)+1);
            }
        }

        System.out.println("Test "+ i + ": ");
        for(int j=0; j<a.size(); j++){
            System.out.println(a.get(j)+ " xuat hien "+ soLan_a.get(j)+ " lan ");
        }
    }

    public static void main(String[] args) {
        Integer sobotest = sc1.nextInt();

        for(int i=1; i<= sobotest; i++){
            xuLy(i);
        }
    }
}
