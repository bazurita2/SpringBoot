package ec.edu.espe.crud.usuariosWsSpringBoot.api;


import ec.edu.espe.crud.usuariosWsSpringBoot.exception.constants.Constant;
import ec.edu.espe.crud.usuariosWsSpringBoot.exception.DataNotFoundException;
import ec.edu.espe.crud.usuariosWsSpringBoot.exception.UpdateException;
import ec.edu.espe.crud.usuariosWsSpringBoot.service.UsuarioService;
import ec.edu.espe.crud.usuariosWsSpringBoot.vo.UsuarioVo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(Constant.context)
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("usuarios")
    public ResponseEntity<List<UsuarioVo>> getAllUsuarios(){
        try {
            return ResponseEntity.ok(this.usuarioService.getAllUsuarios());
        } catch (DataNotFoundException dataNotFoundException){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("usuario/leer/{id}")
    public ResponseEntity<UsuarioVo> getUsuarioById(@PathVariable Integer id){
        try {
            return ResponseEntity.ok(this.usuarioService.getUsuarioById(id));
        } catch (DataNotFoundException dataNotFoundException){
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("usuario/crear")
    public ResponseEntity<?> addUsuario(@RequestBody UsuarioVo usr){
        this.usuarioService.addUsuario(usr);
        return ResponseEntity.ok().build();
    }

    @PutMapping("usuario/actualizar/{id}")
    public ResponseEntity<?> updateUsuario(@RequestBody UsuarioVo usr, @PathVariable Integer id){
        try {
            this.usuarioService.updateUsuario(usr,id);
            return ResponseEntity.ok().build();
        } catch (UpdateException updateException){
            return ResponseEntity.badRequest().build();
        } catch (DataNotFoundException dataNotFoundException){
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("usuario/borrar/{id}")
    public ResponseEntity<?> deleteUsuario(@PathVariable Integer id){
        try {
            this.usuarioService.deleteUsuario(id);
            return ResponseEntity.ok().build();
        } catch (DataNotFoundException dataNotFoundException){
            return ResponseEntity.badRequest().build();
        }
    }
}
