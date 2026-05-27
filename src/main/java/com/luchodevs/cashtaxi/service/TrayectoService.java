package com.luchodevs.cashtaxi.service;


import com.luchodevs.cashtaxi.dto.TrayectoDto;
import org.springframework.stereotype.Service;

import java.util.List;



public interface TrayectoService {

    List<TrayectoDto> listarTrayectos();

    TrayectoDto obtenerPorId(Long id);

    TrayectoDto guardarTrayecto(TrayectoDto trayectoDto);

    TrayectoDto actualizarTrayecto(Long id, TrayectoDto trayectoDto);

    void eliminarTrayecto(Long id);


}