package com.primerExamen.primeraActividad.primeraActividad.model.usuarios;

import org.springframework.data.repository.CrudRepository;

public interface UsuariosRepository extends CrudRepository<Usuarios,Integer> {

   public Usuarios findByNombre(String nombre);
}
