package br.com.padotec.usersmicroservice.padousers.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserModel {

    @Email
    @Size(min = 6)
    @NotNull(message = "Não pode ser deixado em branco")
    private String email;

    @Size(min = 6, max = 16)
    @NotNull(message = "Não pode ser deixado em branco")
    private String password;

    ///////////////////////////////////////////////////////////////
    /////////////////////GETTERS AND SETTERS //////////////////////

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
