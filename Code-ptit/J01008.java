import java.util.ArrayList;
import java.util.Scanner;

class ThuaSo{
    private Long snt;
    private long  somu;
    public ThuaSo(Long snt, Long somu) {
        this.snt = snt;
        this.somu = somu;
    }
    public Long getSnt() {
        return snt;
    }
    public void setSnt(Long snt) {
        this.snt = snt;
    }
    public Long getSomu() {
        return somu;
    }
    public void setSomu(Long somu) {
        this.somu = somu;
    }
    @Override
    public String toString() {
        return snt + "(" + somu + ") ";
    }
    
}

class So{
    private Long giatri;
    private ArrayList<ThuaSo> dsThuaSo= new ArrayList<>();
    public Long getGiatri() {
        return giatri;
    }
    public void setGiatri(Long giatri) {
        this.giatri = giatri;
    }
    public ArrayList<ThuaSo> getDsThuaSo() {
        return dsThuaSo;
    }

    public So(Long giatri) {
        this.giatri = giatri;
        this.khoiTaoDsThuaSo();
    }

    public void khoiTaoDsThuaSo(){
        Long n = giatri;

        Double cbhN = Math.sqrt(n);
        for(Long i=2L; i<=n; i++) {
            Long somu=0L;
            if(n%i ==0L){
                while(n%i==0){
                    somu++;
                    n=n/i;
                }
                this.dsThuaSo.add(new ThuaSo(i, somu));
            }
        }
        if(n!=1){
            this.dsThuaSo.add(new ThuaSo(n, 1L));
        }
    }
    @Override
    public String toString() {
        String s1 ="";
        for(ThuaSo ts1 : this.dsThuaSo){
            s1= s1+ ts1.toString();
        }
        return s1;
    }
    
}

public class J01008 {
    public static Scanner sc1 = new Scanner(System.in);



    public static void main(String[] args) {
        Integer numTest = sc1.nextInt();

        for(Long i=1L; i<=numTest; i++){
            Long n = sc1.nextLong();
            So num1 = new So(n);
            System.out.println("Test "+ i+ ": "+ num1.toString());
        }
    }
}
