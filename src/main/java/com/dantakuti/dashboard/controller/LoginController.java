package com.dantakuti.dashboard.controller;

import com.dantakuti.dashboard.constants.SecurityConstants;
import com.dantakuti.dashboard.document.User;
import com.dantakuti.dashboard.security.jwtUtil.JwtTokenGenerator;
import com.dantakuti.dashboard.service.LoginService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

import static com.dantakuti.dashboard.constants.SecurityConstants.*;
import static com.dantakuti.dashboard.constants.SecurityConstants.TOKEN_PREFIX;

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
