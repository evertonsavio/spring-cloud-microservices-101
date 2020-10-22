package br.com.evertonsavio.usersmicroservice.appusers.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginRequestModel {

    private String email;
    private String password;

    ///////////////////////////////////////////////////////////////
    /////////////////////GETTERS AND SETTERS //////////////////////

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
