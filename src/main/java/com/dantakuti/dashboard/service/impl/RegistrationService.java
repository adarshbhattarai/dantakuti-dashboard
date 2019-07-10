package com.dantakuti.dashboard.service.impl;

import javax.servlet.ServletException;
import com.dantakuti.dashboard.document.User;

/*/
Registration interface
implementation under impl dir
 */
public interface RegistrationService {

    String register(User user) throws ServletException;
}
