package com.primerExamen.primeraActividad.primeraActividad.model.servicios;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
@Table(name = "servicios")
public class Servicios implements Serializable {

    @Id
    private int codigoServicio;

    private int codigoEanServicio;

    private String nombre;

    private int precio;

    private int duracion;
}
