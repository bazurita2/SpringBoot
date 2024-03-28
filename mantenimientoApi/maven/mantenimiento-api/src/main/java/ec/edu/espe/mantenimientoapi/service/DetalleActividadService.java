package ec.edu.espe.mantenimientoapi.service;

import ec.edu.espe.mantenimientoapi.model.DetalleActividad;
import ec.edu.espe.mantenimientoapi.repository.DetalleActividadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleActividadService {

    private final DetalleActividadRepository detalleActividadRepository;

    public DetalleActividadService(DetalleActividadRepository detalleActividadRepository) {this.detalleActividadRepository = detalleActividadRepository;}

    public List<DetalleActividad> getDetalleActividadByActivo(Integer id){
        try{
            List<DetalleActividad> detalleActividadList = this.detalleActividadRepository.findAllByIdactivo(id);
            return detalleActividadList;
        }catch (Exception e){
            e.getStackTrace();
            return null;
        }
    }

    public List<DetalleActividad> getAllDetalleActividades() {
        try{
            List<DetalleActividad> detalleActividadList = this.detalleActividadRepository.findAll();
            return detalleActividadList;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public void addDetalleActividad(DetalleActividad detalleActividad) {
        try{
            detalleActividad.setIddetalleactividad(null);
            this.detalleActividadRepository.save(detalleActividad);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void deleteDetalleActividad(Integer id) {
        Optional<DetalleActividad> detalleActividadData = this.detalleActividadRepository.findById(id);
        if(detalleActividadData.isPresent()){
            this.detalleActividadRepository.deleteById(id);
        }else{
            System.out.println("DetalleActividad NO encontrado");
        }
    }
}
