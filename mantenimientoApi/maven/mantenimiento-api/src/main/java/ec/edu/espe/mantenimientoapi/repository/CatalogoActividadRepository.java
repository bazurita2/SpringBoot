package ec.edu.espe.mantenimientoapi.repository;

import ec.edu.espe.mantenimientoapi.model.CatalogoActividad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatalogoActividadRepository extends JpaRepository<CatalogoActividad,Integer> {

    List<CatalogoActividad> findAllByNombrecatactividad(String nombrecatalogoactividad);
}
