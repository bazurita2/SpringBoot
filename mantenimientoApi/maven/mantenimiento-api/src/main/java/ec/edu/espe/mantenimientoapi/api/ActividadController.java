package ec.edu.espe.mantenimientoapi.api;

import ec.edu.espe.mantenimientoapi.constants.Constant;
import ec.edu.espe.mantenimientoapi.model.Actividad;
import ec.edu.espe.mantenimientoapi.service.ActividadService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(Constant.context)
public class ActividadController {

    private final ActividadService actividadService;

    public ActividadController(ActividadService actividadService) {
        this.actividadService = actividadService;
    }

    @GetMapping("actividades")
    public ResponseEntity<List<Actividad>> getAllActividades(){
        try {
            return ResponseEntity.ok(this.actividadService.getAllActividades());
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("actividad/crear")
    public ResponseEntity<?> addActividad(@RequestBody Actividad actividad){
        try {
            this.actividadService.addActividad(actividad);
            return ResponseEntity.ok().build();
        } catch (Exception e){
            e.getStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("actividad/actualizar/{id}")
    public ResponseEntity<?> updateActivo(@RequestBody Actividad actividad, @PathVariable Integer id){
        try {
            this.actividadService.updateActividad(actividad,id);
            return ResponseEntity.ok().build();
        } catch (Exception e){
            e.getStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("actividad/borrar/{id}")
    public ResponseEntity<?> deleteActivo(@PathVariable Integer id){
        try {
            this.actividadService.deleteActividad(id);
            return ResponseEntity.ok().build();
        } catch (Exception e){
            e.getStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}
