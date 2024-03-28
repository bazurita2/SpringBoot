package ec.edu.espe.mantenimientoapi.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "DETALLEACTIVIDAD", schema = "MANTENIMIENTODB")
public class DetalleActividad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDDETALLEACTIVIDAD")
    private Integer iddetalleactividad;
    @Column(name = "IDACTIVIDAD")
    private Integer idactividad;
    @Column(name = "IDCATALOGOACTIVIDAD")
    private Integer idcatactividad;
    @Column(name = "IDACTIVO")
    private Integer idactivo;
    @Column(name = "VALORDETALLEACTIVIDAD")
    private Double valordetalleactividad;
}
