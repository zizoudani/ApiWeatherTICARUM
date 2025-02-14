package com.api.Weather.service;

import com.api.Weather.model.Sensor;
import com.api.Weather.repository.SensorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SensorServiceTest {

    @Mock
    private SensorRepository sensorRepository;

    @InjectMocks
    private SensorService sensorService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAll() {

        when(sensorRepository.findAll()).thenReturn(Arrays.asList(
                new Sensor("Temperatura", "°C"),
                new Sensor("Humedad", "%")
        ));

      
        List<Sensor> sensores = sensorService.findAll();

       
        assertEquals(2, sensores.size());
        verify(sensorRepository, times(1)).findAll();
    }

    @Test
    void testFindById() {
      
        when(sensorRepository.findById(1L)).thenReturn(Optional.of(new Sensor("Temperatura", "°C")));

        Optional<Sensor> sensor = sensorService.findById(1L);

          assertTrue(sensor.isPresent());
        assertEquals("Temperatura", sensor.get().getTipo());
        verify(sensorRepository, times(1)).findById(1L);
    }

    @Test
    void testSave() {
     
        Sensor sensor = new Sensor("Temperatura", "°C");
        when(sensorRepository.existsByTipo("Temperatura")).thenReturn(false);
        when(sensorRepository.save(sensor)).thenReturn(sensor);

        Sensor savedSensor = sensorService.save(sensor);

        assertNotNull(savedSensor);
        assertEquals("Temperatura", savedSensor.getTipo());
        verify(sensorRepository, times(1)).existsByTipo("Temperatura");
        verify(sensorRepository, times(1)).save(sensor);
    }

    @Test
    void testSave_DuplicateTipo() {
        
        Sensor sensor = new Sensor("Temperatura", "°C");
        when(sensorRepository.existsByTipo("Temperatura")).thenReturn(true);

        assertThrows(RuntimeException.class, () -> sensorService.save(sensor));
        verify(sensorRepository, times(1)).existsByTipo("Temperatura");
        verify(sensorRepository, never()).save(sensor);
    }

    @Test
    void testDeleteById() {
      
        sensorService.deleteById(1L);

        verify(sensorRepository, times(1)).deleteById(1L);
    }
}