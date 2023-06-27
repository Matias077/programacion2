package org.ejemplo.validations;

import org.ejemplo.exceptions.UserException;
import org.ejemplo.exceptions.UserRegistrationException;
import org.ejemplo.modelos.Usuario;
import org.ejemplo.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

import java.util.List;

public class UserValidations {
    private final UsuarioRepository usuarioRepository;

    public UserValidations(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void validateExistingUser(String username) {
        if (usuarioRepository.findByUser(username).isPresent()) {
            throw new UserRegistrationException("El usuario ya está registrado");
        }
    }

    public void validateRole(String role) {
        if (!role.equals("administrador") && !role.equals("vendedor")) {
            throw new UserRegistrationException("El rol del usuario es inválido");
        }
    }
}

