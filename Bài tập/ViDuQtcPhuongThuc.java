public class ViDuQtcPhuongThuc {
    
}

class VatPham {
    private Integer id;

    private Integer getIdPrivate(){
        return id;
    }
    protected Integer getIdProtected(){
        return id;
    }
    public Integer getIdPublic(){
        return id;
    }

    public Integer getIdStatic(){
        return 0;
    }
}

abstract class VatPhamAbstract{
    private Integer id;

    private Integer getIdPrivate(){
        return id;
    }
    protected Integer getIdProtected(){
        return id;
    }
    public Integer getIdPublic(){
        return id;
    }

    public Integer getIdStatic(){
        return 0;
    }

    public abstract Integer getIdAbstract();
}

interface BanDuocInterface {
    
    public static Integer getIdStatic(){
        return 0;
    }

    public abstract Integer getIdAbstract();
}