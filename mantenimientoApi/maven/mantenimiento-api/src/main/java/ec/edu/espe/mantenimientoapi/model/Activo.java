package ec.edu.espe.mantenimientoapi.model;

import javax.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "ACTIVO", schema = "MANTENIMIENTODB")
public class Activo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDACTIVO")
    private Integer idactivo;
    @Column(name = "PRECIOACTIVO")
    private Double precioactivo;
    @Column(name = "NOMBREACTIVO")
    private String nombreactivo;
    @Column(name = "TIPOACTIVO")
    private String tipoactivo;
    @Column(name = "ESTADOACTIVO")
    private String estadoactivo;
    @Column(name = "FECHACOMPRAACTIVO")
    private Date fechacompraactivo;
}
