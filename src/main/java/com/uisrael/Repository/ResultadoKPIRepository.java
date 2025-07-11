package com.uisrael.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.Entity.ResultadoKpi;

public interface ResultadoKPIRepository extends JpaRepository<ResultadoKpi, Long> {
    List<ResultadoKpi> findByUsuarioIdAndPeriodo(Long usuarioId, String periodo);
}
