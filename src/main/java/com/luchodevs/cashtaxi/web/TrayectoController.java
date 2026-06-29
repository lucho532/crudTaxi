package com.luchodevs.cashtaxi.web;


import com.luchodevs.cashtaxi.dto.TrayectoDtoRequest;
import com.luchodevs.cashtaxi.dto.TrayectoDtoResponse;
import com.luchodevs.cashtaxi.service.TrayectoService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/trayectos")
public class TrayectoController {

    private final TrayectoService trayectoService;

    public TrayectoController(TrayectoService trayectoService) {
        this.trayectoService = trayectoService;
    }

    @GetMapping
    public List<TrayectoDtoResponse> listar() {
        return trayectoService.listarTrayectos();
    }

    @GetMapping("/{id}")
    public TrayectoDtoResponse obtener(@PathVariable Long id) {
        return trayectoService.obtenerPorId(id);
    }

    @PostMapping
    public TrayectoDtoResponse guardar(@RequestBody TrayectoDtoRequest trayectoDtoRequest) {
        return trayectoService.guardarTrayecto(trayectoDtoRequest);
    }

    @PutMapping("/{id}")
    public TrayectoDtoResponse actualizar(
            @PathVariable Long id,
            @RequestBody TrayectoDtoRequest trayectoDtoRequest) {

        return trayectoService.actualizarTrayecto(id, trayectoDtoRequest);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        trayectoService.eliminarTrayecto(id);
    }

    @GetMapping("/total/diario")
    public BigDecimal totalDiario() {
        return trayectoService.obtenerTotalDiario();
    }

    @GetMapping("/total/semanal")
    public BigDecimal totalSemanal() {
        return trayectoService.obtenerTotalSemanal();
    }

    @GetMapping("/total/mensual")
    public BigDecimal totalMensual() {
        return trayectoService.obtenerTotalMensual();
    }

    @GetMapping("/total")
    public BigDecimal totalEntreFechas(
            @RequestParam
            @Parameter(description = "Fecha inicio")
            @DateTimeFormat(pattern = "dd/MM/yyyy")
            @Schema(type = "string", example = "01/05/2026")
            LocalDate inicio,

            @RequestParam
            @Parameter(description = "Fecha fin")
            @DateTimeFormat(pattern = "dd/MM/yyyy")
            @Schema(type = "string", example = "30/05/2026")
            LocalDate fin
    ) {

        return trayectoService
                .obtenerTotalPersonalizado(inicio, fin);
    }

    @GetMapping("/total/{plataforma}")
    public BigDecimal totalPorPlataforma(
            @PathVariable String plataforma,

            @RequestParam
            @Parameter(description = "Fecha inicio", example = "01/05/2026")
            @DateTimeFormat(pattern = "dd/MM/yyyy")
            @Schema(type = "string", example = "01/05/2026")
            LocalDate inicio,

            @RequestParam
            @Parameter(description = "Fecha fin", example = "30/05/2026")
            @DateTimeFormat(pattern = "dd/MM/yyyy")
            @Schema(type = "string", example = "30/05/2026")
            LocalDate fin
    ) {

        return trayectoService
                .obtenerTotalPorApp(plataforma, inicio, fin);
    }
}
