package com.primerExamen.primeraActividad.primeraActividad.model.productos;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
@Table(name = "productos")
public class Productos implements Serializable {

    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProducto;

    private int codigoEan;

    private String nombre;

    private String descripcion;

    private int precio;

    private int stock;

}
