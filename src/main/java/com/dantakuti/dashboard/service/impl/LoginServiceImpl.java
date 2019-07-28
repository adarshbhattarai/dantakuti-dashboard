package com.dantakuti.dashboard.service.impl;

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

/**
 * @author adarshbhattarai on 2019-06-29
 * @project dashboard
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenGenerator tokenGenerator;

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
}
