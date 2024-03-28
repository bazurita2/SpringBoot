package ec.edu.espe.mantenimientoapi.repository;

import ec.edu.espe.mantenimientoapi.model.Activo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivoRepository extends JpaRepository <Activo,Integer> {

    List<Activo> findAllByNombreactivo(String nombreactivo);
}
