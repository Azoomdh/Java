package Tuan1;

import java.util.ArrayList;
import java.util.Scanner;

class ThuaSoSNT{
    private Integer thuaSo;
    private Integer soMu;
    public Integer getThuaSo() {
        return thuaSo;
    }
    public void setThuaSo(Integer thuaSo) {
        this.thuaSo = thuaSo;
    }
    public Integer getSoMu() {
        return soMu;
    }
    public void setSoMu(Integer soMu) {
        this.soMu = soMu;
    }
    public ThuaSoSNT(Integer thuaSo, Integer soMu) {
        this.thuaSo = thuaSo;
        this.soMu = soMu;
    }

}

public class J01012 {
    public static Scanner sc1 = new Scanner(System.in);

    public static void xuLy(){
        Integer n = sc1.nextInt();

        ArrayList<ThuaSoSNT> dsThuaSoSNT= new ArrayList<>();

        if(n%2 !=0){
            System.out.println("0");
            return;
        }
        
        Integer N= n;
        Double sqrt_n = Math.sqrt(n);
        for(Integer i=2; i<=sqrt_n; i++){
            Integer soMu=0;
            while(N%i==0){
                soMu++;
                N=N/i;
            }
            if(soMu>0){
                dsThuaSoSNT.add(new ThuaSoSNT(i, soMu));
            }
            if(i==N){
                dsThuaSoSNT.add(new ThuaSoSNT(i, 1));
                break;
            }
        }
        if(N>1){
            dsThuaSoSNT.add(new ThuaSoSNT(N, 1));
        }

        Integer p;

        if(dsThuaSoSNT.get(0).getThuaSo()!=2){
            p=0;
        }
        else{
            p = dsThuaSoSNT.get(0).getSoMu();
            for(Integer i=1; i<dsThuaSoSNT.size(); i++){
                p= p *(dsThuaSoSNT.get(i).getSoMu()+1);
            }
        }

        System.out.println(p);
        return;
    }

    public static void main(String[] args) {
        Integer sobotest= sc1.nextInt();

        while(sobotest-- >0){
            xuLy();
        }
    }
}
