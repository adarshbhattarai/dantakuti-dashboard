package com.dantakuti.dashboard.security.providers;

import com.dantakuti.dashboard.document.DantaUser;
import com.dantakuti.dashboard.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author adarshbhattarai on 2019-06-10
 * @project dashboard
 */

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        DantaUser user = Optional.ofNullable(userRepository.findByEmail(email))
                .orElseThrow(() -> new UsernameNotFoundException("username not found"));
        List<GrantedAuthority> authorityTerminator = AuthorityUtils.createAuthorityList("ROLE_USER", "ROLE_ADMIN","ROLE_TERMINATOR");
        List<GrantedAuthority> authorityListAdmin = AuthorityUtils.createAuthorityList("ROLE_USER", "ROLE_ADMIN");
        List<GrantedAuthority> authorityListUser = AuthorityUtils.createAuthorityList("ROLE_USER");
        return new User(user.getEmail(),user.getPassword(),authorityListUser);
    }

}
