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

        return (List<Servicios>)serviciosRepository.findAll() ;
    }

    @Override
    public void guardarServicio(Servicios servicio) {
        serviciosRepository.save(servicio);
    }

    @Override
    public void eliminarServicio(Servicios servicio) {
        serviciosRepository.delete(servicio);
    }

    @Override
    public Servicios buscarServicio(int idServicio) {
        return serviciosRepository.findByIdServicio(idServicio);

    }

}
