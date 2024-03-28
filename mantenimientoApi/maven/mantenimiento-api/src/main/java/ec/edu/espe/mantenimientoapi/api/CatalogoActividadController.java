package ec.edu.espe.mantenimientoapi.api;

import ec.edu.espe.mantenimientoapi.constants.Constant;
import ec.edu.espe.mantenimientoapi.model.CatalogoActividad;
import ec.edu.espe.mantenimientoapi.service.CatalogoActividadService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(Constant.context)
public class CatalogoActividadController {
    private final CatalogoActividadService catalogoActividadService;

    public CatalogoActividadController(CatalogoActividadService catalogoActividadService) {
        this.catalogoActividadService = catalogoActividadService;
    }

    @GetMapping("catalogoActividades")
    public ResponseEntity<List<CatalogoActividad>> getAllCatalogoActividades(){
        try {
            return ResponseEntity.ok(this.catalogoActividadService.getAllCatalogoActividades());
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("catalogoActividadesPorNombre/{nombrecatalogoactividad}")
    public ResponseEntity<List<CatalogoActividad>> getAllCatalogoActividadesByNombre(@PathVariable String nombrecatalogoactividad){
        try {
            return ResponseEntity.ok(this.catalogoActividadService.getAllCatalogoActividadesByNombre(nombrecatalogoactividad));
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("catalogoActividad/leer/{id}")
    public ResponseEntity<Optional<CatalogoActividad>> getCatalogoActividadById(@PathVariable Integer id){
        try {
            return ResponseEntity.ok(this.catalogoActividadService.getCatalogoActividadById(id));
        } catch (Exception e){
            e.getStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("catalogoActividad/crear")
    public ResponseEntity<?> addCatalogoActividad(@RequestBody CatalogoActividad catalogoActividad){
        try {
            this.catalogoActividadService.addCatalogoActividad(catalogoActividad);
            return ResponseEntity.ok().build();
        } catch (Exception e){
            e.getStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("catalogoActividad/actualizar/{id}")
    public ResponseEntity<?> updateCatalogoActividad(@RequestBody CatalogoActividad catalogoActividad, @PathVariable Integer id){
        try {
            this.catalogoActividadService.updateCatalogoActividad(catalogoActividad,id);
            return ResponseEntity.ok().build();
        } catch (Exception e){
            e.getStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("catalogoActividad/borrar/{id}")
    public ResponseEntity<?> deleteCatalogoActividad(@PathVariable Integer id){
        try {
            this.catalogoActividadService.deleteCatalogoActividad(id);
            return ResponseEntity.ok().build();
        } catch (Exception e){
            e.getStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}
