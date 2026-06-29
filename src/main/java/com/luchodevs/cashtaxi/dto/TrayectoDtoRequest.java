package com.luchodevs.cashtaxi.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class TrayectoDtoRequest {
    public BigDecimal valorTrayecto;
    public BigDecimal valorCobrado;
    public BigDecimal valorNeto;
    public String plataforma;
    public String metodoPago;

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
