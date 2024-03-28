package ec.edu.espe.mantenimientoapi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@Table(name = "ACTIVIDAD", schema = "MANTENIMIENTODB")
public class Actividad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDACTIVIDAD")
    private Integer idactividad;
    @Column(name = "FECHAACTIVIDAD")
    private Date fechaactividad;
    @Column(name = "RESPONSABLEACTIVIDAD")
    private String responsableactividad;
}
