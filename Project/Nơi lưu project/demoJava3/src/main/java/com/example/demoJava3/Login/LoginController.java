package com.example.demoJava3.Login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demoJava3.KhachHang.KhachHang;
import com.example.demoJava3.KhachHang.KhachHangService;
import com.example.demoJava3.Role.Role;
import com.example.demoJava3.Role.RoleRepo;
import com.example.demoJava3.Role.RoleService;
import com.example.demoJava3.RolesOfUser.RolesOfUser;
import com.example.demoJava3.RolesOfUser.RolesOfUserKey;
import com.example.demoJava3.RolesOfUser.RolesOfUserService;
import com.example.demoJava3.User.Users;
import com.example.demoJava3.User.UsersService;

@Controller
public class LoginController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private RolesOfUserService rouService;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private RoleService roleService;

    @Autowired
    private KhachHangService khService;

    @GetMapping("/register")
    public String getRegister
    (
        Model model
    )
    {
        Users user1 = new Users();
        model.addAttribute("users", user1);
        return "Login/register";
    }

    @PostMapping("/register")
    public String postRegister
    (
        @ModelAttribute("users") Users users
    )
    {
        System.out.println("🟥"+ users.toString());        
        
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(users.getPassword());
        users.setPassword(encodedPassword);
        users.setEnabled(true);

        // Bước 1 : save user thành khách hàng 
        // do tương tranh nên chỉ save bằng kh_service không save bằng user_service
        KhachHang kh1= new KhachHang(users);
        kh1= this.khService.create(kh1);

        // bước 2 : set role của user là client 
        Users user1 = this.usersService.getById(kh1.getMaUser());
        System.out.println("🚧🚧🚧🚧1🚧🚧🚧🚧");
        Role clientRole = this.roleService.getById(3L);
        System.out.println("🚧🚧🚧🚧2🚧🚧🚧🚧");
        RolesOfUserKey rouKey = new RolesOfUserKey(clientRole.getMaRole(), user1.getMaUser());
        System.out.println("🚧🚧🚧🚧3🚧🚧🚧🚧");
        RolesOfUser rou = new RolesOfUser(rouKey, clientRole, user1);
        System.out.println("🚧🚧🚧🚧4🚧🚧🚧🚧");
        rou=this.rouService.create(rou);
        System.out.println("🚧🚧🚧🚧5🚧🚧🚧🚧");


        System.out.println("🟩"+ kh1.toString());

        System.out.println("🟩🟩"+ kh1.toString());

        return "redirect:/login";
    }
}
