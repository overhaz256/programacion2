package com.spycode.demoapi.controller;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.ipc.http.HttpSender.Response;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import com.spycode.demoapi.model.Producto;

@RestController
@RequestMapping(value = "api/producto", produces = "application/json")
public class ProductoController {

    private Map<String, Producto> productos;

    public ProductoController(){
        productos = new HashMap<String, Producto>();
        Producto p = new Producto();
        p.setCodProd("LP-01");
        p.setNomProd("Laptop");
        p.setDescrProd("Laptop Gamer");
        p.setPrecio(5700.00);
        p.setCantidadStock(2);
        String id = UUID.randomUUID().toString();
        p.setId(id);

        productos.put(id, p);
    }
    
    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Producto>> listar(){
        return new ResponseEntity<Map<String, Producto>>(
            productos, HttpStatus.OK);
    }

    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> agregar(@RequestBody Producto p){
        String id = UUID.randomUUID().toString();
        p.setId(id);
        productos.put(id, p);
        return new ResponseEntity<String>(id, 
            HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Producto> find(@PathVariable String id){
        if(productos.containsKey(id)){
            Producto p = productos.get(id);
            return new ResponseEntity<Producto>(p, HttpStatus.OK);
        } else {
            return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity delete(@PathVariable String id){
        if(productos.containsKey(id)){
        Producto p = productos.remove(id);
        return new ResponseEntity<Producto>(p, HttpStatus.OK);
        } else {
            return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Producto> update(@RequestBody Producto p, @PathVariable String id){
        
        if(productos.containsKey(id)){
            p.setId(p.getId());
            p.setCodProd(p.getCodProd());
            p.setNomProd(p.getNomProd());
            p.setDescrProd(p.getDescrProd());
            p.setPrecio(p.getPrecio());
            p.setCantidadStock(p.getCantidadStock());
            return new ResponseEntity<Producto>(p, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(p, HttpStatus.NOT_FOUND);
        } 
    }

}
