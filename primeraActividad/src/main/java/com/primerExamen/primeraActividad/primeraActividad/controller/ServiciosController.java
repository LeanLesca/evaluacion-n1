package com.primerExamen.primeraActividad.primeraActividad.controller;

import com.primerExamen.primeraActividad.primeraActividad.model.productos.Productos;
import com.primerExamen.primeraActividad.primeraActividad.model.servicios.Servicios;
import com.primerExamen.primeraActividad.primeraActividad.service.servicios.ServiciosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ServiciosController {

    @Autowired
    private ServiciosService serviciosService;

    private boolean isNuevo = false;

    private int codigoServ = -1;


    @GetMapping("/listaServicios")
    public String listaProductos(Model model) {

        var listaServicios = serviciosService.recuperarListaServicios();
        model.addAttribute("listaServicios", listaServicios);

        return "listadoServicios";
    }

    @PostMapping("/agregar")
    public String irEditarAgregarProducto(Model model) {
        codigoServ = -1;
        return "redirect:/editarAgregarProducto";
    }

    @GetMapping("/editarAgregarProducto")
    public String editarAgregarProducto(Model model) {
        int codigoProducto = codigoServ;
        Servicios servicio;
        if (codigoProducto == -1) {
             servicio = new Servicios();
            isNuevo = true;
        } else {
            servicio = serviciosService.buscarServicio(codigoProducto);
            isNuevo = false;
        }
        model.addAttribute("servicio",servicio);

        return "editarAgregarProducto";
    }

    @PostMapping("/guardarCambios")
    public String guardarCambios(@RequestParam Servicios servicio) {

        if (isNuevo) {
            serviciosService.agregarServicio(servicio);
            isNuevo = false;
        } else {
            serviciosService.modificarServicio(servicio);
        }
        return "redirect:/listaProductos";
    }

    @PostMapping("/eliminar")
    public String eliminarProducto(Model model, @RequestParam int codigoServicio) {

        Servicios servicioEliminar = serviciosService.buscarServicio(codigoServicio);
        serviciosService.eliminarServicio(servicioEliminar);

        return "listadoProductos";
    }

    @PostMapping("/volver")
    public String volver() {

        return "redirect:/menu";
    }
}