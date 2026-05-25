package com.luchodevs.cashtaxi.entity;


import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;

// Entidad Player
@Entity
@Table(name = "taxi")
public class TrayectosEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    public LocalDate fechaDia;

    @NotNull
    private LocalDate fechaTrayecto;

    @NotNull
    private LocalTime horaTrayecto;

    @NotNull
    private Double valorTrayecto;

    @NotNull
    private Double valorCobrado;

    @NotNull
    private Double valorNeto;

    @NotNull
    private String plataforma;

    @NotNull
    private String metodoPago;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFechaDia() {
        return fechaDia;
    }

    public void setFechaDia(LocalDate fechaDia) {
        this.fechaDia = fechaDia;
    }

    public LocalDate getFechaTrayecto() {
        return fechaTrayecto;
    }

    public void setFechaTrayecto(LocalDate fechaTrayecto) {
        this.fechaTrayecto = fechaTrayecto;
    }

    public LocalTime getHoraTrayecto() {
        return horaTrayecto;
    }

    public void setHoraTrayecto(LocalTime horaTrayecto) {
        this.horaTrayecto = horaTrayecto;
    }

    public Double getValorTrayecto() {
        return valorTrayecto;
    }

    public void setValorTrayecto(Double valorTrayecto) {
        this.valorTrayecto = valorTrayecto;
    }

    public Double getValorCobrado() {
        return valorCobrado;
    }

    public void setValorCobrado(Double valorCobrado) {
        this.valorCobrado = valorCobrado;
    }

    public Double getValorNeto() {
        return valorNeto;
    }

    public void setValorNeto(Double valorNeto) {
        this.valorNeto = valorNeto;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }
}
