package com.primerExamen.primeraActividad.primeraActividad.controller;

import com.primerExamen.primeraActividad.primeraActividad.model.usuarios.Usuarios;
import com.primerExamen.primeraActividad.primeraActividad.service.usuarios.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    UsuariosService usuarioService;

    @GetMapping("/login")
    public String login() {
        return "index";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password, Model model){
        try{
            Usuarios user = usuarioService.getUsuarioByNombre(username);
            System.out.println(user);
            if (user != null && user.getPasswordUsuario().equals(password)) {
                // Autenticación exitosa
                return "redirect:/menu";
            } else {
                // Autenticación falla
                model.addAttribute("mensaje_error", "usuario no existe o contraseña incorrectos");
                return "index";
            }
        } catch (DataAccessException e){
            model.addAttribute("mensaje_error", "Error al acceder a los datos");
            e.printStackTrace();
            return "index";
                     }
         }

    @GetMapping("/menu")
    public String menu(){
        return "menu";
    }

    @PostMapping("/servicios")
    public String redireccionarServicios(){

        return "redirect:/listaServicios";


    }
    @PostMapping("/productos")
    public String redireccionarProductos(){

        return "redirect:/listaProductos";


    }
}
