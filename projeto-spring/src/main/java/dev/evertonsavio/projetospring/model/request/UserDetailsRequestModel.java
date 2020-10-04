package dev.evertonsavio.projetospring.model.request;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDetailsRequestModel {

    @NotNull(message = "First name can not be empty")
    private String firstName;

    @NotNull(message = "Can not be empty")
    private String lastName;

    @Email
    @NotNull(message = "Can not be empty")
    @Size(min = 8, max = 16, message = "Entre 8 e 16 caracteres")
    private String email;

    public String getFirstName() {
        return firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String fistName) {
        this.firstName = fistName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
