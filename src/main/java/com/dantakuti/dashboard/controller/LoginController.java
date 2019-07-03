package com.dantakuti.dashboard.controller;

import com.dantakuti.dashboard.document.User;
import com.dantakuti.dashboard.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;

/**
 * @author adarshbhattarai on 2019-06-15
 * @project dashboard
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200" , maxAge = 3600)
@RequestMapping("/auth")
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> loginInuser(@RequestBody User user) throws ServletException {
        String token = loginService.login(user);
        if(token == null)
            return new ResponseEntity<String>("", HttpStatus.BAD_REQUEST);
        return new ResponseEntity<String>(token, HttpStatus.OK);
    }

}
