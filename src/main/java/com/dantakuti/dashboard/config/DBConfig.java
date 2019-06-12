package com.dantakuti.dashboard.config;

import com.dantakuti.dashboard.document.DantaUser;
import com.dantakuti.dashboard.document.Role;
import com.dantakuti.dashboard.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@EnableMongoRepositories(basePackageClasses = UserRepository.class)
@Configuration
public class DBConfig {

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    /*@Bean
    CommandLineRunner commandLineRunner(UserRepository repository){
        Set<Role> roles = new HashSet<>();
        Role admin = new Role();
        admin.setRole("ADMIN");
        admin.setId("1");
        Role user = new Role();
        user.setId("2");
        user.setRole("USER");
        roles.add(admin);
        roles.add(user);
        return i->{
            repository.save(new DantaUser(1,"Aastha","aasthapoudel.ap@gmail.com",bCryptPasswordEncoder.encode("test"),"asdsada.jpg",roles));
            repository.save(new DantaUser(2,"Aasthadarsh","adarshBhattarai@gmail.com",bCryptPasswordEncoder.encode("test"),"dasdad.jpg",roles));

        };
    }
*/
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }
}
