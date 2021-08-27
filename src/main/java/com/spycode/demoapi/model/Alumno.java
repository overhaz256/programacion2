package com.spycode.demoapi.model;

import java.util.Date;
import lombok.*;
import javax.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="t_alumno")
public class Alumno {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String nombre;
    @DateTimeFormat(pattern="dd/MM/yyyy")
    private Date fechaNac;
    private String genero;
    private String carrera;
    
}
