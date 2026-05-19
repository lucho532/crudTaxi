package com.luchodevs.cashtaxi.service;


import com.luchodevs.cashtaxi.dto.TrayectoDto;

import java.util.List;

public interface TrayectoService {

    List<TrayectoDto> listarTrayectos();

    TrayectoDto obtenerPorId(int id);

    TrayectoDto guardarTrayecto(TrayectoDto trayectoDto);

    TrayectoDto actualizarTrayecto(int id, TrayectoDto trayectoDto);

    void eliminarTrayecto(int id);
}