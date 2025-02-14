package com.api.Weather.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sensores")
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String tipo;

    @Column(nullable = false)
    private String magnitud;

    @Transient  // No se persiste en la base de datos
    private Double valorActual;

    @OneToMany(mappedBy = "sensor", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Medicion> historico = new ArrayList<>();

    // Constructores, getters y setters
    public Sensor() {}

    public Sensor(String tipo, String magnitud) {
        this.tipo = tipo;
        this.magnitud = magnitud;
    }

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public String getMagnitud() { return magnitud; }
    public void setMagnitud(String magnitud) { this.magnitud = magnitud; }
    public Double getValorActual() { return valorActual; }
    public void setValorActual(Double valorActual) { this.valorActual = valorActual; }
    public List<Medicion> getHistorico() { return historico; }
    public void setHistorico(List<Medicion> historico) { this.historico = historico; }
}