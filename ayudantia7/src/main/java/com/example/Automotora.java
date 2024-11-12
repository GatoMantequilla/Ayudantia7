package com.example;

import java.util.ArrayList;
import java.util.List;

public class Automotora {
    private ArrayList<Vehiculo> vehiculos;
    private IGestorDeDatos gestorDeDatos;

    public Automotora(IGestorDeDatos gestorDeDatos) {
        this.vehiculos = new ArrayList<>();
        this.gestorDeDatos = gestorDeDatos;
    }

    public void agregarVehiculo(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void cargarDesdeJSON(String filePath) {
        List<Vehiculo> vehiculosCargados = gestorDeDatos.leerVehiculos(filePath);
        if (vehiculosCargados != null) {
            vehiculos.addAll(vehiculosCargados);
        }
    }

    public void guardarEnJSON(String filePath) {
        gestorDeDatos.guardarVehiculos(filePath, vehiculos);
    }
}

