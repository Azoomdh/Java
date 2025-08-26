package com.example.demoJava3.Login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demoJava3.Role.Role;
import com.example.demoJava3.Role.RoleRepo;
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

        // Bước 1 : save user
        Users user1 = this.usersService.create(users);

        // bước 2 : set role của user là client 
        Role clientRole = this.roleRepo.findByName("CLIENT").get(0);
        RolesOfUserKey rouKey = new RolesOfUserKey(clientRole.getMaRole(), user1.getMaUser());
        RolesOfUser rou = new RolesOfUser(rouKey, clientRole, user1);
        rou=this.rouService.create(rou);
        // user1.getRolesOfUser().add(rou);

        // không cần save user vì       dòng thứ 62 đã      save user cùng với rou
        // bước 2 : save user
        // user1 = this.usersService.create(user1);

        System.out.println("🟩"+ user1.toString());

        return "redirect:/login";
    }
}
