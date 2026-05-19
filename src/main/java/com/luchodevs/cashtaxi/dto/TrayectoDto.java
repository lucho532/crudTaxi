package com.luchodevs.cashtaxi.dto;


import java.time.LocalDate;

public class TrayectoDto{

    public int id;
    public LocalDate fechaDia;
    public LocalDate fechaTrayecto;
    public LocalDate horaTrayecto;
    public Double valorTrayecto;
    public Double valorCobrado;
    public Double valorNeto;
    public String plataforma;
    public String metodoPago;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public LocalDate getHoraTrayecto() {
        return horaTrayecto;
    }

    public void setHoraTrayecto(LocalDate horaTrayecto) {
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
