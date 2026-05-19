package com.luchodevs.cashtaxi.service.imp;

import com.luchodevs.cashtaxi.dto.TrayectoDto;
import com.luchodevs.cashtaxi.service.TrayectoService;

import java.util.List;

public class TrayectoServiceImpl implements TrayectoService {



    @Override
    public List<TrayectoDto> listarTrayectos() {
        return List.of();
    }

    @Override
    public TrayectoDto obtenerPorId(int id) {
        return null;
    }

    @Override
    public TrayectoDto guardarTrayecto(TrayectoDto trayectoDto) {
        return null;
    }

    @Override
    public TrayectoDto actualizarTrayecto(int id, TrayectoDto trayectoDto) {
        return null;
    }

    @Override
    public void eliminarTrayecto(int id) {

    }
}
