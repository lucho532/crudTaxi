package com.luchodevs.cashtaxi.entity;


import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;
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
    private BigDecimal valorTrayecto;

    @NotNull
    private BigDecimal valorCobrado;

    @NotNull
    private BigDecimal valorNeto;

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

    public BigDecimal getValorTrayecto() {
        return valorTrayecto;
    }

    public void setValorTrayecto(BigDecimal valorTrayecto) {
        this.valorTrayecto = valorTrayecto;
    }

    public BigDecimal getValorCobrado() {
        return valorCobrado;
    }

    public void setValorCobrado(BigDecimal valorCobrado) {
        this.valorCobrado = valorCobrado;
    }

    public BigDecimal getValorNeto() {
        return valorNeto;
    }

    public void setValorNeto(BigDecimal valorNeto) {
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
