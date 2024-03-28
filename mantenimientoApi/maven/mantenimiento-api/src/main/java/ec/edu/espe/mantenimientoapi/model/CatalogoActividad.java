package ec.edu.espe.mantenimientoapi.model;

import javax.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "CATALOGOACTIVIDAD", schema = "MANTENIMIENTODB")
public class CatalogoActividad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDCATALOGOACTIVIDAD")
    private Integer idcatactividad;
    @Column(name = "NOMBRECATALOGOACTIVIDAD")
    private String nombrecatactividad;
    @Column(name = "DESCRIPCIONCATALOGOACTIVIDAD")
    private String descripcioncatactividad;
}
