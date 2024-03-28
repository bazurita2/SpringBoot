package ec.edu.espe.mantenimientoapi.service;

import ec.edu.espe.mantenimientoapi.model.Activo;
import ec.edu.espe.mantenimientoapi.repository.ActivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActivoService {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private final ActivoRepository activoRepository;

    public ActivoService(ActivoRepository activoRepository) {this.activoRepository = activoRepository;}

    public List<Activo> getActivosNombresList(){
        try{
            List<Activo> nombresActivosList;
            String query = "SELECT DISTINCT * FROM ACTIVO";
            nombresActivosList = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Activo.class));
            return nombresActivosList;
        }catch (Exception e){
            e.getStackTrace();
            return null;
        }
    }
    public List<Activo> getAllActivos() {
        try{
            List<Activo> activoList = this.activoRepository.findAll();
            return activoList;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public Optional<Activo> getActivoById(Integer id) {
        try{
            Optional<Activo> activo = this.activoRepository.findById(id);
            return activo;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public List<Activo> getAllActivosByNombre(String nombreactivo) {
        try{
            List<Activo> activoList = this.activoRepository.findAllByNombreactivo(nombreactivo);
            return activoList;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public void addActivo(Activo activo) {
        try{
            activo.setIdactivo(null);
            this.activoRepository.save(activo);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void updateActivo(Activo activo,Integer id) {
        Optional<Activo> activoData = this.activoRepository.findById(id);
        if(activoData.isPresent()){
            try {
                activoData.get().setPrecioactivo(activo.getPrecioactivo());
                activoData.get().setNombreactivo(activo.getNombreactivo());
                activoData.get().setEstadoactivo(activo.getEstadoactivo());
                activoData.get().setTipoactivo(activo.getTipoactivo());
                this.activoRepository.save(activoData.get());
            }catch (Exception e){
                e.printStackTrace();
            }
        }else{
            System.out.println("Activo NO encontrado");
        }
    }

    public void deleteActivo(Integer id) {
        Optional<Activo> activoData = this.activoRepository.findById(id);
        if(activoData.isPresent()){
            this.activoRepository.deleteById(id);
        }else{
            System.out.println("Activo NO encontrado");
        }
    }
}
