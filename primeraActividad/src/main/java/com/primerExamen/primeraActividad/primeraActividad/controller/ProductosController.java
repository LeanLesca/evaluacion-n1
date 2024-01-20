package com.primerExamen.primeraActividad.primeraActividad.controller;

import com.primerExamen.primeraActividad.primeraActividad.service.productos.ProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

public class ProductosController {

    @Autowired
    ProductosService productosService;

    @GetMapping("/listaProductos")
    public String listaProductos(Model model){

        return "listadoProductos";
    }

    @PostMapping("/listaProductos")
    public String irEditarAgregarProducto(Model model){

        return "redirect:/editarAgregarProducto";
    }
    @PostMapping("/listaProductos")
    public String eliminarProducto(Model model){

        return "listadoProductos";
    }
    @PostMapping("/listaProductos")
    public String volver(){

        return "redirect:/menu";
    }

    @GetMapping("/editarAgregarProducto")
    public String editarAgregarProducto(Model model){

        return "editarAgregarProducto";
    }

    @PostMapping("/editarAgregarProducto")
    public String guardarCambios(){

        return "redirect:/listaProductos";
    }



}
