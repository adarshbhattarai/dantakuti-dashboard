package com.dantakuti.dashboard.service;

import javax.servlet.ServletException;

import com.dantakuti.dashboard.document.DantaUser;

/*/
Registration interface
implementation under impl dir
 */
public interface RegistrationService {

    void register(DantaUser user) throws ServletException;

    boolean checkUserExists(DantaUser user) throws ServletException;
}
