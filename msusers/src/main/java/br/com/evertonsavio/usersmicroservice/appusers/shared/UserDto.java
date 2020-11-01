package br.com.evertonsavio.usersmicroservice.appusers.shared;

import br.com.evertonsavio.usersmicroservice.appusers.models.AlbumResponseModel;

import java.io.Serializable;
import java.util.List;

public class UserDto implements Serializable {

    private static final long serialVersionUID = -3023001541707648777L;

    private String userPublicId;
    private String email;
    private String password;
    private String encryptedPassword;
    private List<AlbumResponseModel> albums;

    ////////////////////////////////////////////////////////////////////////
    /////////////////////////GETTERS AND SETTERS////////////////////////////

    public List<AlbumResponseModel> getAlbums() {
        return albums;
    }

    public void setAlbums(List<AlbumResponseModel> albums) {
        this.albums = albums;
    }

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
