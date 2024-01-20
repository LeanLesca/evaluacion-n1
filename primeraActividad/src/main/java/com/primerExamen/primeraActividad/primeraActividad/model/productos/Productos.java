package com.primerExamen.primeraActividad.primeraActividad.model.productos;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
@Table(name = "productos")
public class Productos implements Serializable {

    @Id
    private int codigoProducto;

    private int codigoEanProducto;

    private String nombre;

    private String descripcion;

    private int precio;

    private int stock;

}
