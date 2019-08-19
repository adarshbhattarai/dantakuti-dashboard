package com.dantakuti.dashboard.service.impl;

import com.dantakuti.dashboard.document.DantaUser;
import com.dantakuti.dashboard.repository.UserRepository;
import com.dantakuti.dashboard.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;


import com.dantakuti.dashboard.security.jwtUtil.JwtTokenGenerator;
import org.json.JSONObject;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;

@Service
public class RegistrtaionServiceImpl implements RegistrationService {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenGenerator jwtTokenGenerator;

    @Autowired
    private UserRepository repo;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void register(DantaUser dantaUser) throws ServletException{

    JSONObject jsonObject=null;

    if (dantaUser.getEmail() == null || dantaUser.getPassword() == null || dantaUser.getName()==null ) {
        throw new ServletException("Username/Password or Name not provided");
    }

    String password=dantaUser.getPassword();
    dantaUser.setPassword(bCryptPasswordEncoder.encode(password));
    repo.save(dantaUser);

    }

    @Override
    public boolean checkUserExists(DantaUser user) throws ServletException {
        DantaUser testUser=null;
        boolean userFound=false;
        try {
            testUser = repo.findByEmail(user.getEmail());
            userFound=true;
        }
        catch (Exception e) {
            userFound=false;
        }
        return userFound;
    }
}
