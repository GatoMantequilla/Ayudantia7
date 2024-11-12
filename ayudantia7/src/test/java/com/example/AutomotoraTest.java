package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AutomotoraTest {

    private Automotora automotora;
    private IGestorDeDatos mockGestorDeDatos;

    @BeforeEach
    public void setUp() {
        mockGestorDeDatos = Mockito.mock(IGestorDeDatos.class);
        automotora = new Automotora(mockGestorDeDatos);
    }

    @Test
    void testAgregarVehiculo() {
        Vehiculo auto = new Auto("Ford", "Focus", 2020, 15000, 4);
        automotora.agregarVehiculo(auto);
        assertEquals(1, automotora.getVehiculos().size(), "El vehículo debería haber sido agregado a la lista");
        assertEquals("Ford", automotora.getVehiculos().get(0).getMarca(), "El vehículo agregado debería ser un Ford");
    }

    @Test
    void testCargarDesdeJSON() {
        List<Vehiculo> vehiculosMock = new ArrayList<>();
        vehiculosMock.add(new Camion("Volvo", "FH16", 2021, 75000, 20));
        when(mockGestorDeDatos.leerVehiculos("vehiculos.json")).thenReturn(vehiculosMock);
        automotora.cargarDesdeJSON("vehiculos.json");
        assertEquals(1, automotora.getVehiculos().size(), "La automotora debería tener 1 vehículo cargado desde JSON");
        assertEquals("Volvo", automotora.getVehiculos().get(0).getMarca(), "El vehículo cargado debería ser un Volvo");
    }

    @Test
    void testGetVehiculos() {
        Vehiculo camion = new Camion("Mercedes", "Actros", 2021, 120000, 10);
        automotora.agregarVehiculo(camion);
        List<Vehiculo> vehiculos = automotora.getVehiculos();
        assertNotNull(vehiculos, "La lista de vehículos no debería ser nula");
        assertEquals(1, vehiculos.size(), "Debería haber un vehículo en la lista");
        assertEquals("Mercedes", vehiculos.get(0).getMarca(), "El vehículo debería ser un Mercedes");
    }

    @Test
    void testGuardarEnJSON() {
        Vehiculo bicicleta = new Bicicleta("Giant", "ATX", 2022, 800, "Montaña");
        automotora.agregarVehiculo(bicicleta);
        automotora.guardarEnJSON("output.json");
        verify(mockGestorDeDatos, times(1)).guardarVehiculos(eq("output.json"), anyList());
    }

    @Test
    void testListarVehiculos() {
        Vehiculo auto = new Auto("Chevrolet", "Spark", 2018, 8000, 4);
        Vehiculo camion = new Camion("Scania", "R450", 2020, 95000, 30);
        automotora.agregarVehiculo(auto);
        automotora.agregarVehiculo(camion);
        List<Vehiculo> vehiculos = automotora.getVehiculos();
        assertEquals(2, vehiculos.size(), "Deberían haber 2 vehículos en la lista de la automotora");
        assertEquals("Chevrolet", vehiculos.get(0).getMarca(), "El primer vehículo debería ser un Chevrolet");
        assertEquals("Scania", vehiculos.get(1).getMarca(), "El segundo vehículo debería ser un Scania");
        System.out.println("testListarVehiculos");
    }
}