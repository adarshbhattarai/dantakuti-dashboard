package com.dantakuti.dashboard.document;

/**
 * @author adarshbhattarai on 2019-06-11
 * @project dashboard
 */
public class User {
    private String email;
    private String password;
    private String fullName;


    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
