package com.dantakuti.dashboard.controller;

import com.dantakuti.dashboard.document.DantaUser;
import com.dantakuti.dashboard.document.User;
import com.dantakuti.dashboard.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;

/**
 * @author adarshbhattarai on 2019-06-15
 * @project dashboard
 */
@RestController
//@CrossOrigin(origins = "http://localhost:4200" , maxAge = 3600)
@RequestMapping("/auth")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> loginInuser(@RequestBody User user) throws ServletException {
        String token = userService.login(user);
        if(token == null)
            return new ResponseEntity<String>("", HttpStatus.BAD_REQUEST);
        return new ResponseEntity<String>(token, HttpStatus.OK);
    }

    @PostMapping(value = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> loginInuser(@RequestBody DantaUser dantaUser) throws ServletException {
        boolean registerUser = userService.register(dantaUser);
        if(!registerUser)
            return new ResponseEntity<String>("User Already Exist", HttpStatus.BAD_REQUEST);
        return new ResponseEntity<String>("", HttpStatus.OK);
    }

 /*   @GetMapping("/save")
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
    }*/

}
