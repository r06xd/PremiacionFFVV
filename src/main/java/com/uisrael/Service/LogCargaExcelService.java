package com.uisrael.Service;

import java.util.List;

import com.uisrael.Entity.LogCargaExcel;

public interface LogCargaExcelService {
    LogCargaExcel Guardar(LogCargaExcel log);
    List<LogCargaExcel> ListarPorUsuario(Long usuarioId);
	List<LogCargaExcel> Listar();
}