package com.primerExamen.primeraActividad.primeraActividad.service.servicios;

import com.primerExamen.primeraActividad.primeraActividad.model.servicios.Servicios;

import java.util.List;

public interface ServiciosService {

    public List<Servicios> recuperarListaServicios();

    public void guardarServicio(Servicios producto);

    public void eliminarServicio(Servicios producto);

    public Servicios buscarServicio(int codigoServicio);

}
