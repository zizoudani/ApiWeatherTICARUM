package com.api.Weather.repository;

import com.api.Weather.model.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorRepository extends JpaRepository<Sensor, Long> {
    boolean existsByTipo(String tipo);
}