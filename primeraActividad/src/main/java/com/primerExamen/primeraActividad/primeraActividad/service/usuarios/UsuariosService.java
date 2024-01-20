package com.primerExamen.primeraActividad.primeraActividad.service.usuarios;

import com.primerExamen.primeraActividad.primeraActividad.model.servicios.Servicios;
import com.primerExamen.primeraActividad.primeraActividad.model.usuarios.Usuarios;

import java.util.List;

public interface UsuariosService {

    public List<Usuarios> getUsuarios();


    public Usuarios getUsuarioByNombre(String nombre);


}
