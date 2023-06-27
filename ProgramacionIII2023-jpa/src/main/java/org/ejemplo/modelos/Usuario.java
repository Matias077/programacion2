package org.ejemplo.modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name="usuarios")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Usuario {
    @Id
    @Column(name = "name")
    private String user;
    @Column(name = "password")
    private String password;
    @Column(name = "role")
    private String role;
}
