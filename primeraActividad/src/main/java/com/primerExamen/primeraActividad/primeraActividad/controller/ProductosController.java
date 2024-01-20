package com.primerExamen.primeraActividad.primeraActividad.controller;

import com.primerExamen.primeraActividad.primeraActividad.model.productos.Productos;
import com.primerExamen.primeraActividad.primeraActividad.service.productos.ProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductosController {

    @Autowired
    private ProductosService productosService;

    private boolean isNuevo = false;

    private int codigoProd = -1;

    @GetMapping("/listaProductos")
    public String listaProductos(Model model){

        var listaProductos = productosService.recuperarListaProductos();
        model.addAttribute("listaProductos",listaProductos);

        return "listadoProductos";
    }

    @PostMapping("/agregar")
    public String irEditarAgregarProducto(Model model ){
        codigoProd = -1;
        return "redirect:/editarAgregarProducto";
    }

    @GetMapping("/editarAgregarProducto")
    public String editarAgregarProducto(Model model){
        int codigoProducto = codigoProd;
        Productos producto;
        if(codigoProducto == -1){
             producto = new Productos();
            isNuevo = true;
        }else{
             producto = productosService.buscarProducto(codigoProducto);
            isNuevo = false;
        }
        model.addAttribute("producto",producto);
        return "editarAgregarProducto";
    }

    @PostMapping("/guardarCambios")
    public String guardarCambios(@RequestParam Productos producto){

        if(isNuevo){
            productosService.agregarProducto(producto);
            isNuevo = false;
        }else{
            productosService.modificarProducto(producto);
        }
        return "redirect:/listaProductos";
    }

    @PostMapping("/eliminar")
    public String eliminarProducto(Model model, @RequestParam int codigoProducto){

        Productos productoEliminar = productosService.buscarProducto(codigoProducto);
        productosService.eliminarProducto(productoEliminar);

        return "listadoProductos";
    }
    @PostMapping("/volver")
    public String volver(){

        return "redirect:/menu";
    }



}
