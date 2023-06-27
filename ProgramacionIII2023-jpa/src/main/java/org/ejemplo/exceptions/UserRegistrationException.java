package org.ejemplo.exceptions;

public class UserRegistrationException extends RuntimeException {

    public UserRegistrationException(String mensaje) {
        super(mensaje);
    }
}
