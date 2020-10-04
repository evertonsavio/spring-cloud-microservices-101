package br.com.padotec.usersmicroservice.padousers.shared;

import java.io.Serializable;

public class UserDto implements Serializable {

    private static final long serialVersionUID = -3023001541707648777L;

    private String userId;
    private String email;
    private String password;
    private String encryptedPassword;

    /////////////////////////////////////////////
    /////////////GETTERS AND SETTERS/////////////
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }
}
