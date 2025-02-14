package com.api.Weather.controller;

import com.api.Weather.model.Medicion;
import com.api.Weather.model.Sensor;
import com.api.Weather.service.MedicionService;
import com.api.Weather.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/sensores")
public class SensorController {

    @Autowired
    private SensorService sensorService;

    @Autowired
    private MedicionService medicionService;

    @GetMapping
    public List<Sensor> findAll() {
        return sensorService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sensor> findById(@PathVariable Long id) {
        return sensorService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Sensor save(@RequestBody Sensor sensor) {
        return sensorService.save(sensor);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        sensorService.deleteById(id);
    }

    @GetMapping("/{idSensor}/media/{fechaInicio}/{fechaFin}")
    public ResponseEntity<Double> calcularMedia(
            @PathVariable Long idSensor,
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaInicio,
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaFin) {
        try {
            double media = medicionService.calcularMedia(idSensor, fechaInicio, fechaFin);
            return ResponseEntity.ok(media);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{idSensor}/historico")
    public ResponseEntity<List<Medicion>> obtenerHistorico(@PathVariable Long idSensor) {
        List<Medicion> historico = medicionService.findBySensorId(idSensor);
        return ResponseEntity.ok(historico);
    }
}