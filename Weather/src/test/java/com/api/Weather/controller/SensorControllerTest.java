package com.api.Weather.controller;

import com.api.Weather.model.Sensor;
import com.api.Weather.service.SensorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SensorControllerTest {

    @Mock
    private SensorService sensorService;

    @InjectMocks
    private SensorController sensorController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAll() {
       
        when(sensorService.findAll()).thenReturn(Arrays.asList(
                new Sensor("Temperatura", "°C"),
                new Sensor("Humedad", "%")
        ));

        List<Sensor> sensores = sensorController.findAll();

        assertEquals(2, sensores.size());
        verify(sensorService, times(1)).findAll();
    }

    @Test
    void testFindById() {

        when(sensorService.findById(1L)).thenReturn(Optional.of(new Sensor("Temperatura", "°C")));

        ResponseEntity<Sensor> response = sensorController.findById(1L);

        assertTrue(response.getStatusCode().is2xxSuccessful());
        assertEquals("Temperatura", response.getBody().getTipo());
        verify(sensorService, times(1)).findById(1L);
    }

    @Test
    void testFindById_NotFound() {
 
        when(sensorService.findById(1L)).thenReturn(Optional.empty());

        ResponseEntity<Sensor> response = sensorController.findById(1L);

        assertTrue(response.getStatusCode().is4xxClientError());
        verify(sensorService, times(1)).findById(1L);
    }

    @Test
    void testSave() {
   
        Sensor sensor = new Sensor("Temperatura", "°C");
        when(sensorService.save(sensor)).thenReturn(sensor);

        Sensor savedSensor = sensorController.save(sensor);

        assertNotNull(savedSensor);
        assertEquals("Temperatura", savedSensor.getTipo());
        verify(sensorService, times(1)).save(sensor);
    }

    @Test
    void testDeleteById() {
 
        sensorController.deleteById(1L);

        verify(sensorService, times(1)).deleteById(1L);
    }
}