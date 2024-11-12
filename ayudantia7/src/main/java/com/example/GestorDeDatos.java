package com.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.List;

public class GestorDeDatos implements IGestorDeDatos {

    @Override
    public List<Vehiculo> leerVehiculos(String filePath) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(new File(filePath), mapper.getTypeFactory().constructCollectionType(List.class, Vehiculo.class));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void guardarVehiculos(String filePath, List<Vehiculo> vehiculos) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(new File(filePath), vehiculos);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

