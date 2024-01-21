package com.primerExamen.primeraActividad.primeraActividad.model.servicios;


import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
@Table(name = "servicios")
public class Servicios implements Serializable {

    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idServicio;

    private int codigoEan;

    private String nombre;

    private String descripcion;

    private int precio;

    private int duracion;
}
