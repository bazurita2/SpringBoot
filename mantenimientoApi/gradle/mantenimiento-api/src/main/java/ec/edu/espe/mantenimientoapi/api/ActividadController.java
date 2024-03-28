package ec.edu.espe.mantenimientoapi.api;

import ec.edu.espe.mantenimientoapi.constants.Constant;
import ec.edu.espe.mantenimientoapi.model.Actividad;
import ec.edu.espe.mantenimientoapi.service.ActividadService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
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

    @GetMapping("actividadesPorResponsable/{responsableactividad}")
    public ResponseEntity<List<Actividad>> getAllActividadesByResponsable(@PathVariable String responsableactividad){
        try {
            return ResponseEntity.ok(this.actividadService.getAllActividadesByResponsable(responsableactividad));
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("actividadesPorFecha/{date}")
    public ResponseEntity<List<Actividad>> getAllActividadesByFecha(@PathVariable String date){
        try {
            return ResponseEntity.ok(this.actividadService.getAllActividadesByFecha(date));
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("actividadesResponsables")
    public ResponseEntity<List<String>> getAllResponsablesActividad(){
        try {
            return ResponseEntity.ok(this.actividadService.getAllResponsablesActividad());
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("actividadUltima")
    public ResponseEntity<Actividad> getLastActividad(){
        try {
            return ResponseEntity.ok(this.actividadService.getLastActividad());
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
