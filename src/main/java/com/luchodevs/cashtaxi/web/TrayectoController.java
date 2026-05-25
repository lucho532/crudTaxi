package com.luchodevs.cashtaxi.web;


import com.luchodevs.cashtaxi.dto.TrayectoDto;
import com.luchodevs.cashtaxi.service.TrayectoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trayectos")
public class TrayectoController {

    private final TrayectoService trayectoService;

    public TrayectoController(TrayectoService trayectoService) {
        this.trayectoService = trayectoService;
    }

    @GetMapping
    public List<TrayectoDto> listar() {
        return trayectoService.listarTrayectos();
    }

    @GetMapping("/{id}")
    public TrayectoDto obtener(@PathVariable Long id) {
        return trayectoService.obtenerPorId(id);
    }

    @PostMapping
    public TrayectoDto guardar(@RequestBody TrayectoDto trayectoDto) {
        return trayectoService.guardarTrayecto(trayectoDto);
    }

    @PutMapping("/{id}")
    public TrayectoDto actualizar(
            @PathVariable Long id,
            @RequestBody TrayectoDto trayectoDto) {

        return trayectoService.actualizarTrayecto(id, trayectoDto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        trayectoService.eliminarTrayecto(id);
    }
}
