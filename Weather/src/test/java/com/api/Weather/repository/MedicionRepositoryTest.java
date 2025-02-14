package com.api.Weather.repository;

import com.api.Weather.model.Medicion;
import com.api.Weather.model.Sensor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
class MedicionRepositoryTest {

    @Autowired
    private SensorRepository sensorRepository;  

    @Autowired
    private MedicionRepository medicionRepository;  

    @Test
    void testFindBySensorId() {
       
        Sensor sensor = new Sensor("Temperatura", "°C");
        sensorRepository.save(sensor); 

       
        Medicion medicion = new Medicion(LocalDateTime.now(), 25.0, sensor);
        medicionRepository.save(medicion);

       
        List<Medicion> mediciones = medicionRepository.findBySensorId(sensor.getId());

       
        assertFalse(mediciones.isEmpty());
        assertEquals(25.0, mediciones.get(0).getValor());
    }

    @Test
    void testFindBySensorIdAndFechaBetween() {
      
        Sensor sensor = new Sensor("Temperatura", "°C");
        sensorRepository.save(sensor);  

    
        LocalDateTime fechaInicio = LocalDateTime.of(2023, 1, 1, 0, 0);
        LocalDateTime fechaFin = LocalDateTime.of(2023, 12, 31, 23, 59);
        Medicion medicion = new Medicion(fechaInicio.plusDays(1), 25.0, sensor);
        medicionRepository.save(medicion);

        
        List<Medicion> mediciones = medicionRepository.findBySensorIdAndFechaBetween(sensor.getId(), fechaInicio, fechaFin);

     
        assertFalse(mediciones.isEmpty());
        assertEquals(25.0, mediciones.get(0).getValor());
    }
}