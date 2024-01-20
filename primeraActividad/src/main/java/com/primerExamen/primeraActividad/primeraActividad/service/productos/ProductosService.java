package com.primerExamen.primeraActividad.primeraActividad.service.productos;

import com.primerExamen.primeraActividad.primeraActividad.model.productos.Productos;

import java.util.List;

public interface ProductosService {

    public List<Productos> recuperarListaProductos();

    public void agregarProducto(Productos producto);

    public void eliminarProducto(Productos producto);

    public void editarProducto(Productos producto);
}
