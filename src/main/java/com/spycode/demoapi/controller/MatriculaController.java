package com.spycode.demoapi.controller;

import com.spycode.demoapi.model.*;
import com.spycode.demoapi.repository.AlumnoRepository;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "api/matricula", produces = "application/json")
public class MatriculaController {

    private final AlumnoRepository alumnoData;

    public MatriculaController(AlumnoRepository alumnoData) {
        this.alumnoData = alumnoData;
    }
    
    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> crear(@RequestBody Alumno a){
        alumnoData.save(a);
        alumnoData.flush();
        return new ResponseEntity<Integer>(a.getId(), HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Alumno> buscarPorId(@PathVariable int id){
        Optional<Alumno> optAlumno = alumnoData.buscarPorId(id);
        if(optAlumno.isPresent()){
            Alumno alumno = optAlumno.get();
            return new ResponseEntity<Alumno>(alumno, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<Alumno>(HttpStatus.NOT_FOUND);
        }
    }
}
