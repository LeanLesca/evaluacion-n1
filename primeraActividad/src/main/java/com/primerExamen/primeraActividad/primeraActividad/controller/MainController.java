package com.primerExamen.primeraActividad.primeraActividad.controller;

import com.primerExamen.primeraActividad.primeraActividad.service.usuarios.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @Autowired
    UsuariosService usuariosService;


    @GetMapping("/login")
    public String index(){
        return "index";
    }

    @PostMapping("/login")
    public String index(Model model){

        if(true){
            return "redirect:/menu";
        }else {
            return "index";
        }

    }

    @GetMapping("/menu")
    public String menu(){
        return "index";
    }

    @PostMapping("/menu")
    public String menu(Model model){

        if(true){
            return "redirect:/listaProductos";
        }else {
            return "redirect:/listaServicios";
        }

    }





}
