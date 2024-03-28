package ec.edu.espe.crud.usuariosWsSpringBoot.vo;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UsuarioVo {
    private String id;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private String address;
}
