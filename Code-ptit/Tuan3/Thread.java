public class Thread {

    @Autowired
    private UserDataRepo userdataRepo;

    @Autowired
    private FunctionQueue functionQueue;

    public void run(){
        while(true){
            Function ham1 = this.functionQueue.getBottom();
            ham1.excute();
        }
    }

    public void ham1(){
        // chay trong ham 1

        @call_hàm_bên_ngoài_tạm_thời_bỏ_qua(id =1) 
        User user = ()-> {
            user = this.userRepo.findById(id);
            // set thuộc tính user
            return user;
        }

        @chỉ_chạy_khi_đã_nhận_được_kết_quả_từ_các_id(1) : {
            //...
        }

        @chỉ_chạy_khi_đã_nhận_được_kết_quả_từ_các_id(null) {
            // không cần vẫn chạy được
            // ...
        } 
    }

    public void ham2(){
        // chạy trong ham 2

        @call_hàm_bên_ngoài 
        // xóa ham2.this khỏi functionQueue
        User user1 = ()->{
            user = this.userRepo.findById(id);
            //...

            // khi nào xong thì đẩy dòng bên dưới vào đỉnh của queue
            this.functionQueue.addTop(ham2.this, parameter: {user, } );
        }
        // chạy trong ham2

        @call_hàm_bên_ngoài 
        // xóa ham2.this khỏi functionQueue
        User user1 = ()->{
            user = this.userRepo.findById(id);
            //...

            // khi nào xong thì đẩy dòng bên dưới vào đỉnh của queue
            this.functionQueue.addTop(ham2.this, parameter: {user, } );
        }
        // chạy trong ham2

    }
}
