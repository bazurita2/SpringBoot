package ec.edu.espe.mantenimientoapi.repository;

import ec.edu.espe.mantenimientoapi.model.DetalleActividad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetalleActividadRepository extends JpaRepository<DetalleActividad,Integer> {

    List<DetalleActividad> findAllByIdactivo(Integer idactivo);
}
