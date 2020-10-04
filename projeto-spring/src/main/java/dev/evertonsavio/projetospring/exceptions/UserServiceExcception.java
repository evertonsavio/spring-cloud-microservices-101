package dev.evertonsavio.projetospring.exceptions;

public class UserServiceExcception extends RuntimeException {

    public UserServiceExcception(String message) {
        super(message);
    }
}
