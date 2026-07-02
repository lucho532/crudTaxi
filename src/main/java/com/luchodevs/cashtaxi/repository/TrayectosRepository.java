package com.luchodevs.cashtaxi.repository;

import com.luchodevs.cashtaxi.entity.TrayectosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;

@Repository
public interface TrayectosRepository extends JpaRepository <TrayectosEntity,Long> {

    @Query(value = "SELECT COALESCE(SUM(valor_cobrado),0) FROM taxi", nativeQuery = true)
    BigDecimal obtenerSumaValorCobrado();

    @Query("""
    SELECT COALESCE(SUM(t.valorCobrado), 0)
    FROM TrayectosEntity t
    WHERE t.fechaDia BETWEEN :inicio AND :fin
""")
    BigDecimal obtenerTotalPorFechas(
            @Param("inicio") LocalDate inicio,
            @Param("fin") LocalDate fin
    );

    @Query("""
    SELECT COALESCE(SUM(t.valorCobrado), 0)
    FROM TrayectosEntity t
    WHERE t.fechaDia BETWEEN :inicio AND :fin
""")
    BigDecimal obtenerTotalEntreFechas(
            @Param("inicio") LocalDate inicio,
            @Param("fin") LocalDate fin
    );

    @Query("""
    SELECT COALESCE(SUM(t.valorCobrado), 0)
    FROM TrayectosEntity t
    WHERE t.fechaDia BETWEEN :inicio AND :fin
      AND UPPER(t.plataforma) = UPPER(:plataforma)
""")
    BigDecimal obtenerTotalPorApp(
            @Param("plataforma") String plataforma,
            @Param("inicio") LocalDate inicio,
            @Param("fin") LocalDate fin
    );
}
