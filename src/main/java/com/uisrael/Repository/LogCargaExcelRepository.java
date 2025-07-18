package com.uisrael.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.Entity.LogCargaExcel;

public interface LogCargaExcelRepository extends JpaRepository<LogCargaExcel, Long> {
    List<LogCargaExcel> findByUsuarioId(Long usuarioId);
}