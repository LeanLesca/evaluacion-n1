package com.primerExamen.primeraActividad.primeraActividad.service.servicios;

import com.primerExamen.primeraActividad.primeraActividad.model.servicios.Servicios;
import com.primerExamen.primeraActividad.primeraActividad.model.servicios.ServiciosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiciosServiceImpl implements ServiciosService{

    @Autowired
    private ServiciosRepository serviciosRepository;

    @Override
    public List<Servicios> recuperarListaServicios() {
        return null;
    }

    @Override
    public void agregarServicio(Servicios producto) {

    }

    @Override
    public void modificarServicio(Servicios producto) {

    }

    @Override
    public void eliminarPServicio(Servicios producto) {

    }

    @Override
    public Servicios buscarServicio(int codigoServicio) {
        return serviciosRepository.findByCodigoServicio(codigoServicio);

    }

}
