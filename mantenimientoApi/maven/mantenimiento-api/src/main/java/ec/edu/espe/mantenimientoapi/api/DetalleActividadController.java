package ec.edu.espe.mantenimientoapi.api;

import ec.edu.espe.mantenimientoapi.constants.Constant;
import ec.edu.espe.mantenimientoapi.model.DetalleActividad;
import ec.edu.espe.mantenimientoapi.service.DetalleActividadService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(Constant.context)
public class DetalleActividadController {

    private final DetalleActividadService detalleActividadService;

    public DetalleActividadController(DetalleActividadService detalleActividadService) {
        this.detalleActividadService = detalleActividadService;
    }

    @GetMapping("detalleActividad/leerPorActivo/{id}")
    public ResponseEntity<List<DetalleActividad>> getDetalleActividadByActivo(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(this.detalleActividadService.getDetalleActividadByActivo(id));
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("detalleActividades")
    public ResponseEntity<List<DetalleActividad>> getAllDetalleActividades(){
        try {
            return ResponseEntity.ok(this.detalleActividadService.getAllDetalleActividades());
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("detalleActividad/crear")
    public ResponseEntity<?> addDetalleActividad(@RequestBody DetalleActividad detalleActividad){
        try {
            this.detalleActividadService.addDetalleActividad(detalleActividad);
            return ResponseEntity.ok().build();
        } catch (Exception e){
            e.getStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("detalleActividad/borrar/{id}")
    public ResponseEntity<?> deleteDetalleActividad(@PathVariable Integer id){
        try {
            this.detalleActividadService.deleteDetalleActividad(id);
            return ResponseEntity.ok().build();
        } catch (Exception e){
            e.getStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}
