package com.api.Weather.repository;

import com.api.Weather.model.Medicion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface MedicionRepository extends JpaRepository<Medicion, Long> {
    List<Medicion> findBySensorId(Long sensorId);

    @Query("SELECT m FROM Medicion m WHERE m.sensor.id = :sensorId AND m.fecha BETWEEN :fechaInicio AND :fechaFin")
    List<Medicion> findBySensorIdAndFechaBetween(
            @Param("sensorId") Long sensorId,
            @Param("fechaInicio") LocalDateTime fechaInicio,
            @Param("fechaFin") LocalDateTime fechaFin
    );
}