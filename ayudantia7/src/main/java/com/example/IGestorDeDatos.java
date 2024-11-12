package com.example;

import java.util.List;

public interface IGestorDeDatos {
    List<Vehiculo> leerVehiculos(String filePath);
    void guardarVehiculos(String filePath, List<Vehiculo> vehiculos);
}

