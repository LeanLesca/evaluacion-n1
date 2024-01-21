package com.primerExamen.primeraActividad.primeraActividad.controller;

import com.primerExamen.primeraActividad.primeraActividad.model.servicios.Servicios;
import com.primerExamen.primeraActividad.primeraActividad.service.servicios.ServiciosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ServiciosController {

    @Autowired
    private ServiciosService serviciosService;

    private boolean isNuevo = false;

    @Value("${tituloServicios}")
    private String tituloServicio;

    @GetMapping("/listaServicios")
    public String listaProductos(Model model) {

        var listaServicios = serviciosService.recuperarListaServicios();
        model.addAttribute("tituloServicio", tituloServicio);
        model.addAttribute("listaServicios", listaServicios);

        return "listadoServicios";
    }

    @PostMapping("/nuevo")
    public String irEditarAgregarServicio(Model model) {

        return "redirect:/editarAgregarServicio";
    }

    @GetMapping("/editarAgregarServicio")
    public String AgregarServicio(Model model) {

        Servicios servicio = new Servicios();
        model.addAttribute("servicio",servicio);

        return "editarAgregarServicio";
    }

    @GetMapping("/editarAgregarServicio/{idServicio}")
    public String editarServicio(Servicios servicio, Model model){
        Servicios servicio1 = serviciosService.buscarServicio(servicio.getIdServicio());

        model.addAttribute("servicio",servicio1);

        return "editarAgregarServicio";
    }

    @PostMapping("/guardarCambios")
    public String guardarCambios(Servicios servicio) {
            serviciosService.guardarServicio(servicio);

        return "redirect:/listaServicios";
    }

    @GetMapping("/delete/{idServicio}")
    public String eliminarProducto(Servicios servicio,Model model) {

        Servicios servicioEliminar = serviciosService.buscarServicio(servicio.getIdServicio());
        serviciosService.eliminarServicio(servicioEliminar);

        return "redirect:/listaServicios";
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