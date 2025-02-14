package com.api.Weather.service;

import com.api.Weather.model.Sensor;
import com.api.Weather.repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SensorService {

    @Autowired
    private SensorRepository sensorRepository;

    public List<Sensor> findAll() {
        return sensorRepository.findAll();
    }

    public Optional<Sensor> findById(Long id) {
        return sensorRepository.findById(id);
    }

    public Sensor save(Sensor sensor) {
        if (sensorRepository.existsByTipo(sensor.getTipo())) {
            throw new RuntimeException("Ya existe un sensor con el tipo: " + sensor.getTipo());
        }
        return sensorRepository.save(sensor);
    }

    public void deleteById(Long id) {
        sensorRepository.deleteById(id);
    }
}