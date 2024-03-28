package ec.edu.espe.mantenimientoapi.repository;

import ec.edu.espe.mantenimientoapi.model.Actividad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActividadRepository extends JpaRepository<Actividad,Integer> {
}
