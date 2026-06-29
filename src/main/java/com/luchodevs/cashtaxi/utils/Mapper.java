package com.luchodevs.cashtaxi.utils;

import com.luchodevs.cashtaxi.dto.TrayectoDtoRequest;
import com.luchodevs.cashtaxi.dto.TrayectoDtoResponse;
import com.luchodevs.cashtaxi.entity.TrayectosEntity;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
@Component
public class Mapper {

    private LocalDate localDate = LocalDate.now();
    private LocalTime localTime = LocalTime.now().withSecond(0).withNano(0);



    public TrayectosEntity trayectosEntityMapper(TrayectoDtoRequest trayectoDtoRequest) {

        TrayectosEntity trayectoEntity = new TrayectosEntity();

        trayectoEntity.setHoraTrayecto(localTime);
        trayectoEntity.setValorTrayecto(trayectoDtoRequest.getValorTrayecto());
        trayectoEntity.setFechaTrayecto(localDate);
        trayectoEntity.setPlataforma(trayectoDtoRequest.getPlataforma());
        trayectoEntity.setFechaDia(localDate);
        trayectoEntity.setMetodoPago(trayectoDtoRequest.getMetodoPago());
        trayectoEntity.setValorCobrado(trayectoDtoRequest.getValorCobrado());
        if (trayectoDtoRequest.getValorNeto() == null
                || trayectoDtoRequest.getValorNeto().compareTo(BigDecimal.ZERO) == 0) {

            trayectoEntity.setValorNeto(trayectoDtoRequest.getValorTrayecto());

        }else{
            trayectoEntity.setValorNeto(trayectoDtoRequest.getValorNeto());
        }




        return trayectoEntity;
    }

    public TrayectosEntity trayectosUpdateMapper(TrayectoDtoRequest trayectoDtoRequest, TrayectosEntity entity) {
        entity.setValorTrayecto(trayectoDtoRequest.getValorTrayecto());
        entity.setPlataforma(trayectoDtoRequest.getPlataforma());
        entity.setMetodoPago(trayectoDtoRequest.getMetodoPago());
        entity.setValorCobrado(trayectoDtoRequest.getValorCobrado());
        entity.setValorNeto(trayectoDtoRequest.getValorNeto());
        return entity;
    }

    public TrayectoDtoResponse trayectoDtoMapper(TrayectosEntity trayectosEntity) {

        TrayectoDtoResponse dto = new TrayectoDtoResponse();

        dto.setId(trayectosEntity.getId());
        dto.setHoraTrayecto(trayectosEntity.getHoraTrayecto());
        dto.setFechaTrayecto(trayectosEntity.getFechaTrayecto());
        dto.setFechaDia(trayectosEntity.getFechaDia());
        dto.setValorTrayecto(trayectosEntity.getValorTrayecto());
        dto.setValorCobrado(trayectosEntity.getValorCobrado());
        dto.setValorNeto(trayectosEntity.getValorNeto());
        dto.setPlataforma(trayectosEntity.getPlataforma());
        dto.setMetodoPago(trayectosEntity.getMetodoPago());

        return dto;
    }

}