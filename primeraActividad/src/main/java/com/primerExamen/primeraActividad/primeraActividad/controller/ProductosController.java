package com.primerExamen.primeraActividad.primeraActividad.controller;

import com.primerExamen.primeraActividad.primeraActividad.model.productos.Productos;
import com.primerExamen.primeraActividad.primeraActividad.service.productos.ProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductosController {

    @Autowired
    private ProductosService productosService;

    private boolean isNuevo = false;

    @Value("${tituloProductos}")
    private String tituloProductos;

    @GetMapping("/listaProductos")
    public String listaProductos(Model model){

        var listaProductos = productosService.recuperarListaProductos();
        model.addAttribute("tituloProducto", tituloProductos);
        model.addAttribute("listaProductos",listaProductos);

        return "listadoProductos";
    }

    @GetMapping("/editarAgregarProducto")
    public String AgregarProducto(Model model){
        Productos producto = new Productos();

        model.addAttribute("producto",producto);
        return "editarAgregarProducto";
    }

    @PostMapping("/agregar")
    public String irEditarAgregarProducto(Model model) {
        return "redirect:/editarAgregarProducto";
    }

    @GetMapping("/editarAgregarProducto/{idProducto}")
    public String editarProducto(Productos producto, Model model){
        Productos producto1 = productosService.buscarProducto(producto.getIdProducto());
        model.addAttribute("producto",producto1);
        return "editarAgregarProducto";
    }


    @PostMapping("/editarAgregarProducto")
    public String guardarCambios(Productos producto){

        productosService.guardarProducto(producto);

        return "redirect:/listaProductos";
    }

    @GetMapping("/eliminar/{idProducto}")
    public String eliminarProducto(Productos producto, Model model){
        Productos productoEliminar = productosService.buscarProducto(producto.getIdProducto());
        productosService.eliminarProducto(productoEliminar);

        return "redirect:/listaProductos";
    }
    @PostMapping("/volver")
    public String volver(){

        return "redirect:/menu";
    }

    @PostMapping("/cancelar")
    public String cancelar(){

        return "redirect:/listaProductos";
    }
}
