package com.luchodevs.cashtaxi.service.imp;

import com.luchodevs.cashtaxi.dto.TrayectoDtoRequest;
import com.luchodevs.cashtaxi.dto.TrayectoDtoResponse;
import com.luchodevs.cashtaxi.entity.TrayectosEntity;
import com.luchodevs.cashtaxi.repository.TrayectosRepository;
import com.luchodevs.cashtaxi.service.TrayectoService;
import com.luchodevs.cashtaxi.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

@Service
public class TrayectoServiceImpl implements TrayectoService {

    @Autowired
    private TrayectosRepository trayectosRepository;

    @Autowired
    private Mapper mapper;

    @Override
    public List<TrayectoDtoResponse> listarTrayectos() {

        List<TrayectosEntity> entities = trayectosRepository.findAll();

        return entities.stream()
                .map(mapper::trayectoDtoMapper)
                .toList();
    }

    @Override
    public TrayectoDtoResponse obtenerPorId(Long id) {

        TrayectosEntity entity = trayectosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trayecto no encontrado"));

        return mapper.trayectoDtoMapper(entity);
    }

    @Override
    public TrayectoDtoResponse guardarTrayecto(TrayectoDtoRequest trayectoDtoRequest) {

        if (trayectoDtoRequest == null) {
            throw new RuntimeException("Trayecto vacío");
        }

        TrayectosEntity entity = mapper.trayectosEntityMapper(trayectoDtoRequest);

        TrayectosEntity saved = trayectosRepository.save(entity);

        if (saved.getId() == null) {
            throw new RuntimeException("Error al guardar");
        }

        return mapper.trayectoDtoMapper(saved);
    }

    @Override
    public TrayectoDtoResponse actualizarTrayecto(Long id, TrayectoDtoRequest trayectoDtoRequest) {

        TrayectosEntity entity = trayectosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trayecto no encontrado"));

        TrayectosEntity trayectoEntityResponse = mapper.trayectosUpdateMapper(trayectoDtoRequest, entity);
        TrayectosEntity updated = trayectosRepository.save(trayectoEntityResponse);
        return mapper.trayectoDtoMapper(updated);
    }

    @Override
    public void eliminarTrayecto(Long id) {
        trayectosRepository.deleteById(id);
    }

    public BigDecimal obtenerTotalDiario() {

        LocalDate hoy = LocalDate.now();

        return trayectosRepository.obtenerTotalEntreFechas(hoy, hoy);
    }

    public BigDecimal obtenerTotalSemanal() {

        LocalDate hoy = LocalDate.now();

        LocalDate inicioSemana =
                hoy.with(DayOfWeek.MONDAY);

        LocalDate finSemana =
                hoy.with(DayOfWeek.SUNDAY);

        return trayectosRepository.obtenerTotalEntreFechas(
                inicioSemana,
                finSemana
        );
    }

    public BigDecimal obtenerTotalMensual() {

        LocalDate hoy = LocalDate.now();

        LocalDate inicioMes =
                hoy.withDayOfMonth(1);

        LocalDate finMes =
                hoy.withDayOfMonth(
                        hoy.lengthOfMonth()
                );

        return trayectosRepository.obtenerTotalEntreFechas(
                inicioMes,
                finMes
        );
    }

    public BigDecimal obtenerTotalPersonalizado(
            LocalDate inicio,
            LocalDate fin
    ) {

        return trayectosRepository.obtenerTotalEntreFechas(
                inicio,
                fin
        );
    }

    @Override
    public BigDecimal obtenerTotalPorApp(String plataforma, LocalDate inicio, LocalDate fin) {
        return trayectosRepository.obtenerTotalPorApp(plataforma,inicio,fin);
    }
}