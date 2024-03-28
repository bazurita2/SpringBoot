package ec.edu.espe.crud.usuariosWsSpringBoot.repository;

import ec.edu.espe.crud.usuariosWsSpringBoot.model.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity,Integer> {
    UsuarioEntity getUsuarioById(Integer id);

    Optional<UsuarioEntity> findAllById(Integer id);
}
