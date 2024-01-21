package com.primerExamen.primeraActividad.primeraActividad.service.productos;


import com.primerExamen.primeraActividad.primeraActividad.model.productos.Productos;
import com.primerExamen.primeraActividad.primeraActividad.model.productos.ProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductosServiceImpl implements ProductosService{

    @Autowired
    private ProductosRepository productosRepository;

    @Override
    public List<Productos> recuperarListaProductos() {

        return (List<Productos>) productosRepository.findAll();
    }

    @Override
    public void guardarProducto(Productos producto) {
        productosRepository.save(producto);
    }


    @Override
    public void eliminarProducto(Productos producto) {
        productosRepository.delete(producto);
    }

    @Override
    public Productos buscarProducto(int idProducto) {
        return productosRepository.findByIdProducto(idProducto);
    }



}
