package com.example;

public class Camion extends Vehiculo {
    private int capacidad;

    public Camion(String marca, String modelo, int año, double precio, int capacidad) {
        super(marca, modelo, año, precio);
        this.capacidad = capacidad;
    }

    public int getCapacidad() { return capacidad; }
    public void setCapacidad(int capacidad) { this.capacidad = capacidad; }

    @Override
    public String getDetalles() {
        return super.getDetalles() + ", Capacidad de carga: " + capacidad + " toneladas";
    }
}

