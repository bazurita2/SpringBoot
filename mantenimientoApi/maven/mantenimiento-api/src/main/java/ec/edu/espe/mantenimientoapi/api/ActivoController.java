package ec.edu.espe.mantenimientoapi.api;

import ec.edu.espe.mantenimientoapi.constants.Constant;
import ec.edu.espe.mantenimientoapi.model.Activo;
import ec.edu.espe.mantenimientoapi.service.ActivoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(Constant.context)
public class ActivoController {
    private final ActivoService activoService;

    public ActivoController(ActivoService activoService) {
        this.activoService = activoService;
    }

    @GetMapping("activos")
    public ResponseEntity<List<Activo>> getAllActivos(){
        try {
            return ResponseEntity.ok(this.activoService.getAllActivos());
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("activosPorNombre/{nombreactivo}")
    public ResponseEntity<List<Activo>> getAllActivosByNombre(@PathVariable String nombreactivo){
        try {
            return ResponseEntity.ok(this.activoService.getAllActivosByNombre(nombreactivo));
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("activosPorNombre")
    public ResponseEntity<List<Activo>> getAllActivosByNombre(){
        try {
            return ResponseEntity.ok(this.activoService.getActivosNombresList());
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("activo/leer/{id}")
    public ResponseEntity<Optional<Activo>> getActivoById(@PathVariable Integer id){
        try {
            return ResponseEntity.ok(this.activoService.getActivoById(id));
        } catch (Exception e){
            e.getStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("activo/crear")
    public ResponseEntity<?> addActivo(@RequestBody Activo activo){
        try {
            this.activoService.addActivo(activo);
            return ResponseEntity.ok().build();
        } catch (Exception e){
            e.getStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("activo/actualizar/{id}")
    public ResponseEntity<?> updateActivo(@RequestBody Activo activo, @PathVariable Integer id){
        try {
            this.activoService.updateActivo(activo,id);
            return ResponseEntity.ok().build();
        } catch (Exception e){
            e.getStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("activo/borrar/{id}")
    public ResponseEntity<?> deleteActivo(@PathVariable Integer id){
        try {
            this.activoService.deleteActivo(id);
            return ResponseEntity.ok().build();
        } catch (Exception e){
            e.getStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}
