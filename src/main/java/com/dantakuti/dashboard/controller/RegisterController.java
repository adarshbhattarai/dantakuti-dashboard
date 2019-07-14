package com.dantakuti.dashboard.controller;


import com.dantakuti.dashboard.document.RegisteredUser;
import com.dantakuti.dashboard.document.User;
import com.dantakuti.dashboard.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;

@RestController
@CrossOrigin(origins = "http://localhost:4200" , maxAge = 3600)
@RequestMapping("/auth")

public class RegisterController {
    @Autowired
    RegistrationService registrationService;
    @PostMapping(value = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> loginInuser(@RequestBody RegisteredUser rUser) throws ServletException {
        String retVal =registrationService.register(rUser);
        if(retVal == null)
            return new ResponseEntity<String>("", HttpStatus.BAD_REQUEST);
        System.out.println("Full name is:" +rUser.getFullName());
        return new ResponseEntity<String>(retVal, HttpStatus.OK);
    }


}
