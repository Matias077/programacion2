package org.ejemplo.repository;

import org.ejemplo.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//Metodo para traer usuario en la base de datos
public interface UsuarioRepository extends JpaRepository<Usuario, String> {

    Optional<Usuario> findByUser(String user);



}
