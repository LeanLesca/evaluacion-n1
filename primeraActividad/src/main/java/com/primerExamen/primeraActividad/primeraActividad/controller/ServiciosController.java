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

    @PostMapping("/nuevo")
    public String irEditarAgregarServicio(Model model) {
        codigoServ = -1;
        return "redirect:/editarAgregarServicio";
    }

    @GetMapping("/editarAgregarServicio")
    public String editarAgregarServicio(Model model) {
        int codigoServicio = codigoServ;
        Servicios servicio;
        if (codigoServicio == -1) {
             servicio = new Servicios();
            isNuevo = true;
        } else {
            servicio = serviciosService.buscarServicio(codigoServicio);
            isNuevo = false;
        }
        model.addAttribute("servicio",servicio);

        return "editarAgregarServicio";
    }

    @PostMapping("/guardarCambios")
    public String guardarCambios(@RequestParam Servicios servicio) {
            serviciosService.guardarServicio(servicio);

        return "redirect:/listaServicios";
    }

    @PostMapping("/delete")
    public String eliminarProducto(Model model, @RequestParam int codigoServicio) {

        Servicios servicioEliminar = serviciosService.buscarServicio(codigoServicio);
        serviciosService.eliminarServicio(servicioEliminar);

        return "listadoServicios";
    }

    @PostMapping("/regresar")
    public String volver() {

        return "redirect:/menu";
    }

    @PostMapping("/cancel")
    public String cancelar(){

        return "redirect:/listaServicios";
    }
}