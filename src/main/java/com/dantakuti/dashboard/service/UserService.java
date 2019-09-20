package com.dantakuti.dashboard.service;

import com.dantakuti.dashboard.document.DantaUser;
import com.dantakuti.dashboard.document.User;

import javax.servlet.ServletException;
import java.util.List;

public interface UserService {

   public List<DantaUser> getAllUsers();
   boolean register(DantaUser user) throws ServletException;
   String login(User user) throws ServletException;

    void save(DantaUser user);

    DantaUser findByEmail(String email);
}
