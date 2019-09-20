package com.dantakuti.dashboard.service.impl;

import com.dantakuti.dashboard.document.DantaUser;
import com.dantakuti.dashboard.document.User;
import com.dantakuti.dashboard.repository.UserRepository;
import com.dantakuti.dashboard.security.jwtUtil.JwtTokenGenerator;
import com.dantakuti.dashboard.service.UserService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;


    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenGenerator tokenGenerator;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public String login(User user) throws ServletException {
        JSONObject jsonObject=null;
        if (user.getEmail() == null || user.getPassword() == null) {
            throw new ServletException("Username or Password not provided");
        }
        Authentication authentication = authenticationManager.authenticate( new UsernamePasswordAuthenticationToken(user.getEmail(),user.getPassword()));
        String email = ((org.springframework.security.core.userdetails.User) authentication.getPrincipal()).getUsername();
        String jwtToken = tokenGenerator.generateJwtToken(email);
        Map<String, String> jsonMap = new HashMap<>();
        jsonMap.put("token", jwtToken);
        jsonObject = new JSONObject(jsonMap);
        return jsonObject.toString();
    }

    @Override
    public void save(DantaUser user) {
        userRepository.save(user);
    }

    @Override
    public DantaUser findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<DantaUser> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public boolean register(DantaUser dantaUser) throws ServletException {
        if (dantaUser.getEmail() == null || dantaUser.getPassword() == null || dantaUser.getName()==null ) {
            throw new ServletException("Username/Password or Name not provided");
        }
        DantaUser temp = userRepository.findByEmail(dantaUser.getEmail());
        if(temp == null){
            dantaUser.setPassword(bCryptPasswordEncoder.encode(dantaUser.getPassword()));
            userRepository.save(dantaUser);
            return true;
        }
        return false;
    }

}
