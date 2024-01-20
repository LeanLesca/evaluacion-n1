package com.primerExamen.primeraActividad.primeraActividad.model.usuarios;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
@Table(name = "usuarios")
public class Usuarios implements Serializable {

    @Id
    private int nroUsuario;

    private String nombre;

    private String password;
}
