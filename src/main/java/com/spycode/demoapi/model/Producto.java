package com.spycode.demoapi.model;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Producto {
    
    private String id;
    private String codProd;
    private String nomProd;
    private String descrProd;
    private double precio;
    private int cantidadStock; 

    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getCodProd() {
        return codProd;
    }
    public void setCodProd(String codProd) {
        this.codProd = codProd;
    }
    public String getNomProd() {
        return nomProd;
    }
    public void setNomProd(String nomProd) {
        this.nomProd = nomProd;
    }
    public String getDescrProd() {
        return descrProd;
    }
    public void setDescrProd(String descrProd) {
        this.descrProd = descrProd;
    }
    public int getCantidadStock() {
        return cantidadStock;
    }
    public void setCantidadStock(int cantidadStock) {
        this.cantidadStock = cantidadStock;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    
    

}
