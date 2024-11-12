package com.example;

public class Bicicleta extends Vehiculo {
    private String tipo;
    
    public Bicicleta(String marca, String modelo, int año, double precio, String tipo) {
        super(marca, modelo, año, precio);
        this.tipo = tipo;
    }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    @Override
    public String getDetalles() {
        return super.getDetalles() + ", Tipo de bicicleta: " + tipo;
    }
}

