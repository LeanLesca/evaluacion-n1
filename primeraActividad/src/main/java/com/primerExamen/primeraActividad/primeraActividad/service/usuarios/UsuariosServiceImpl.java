package com.primerExamen.primeraActividad.primeraActividad.service.usuarios;

import com.primerExamen.primeraActividad.primeraActividad.model.servicios.Servicios;
import com.primerExamen.primeraActividad.primeraActividad.model.usuarios.Usuarios;
import com.primerExamen.primeraActividad.primeraActividad.model.usuarios.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuariosServiceImpl implements UsuariosService{

    @Autowired
    private UsuariosRepository usuariosRepository;

    @Override
    public List<Usuarios> getUsuarios() {
        return (List<Usuarios>) usuariosRepository.findAll();

    }

    @Override
    public Usuarios getUsuarioByNombre(String nombre) {
        return usuariosRepository.findByNombre(nombre);

    }
}
