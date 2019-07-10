package com.dantakuti.dashboard.service;

import com.dantakuti.dashboard.document.User;
import com.dantakuti.dashboard.service.impl.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;


import com.dantakuti.dashboard.document.User;
import com.dantakuti.dashboard.security.jwtUtil.JwtTokenGenerator;
import com.dantakuti.dashboard.service.LoginService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import java.util.HashMap;
import java.util.Map;


import javax.servlet.ServletException;

@Service
public class RegistrtaionServiceImpl implements RegistrationService {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenGenerator jwtTokenGenerator;

    @Override
    public String register(User user) throws ServletException{

    JSONObject jsonObject=null;
    if (user.getEmail() == null || user.getPassword() == null || user.getFullName()==null) {
        throw new ServletException("Username/Password or Name not provided");
    }

//    Authentication authentication = authenticationManager.authenticate( new UsernamePasswordAuthenticationToken(user.getEmail(),user.getPassword()));









        return "";

    }

}
