package ec.edu.espe.mantenimientoapi.service;

import ec.edu.espe.mantenimientoapi.model.Actividad;
import ec.edu.espe.mantenimientoapi.repository.ActividadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ActividadService {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private final ActividadRepository actividadRepository;

    public ActividadService(ActividadRepository actividadRepository) {this.actividadRepository = actividadRepository;}

    public List<Actividad> getAllActividades() {
        try{
            List<Actividad> actividadList = this.actividadRepository.findAll();
            return actividadList;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public List<Actividad> getAllActividadesByResponsable(String responsableactividad) {
        try{
            List<Actividad> responsablesActividadList;
            String query = "SELECT * FROM Actividad a WHERE a.responsableactividad = '"+responsableactividad+"'";
            responsablesActividadList = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Actividad.class));
            return responsablesActividadList;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public List<Actividad> getAllActividadesByFecha(String date) {
        try{
            List<Actividad> responsablesActividadList;
            String query = "SELECT * FROM Actividad a WHERE a.fechaactividad BETWEEN to_date('"+date+"','DD-MM-YYYY') AND to_date(SYSDATE,'DD-MM-YYYY')";
            responsablesActividadList = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Actividad.class));
            return responsablesActividadList;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public Actividad getLastActividad() {
        try{
            Actividad actividad = this.actividadRepository.findTopByOrderByIdactividadDesc();
            return actividad;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public List<String> getAllResponsablesActividad() {
        try{
            List<String> responsablesActividadList;
            String query = "SELECT DISTINCT RESPONSABLEACTIVIDAD FROM ACTIVIDAD";
            responsablesActividadList = jdbcTemplate.queryForList(query,String.class);
            return responsablesActividadList;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public void addActividad(Actividad actividad) {
        try{
            actividad.setIdactividad(null);
            this.actividadRepository.save(actividad);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void updateActividad(Actividad actividad,Integer id) {
        Optional<Actividad> actividadData = this.actividadRepository.findById(id);
        if(actividadData.isPresent()){
            try {
                actividadData.get().setFechaactividad(actividad.getFechaactividad());
                this.actividadRepository.save(actividadData.get());
            }catch (Exception e){
                e.printStackTrace();
            }
        }else{
            System.out.println("Actividad NO encontrado");
        }
    }

    public void deleteActividad(Integer id) {
        Optional<Actividad> actividadData = this.actividadRepository.findById(id);
        if(actividadData.isPresent()){
            this.actividadRepository.deleteById(id);
        }else{
            System.out.println("Actividad NO encontrado");
        }
    }
}
