package com.primerExamen.primeraActividad.primeraActividad.controller;

import com.primerExamen.primeraActividad.primeraActividad.service.servicios.ServiciosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ServiciosController {

    @Autowired
    private ServiciosService serviciosService;

    @GetMapping("/listaServicios")
    public String listaProductos(Model model){

        return "listadoServicios";
    }

    @PostMapping("/listaServicios")
    public String irEditarAgregarServicio(Model model){

        return "redirect:/editarAgregarServicio";
    }

    @PostMapping("/listaServicios")
    public String elimnarServicio(Model model){

        return "listadoServicios";
    }

    @PostMapping("/listaServicios")
    public String volver(){

        return "redirect:/menu";
    }

    @GetMapping("/editarAgregarServicio")
    public String editarAgregarServicio(Model model){

        return "editarAgregarServicio";
    }

    @PostMapping("/editarAgregarServicio")
    public String guardarCambios(){

        return "redirect:/listaServicios";
    }



}
