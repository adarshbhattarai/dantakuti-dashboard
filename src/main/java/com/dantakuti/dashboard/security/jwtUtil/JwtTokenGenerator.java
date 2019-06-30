package com.dantakuti.dashboard.security.jwtUtil;

import com.dantakuti.dashboard.config.ApplicationProperties;
import com.dantakuti.dashboard.document.DantaUser;
import com.dantakuti.dashboard.repository.UserRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static com.dantakuti.dashboard.constants.SecurityConstants.EXPIRATION_TIME;

/**
 * @author adarshbhattarai on 2019-06-29
 * @project dashboard
 */
@Component
public class JwtTokenGenerator {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ApplicationProperties applicationProperties;

    public String generateJwtToken(String username){
        Claims claims = Jwts.claims()
                .setSubject(username);

        System.out.println("Secret Key is " +applicationProperties.getSecretKey());
        DantaUser user = userRepository.findByEmail(username);

        claims.put("picture",user.getPicture());
        claims.put("name",user.getName());
        claims.put("roles",user.getRoles());
        claims.put("email",user.getEmail());
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, applicationProperties.getSecretKey())
                .compact();
    }
}
