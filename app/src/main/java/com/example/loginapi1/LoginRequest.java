package com.example.loginapi1;

public class LoginRequest {
    public String CNIC;
    public String password;

    public String getCNIC() {
        return CNIC;
    }

    public void setCNIC(String username) {
        this.CNIC = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
