package org.ejemplo.servicios;

import lombok.extern.slf4j.Slf4j;
import org.ejemplo.exceptions.UserAuthenticationException;
import org.ejemplo.exceptions.UserException;
import org.ejemplo.exceptions.UserRegistrationException;
import org.ejemplo.modelos.Login;
import org.ejemplo.modelos.Usuario;
import org.ejemplo.repository.UsuarioRepository;
import org.ejemplo.validations.UserValidations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {
    private final UsuarioRepository usuarioRepository;
    private final UserValidations userValidations;

    @Autowired
    public UsersService(UsuarioRepository usuarioRepository, UserValidations userValidations) {
        this.usuarioRepository = usuarioRepository;
        this.userValidations = userValidations;
    }

    public void registrarUsuario(Usuario usuario) {
        userValidations.validateExistingUser(usuario.getUser());
        userValidations.validateRole(usuario.getRole());
        usuarioRepository.save(usuario);
    }

    public boolean autenticarUsuario(Login login) {
        Usuario usuarioDB = usuarioRepository.findByUser(login.getUser())
                .orElseThrow(() -> new UserAuthenticationException("Usuario no encontrado"));

        return usuarioDB.getPassword().equals(login.getPassword());
    }

    public String login(Login login) {
        if (autenticarUsuario(login)) {
            Usuario usuarioDB = usuarioRepository.findByUser(login.getUser())
                    .orElseThrow(() -> new UserAuthenticationException("Usuario no encontrado"));

            return usuarioDB.getRole();
        } else {
            throw new UserAuthenticationException("Credenciales de inicio de sesión inválidas");
        }
    }
}



