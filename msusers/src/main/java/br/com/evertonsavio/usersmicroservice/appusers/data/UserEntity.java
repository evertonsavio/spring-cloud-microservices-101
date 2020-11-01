package br.com.evertonsavio.usersmicroservice.appusers.data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users")
public class UserEntity implements Serializable {

    private static final long serialVersionUID = -4631422745700177221L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long _id;

    @Column(nullable = false, unique = true, length = 120)
    private String email;

    @Column(nullable = false, unique = true)
    private String userPublicId;

    @Column(nullable = false, unique = true)
    private String encryptedPassword;

    /////////////////////////////////////////////////////////////////////////
    ///////////////////////////GETTERS AND SETTERS///////////////////////////


    public Long get_id() {
        return _id;
    }

    public void set_id(Long _id) {
        this._id = _id;
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

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

}
