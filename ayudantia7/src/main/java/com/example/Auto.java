package com.example;

public class Auto extends Vehiculo {
    private int numPuertas;
    
    public Auto(String marca, String modelo, int año, double precio, int numPuertas) {
        super(marca, modelo, año, precio);
        this.numPuertas = numPuertas;
    }

    public int getNumPuertas() { return numPuertas; }
    public void setNumPuertas(int numPuertas) { this.numPuertas = numPuertas; }

    @Override
    public String getDetalles() {
        return super.getDetalles() + ", Número de puertas: " + numPuertas;
    }
}

