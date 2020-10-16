package br.com.padotec.usersmicroservice.padousers.models;

public class ResponseModel {

    private String userPublicId;
    private String email;

    public String getUserId() {
        return userPublicId;
    }

    public void setUserId(String userId) {
        this.userPublicId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
