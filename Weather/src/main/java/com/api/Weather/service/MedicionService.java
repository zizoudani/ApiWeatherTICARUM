package com.api.Weather.service;

import com.api.Weather.model.Medicion;
import com.api.Weather.repository.MedicionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MedicionService {

    @Autowired
    private MedicionRepository medicionRepository;

    public List<Medicion> findBySensorId(Long sensorId) {
        return medicionRepository.findBySensorId(sensorId);
    }

    public double calcularMedia(Long sensorId, LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        List<Medicion> mediciones = medicionRepository.findBySensorIdAndFechaBetween(sensorId, fechaInicio, fechaFin);
        if (mediciones.isEmpty()) {
            throw new RuntimeException("No hay mediciones en el rango de fechas");
        }
        return mediciones.stream()
                        .mapToDouble(Medicion::getValor)
                        .average()
                        .orElse(0.0);
    }
}