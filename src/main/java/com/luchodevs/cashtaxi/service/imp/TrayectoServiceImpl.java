package com.luchodevs.cashtaxi.service.imp;

import com.luchodevs.cashtaxi.dto.TrayectoDto;
import com.luchodevs.cashtaxi.entity.TrayectosEntity;
import com.luchodevs.cashtaxi.repository.TrayectosRepository;
import com.luchodevs.cashtaxi.service.TrayectoService;
import com.luchodevs.cashtaxi.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrayectoServiceImpl implements TrayectoService {

    @Autowired
    private TrayectosRepository trayectosRepository;

    @Autowired
    private Mapper mapper;

    @Override
    public List<TrayectoDto> listarTrayectos() {

        List<TrayectosEntity> entities = trayectosRepository.findAll();

        return entities.stream()
                .map(mapper::trayectoDtoMapper)
                .toList();
    }

    @Override
    public TrayectoDto obtenerPorId(Long id) {

        TrayectosEntity entity = trayectosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trayecto no encontrado"));

        return mapper.trayectoDtoMapper(entity);
    }

    @Override
    public TrayectoDto guardarTrayecto(TrayectoDto trayectoDto) {

        if (trayectoDto == null) {
            throw new RuntimeException("Trayecto vacío");
        }

        TrayectosEntity entity = mapper.trayectosEntityMapper(trayectoDto);

        TrayectosEntity saved = trayectosRepository.save(entity);

        if (saved.getId() == null) {
            throw new RuntimeException("Error al guardar");
        }

        return mapper.trayectoDtoMapper(saved);
    }

    @Override
    public TrayectoDto actualizarTrayecto(Long id, TrayectoDto trayectoDto) {

        TrayectosEntity entity = trayectosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trayecto no encontrado"));

        TrayectosEntity trayectoEntityResponse = mapper.trayectosUpdateMapper(trayectoDto, entity);
        TrayectosEntity updated = trayectosRepository.save(trayectoEntityResponse);
        return mapper.trayectoDtoMapper(updated);
    }

    @Override
    public void eliminarTrayecto(Long id) {
        trayectosRepository.deleteById(id);
    }
}