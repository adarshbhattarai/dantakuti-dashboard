package com.dantakuti.dashboard.document;


/*
 * @author Rishab
 * @project dashboard
 *
 */

public class RegisteredUser {

    private String fullName;
    private String emailAddress;
    private String password;


    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}