package com.luchodevs.cashtaxi.utils;

import com.luchodevs.cashtaxi.dto.TrayectoDto;
import com.luchodevs.cashtaxi.entity.TrayectosEntity;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
@Component
public class Mapper {

    private LocalDate localDate = LocalDate.now();
    private LocalTime localTime = LocalTime.now().withSecond(0).withNano(0);



    public TrayectosEntity trayectosEntityMapper(TrayectoDto trayectoDto) {

        TrayectosEntity trayectoEntity = new TrayectosEntity();

        trayectoEntity.setHoraTrayecto(localTime);
        trayectoEntity.setValorTrayecto(trayectoDto.getValorTrayecto());
        trayectoEntity.setFechaTrayecto(localDate);
        trayectoEntity.setPlataforma(trayectoDto.getPlataforma());
        trayectoEntity.setFechaDia(localDate);
        trayectoEntity.setMetodoPago(trayectoDto.getMetodoPago());
        trayectoEntity.setValorCobrado(trayectoDto.getValorCobrado());
        trayectoEntity.setValorNeto(trayectoDto.getValorNeto());

        return trayectoEntity;
    }

    public TrayectosEntity trayectosUpdateMapper(TrayectoDto trayectoDto, TrayectosEntity entity) {
        entity.setValorTrayecto(trayectoDto.getValorTrayecto());
        entity.setPlataforma(trayectoDto.getPlataforma());
        entity.setMetodoPago(trayectoDto.getMetodoPago());
        entity.setValorCobrado(trayectoDto.getValorCobrado());
        entity.setValorNeto(trayectoDto.getValorNeto());
        return entity;
    }

    public TrayectoDto trayectoDtoMapper(TrayectosEntity trayectosEntity) {

        TrayectoDto dto = new TrayectoDto();

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