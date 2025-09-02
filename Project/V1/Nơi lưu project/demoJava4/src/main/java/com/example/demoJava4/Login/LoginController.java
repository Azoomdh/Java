package com.example.demoJava4.Login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demoJava4.KhachHang.KhachHang;
import com.example.demoJava4.KhachHang.KhachHangService;
import com.example.demoJava4.NhanVien.NhanVien;
import com.example.demoJava4.NhanVien.NhanVienService;
import com.example.demoJava4.Role.Role;
import com.example.demoJava4.Role.RoleService;
import com.example.demoJava4.RolesOfUser.RolesOfUser;
import com.example.demoJava4.RolesOfUser.RolesOfUserKey;
import com.example.demoJava4.RolesOfUser.RolesOfUserService;
import com.example.demoJava4.User.User;
import com.example.demoJava4.User.UserService;

@Controller
public class LoginController {

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    private UserService usersService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private RolesOfUserService rouService;

    @Autowired
    private KhachHangService khachHangService;

    @Autowired
    private NhanVienService nhanVienService;

    @GetMapping("/register")
    public String getAtRegister(Model model){
        User user = new User();
        model.addAttribute("user1", user);
        
        return "Login/register";
    }

    @PostMapping("/register")
    public String postAtRegister
    (
        @ModelAttribute("user1") User user
    )
    {
        System.out.println(user.toString());

        // ma hoa mat khau
        String encodedPassword = this.passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        user.setEnabled(true);

        // tạo user
        user= this.usersService.create(user);

        // tìm id của role client
        Role clientRole = this.roleService.findByName("CLIENT");

        // save role client của user
        RolesOfUserKey rouKey = new RolesOfUserKey(user.getId(), clientRole.getId());
        RolesOfUser rou = new RolesOfUser(rouKey);
        rou = this.rouService.create(rou);

        // save khách hàng của user
        // KhachHang kh = new KhachHang(user.getId());
        // kh = this.khachHangService.create(kh);

        // save nhân viên của user
        NhanVien nv = new NhanVien(user.getId());
        nv= this.nhanVienService.create(nv);

        return "redirect:/login";
    }
}
