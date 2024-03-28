package ec.edu.espe.mantenimientoapi.model;

import lombok.Data;

import javax.persistence.*;

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
