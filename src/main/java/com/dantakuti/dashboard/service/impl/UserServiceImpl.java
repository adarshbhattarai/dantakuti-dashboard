package com.dantakuti.dashboard.service.impl;

import com.dantakuti.dashboard.document.DantaUser;
import com.dantakuti.dashboard.repository.UserRepository;
import com.dantakuti.dashboard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;


    @Override
    public List<DantaUser> getAllUsers() {
        return userRepository.findAll();
    }
}
