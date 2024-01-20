package com.primerExamen.primeraActividad.primeraActividad.model.productos;

import com.primerExamen.primeraActividad.primeraActividad.model.usuarios.Usuarios;
import org.springframework.data.repository.CrudRepository;

public interface ProductosRepository extends CrudRepository<Productos,Integer> {

    public Productos findByCodigoProducto(int codigoProducto);

}
