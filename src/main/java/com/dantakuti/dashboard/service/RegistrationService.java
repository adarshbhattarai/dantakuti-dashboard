package com.dantakuti.dashboard.service;

import javax.servlet.ServletException;

import com.dantakuti.dashboard.document.RegisteredUser;
/*/
Registration interface
implementation under impl dir
 */
public interface RegistrationService {

    String register(RegisteredUser user) throws ServletException;

    boolean checkUserExists(RegisteredUser user) throws ServletException;
}
