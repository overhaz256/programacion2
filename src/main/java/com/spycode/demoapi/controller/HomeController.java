package com.spycode.demoapi.controller;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/spydecode", produces = "application/json")
public class HomeController {
    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> saludo(String nombre){
        return new ResponseEntity<String>(
            "Saludo " + nombre, HttpStatus.OK);
    }
}
