package com.dantakuti.dashboard.service.impl;

import com.dantakuti.dashboard.document.RegisteredUser;
import com.dantakuti.dashboard.document.User;
import com.dantakuti.dashboard.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;


import com.dantakuti.dashboard.security.jwtUtil.JwtTokenGenerator;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;

@Service
public class RegistrtaionServiceImpl implements RegistrationService {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenGenerator jwtTokenGenerator;

    @Override
    public String register(RegisteredUser registeredUser) throws ServletException{

    JSONObject jsonObject=null;
    if (registeredUser.getEmailAddress() == null || registeredUser.getPassword() == null || registeredUser.getFullName()==null ) {
        throw new ServletException("Username/Password or Name not provided");
    }

        return jsonObject.toString();//just for testing

    }

}
