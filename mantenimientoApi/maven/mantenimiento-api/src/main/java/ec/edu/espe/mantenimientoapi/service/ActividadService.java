package ec.edu.espe.mantenimientoapi.service;

import ec.edu.espe.mantenimientoapi.model.Actividad;
import ec.edu.espe.mantenimientoapi.repository.ActividadRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActividadService {

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
