package com.dantakuti.dashboard.controller;
import com.dantakuti.dashboard.document.DantaUser;
import com.dantakuti.dashboard.document.Role;
import com.dantakuti.dashboard.document.User;
import com.dantakuti.dashboard.repository.UserRepository;
import com.dantakuti.dashboard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
//@CrossOrigin(origins = "http://localhost:4200" , maxAge = 3600)
@RequestMapping("/rest/users")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;


    @GetMapping("/")
    public List<DantaUser> getAllUsers(){
        return  userService.getAllUsers();
    }

    @GetMapping("/users")
    public DantaUser findByUser(){

        String email = userService.getAllUsers().get(0).getEmail();
        return  userRepository.findByEmail(email);
    }

    @GetMapping("/save")
    public void saveAll(){
        Set<Role> roles = new HashSet<>();
        Role admin = new Role();
        admin.setRole("ADMIN");
        admin.setId("1");
        Role user = new Role();
        user.setId("2");
        user.setRole("USER");
        roles.add(admin);
        roles.add(user);
    }

    @PostMapping("/value")
    public void loginInuser(@RequestBody User user){
        System.out.println(user.getEmail());
        System.out.println(user.getPassword());
        System.out.println("Here");
    }
}
