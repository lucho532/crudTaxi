package com.luchodevs.cashtaxi.service;


import com.luchodevs.cashtaxi.dto.TrayectoDtoRequest;
import com.luchodevs.cashtaxi.dto.TrayectoDtoResponse;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;



public interface TrayectoService {

    List<TrayectoDtoResponse> listarTrayectos();

    TrayectoDtoResponse obtenerPorId(Long id);

    TrayectoDtoResponse guardarTrayecto(TrayectoDtoRequest trayectoDtoRequest);

    TrayectoDtoResponse actualizarTrayecto(Long id, TrayectoDtoRequest trayectoDtoRequest);

    void eliminarTrayecto(Long id);


    BigDecimal obtenerTotalDiario();

    BigDecimal obtenerTotalSemanal();

    BigDecimal obtenerTotalMensual();

    BigDecimal obtenerTotalPersonalizado(LocalDate inicio, LocalDate fin);

    BigDecimal obtenerTotalPorApp(String plataforma, LocalDate inicio, LocalDate fin);
}