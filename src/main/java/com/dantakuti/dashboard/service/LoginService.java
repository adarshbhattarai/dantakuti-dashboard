package com.dantakuti.dashboard.service;

import com.dantakuti.dashboard.document.DantaUser;
import com.dantakuti.dashboard.document.User;

import javax.servlet.ServletException;

/**
 * @author adarshbhattarai on 2019-06-29
 * @project dashboard
 */
public interface LoginService {

    String login(User user) throws ServletException;
}
