package com.uisrael.Service;

import java.io.InputStream;
import java.util.List;

import com.uisrael.Entity.LogCargaExcel;

public interface LogCargaExcelService {
    LogCargaExcel registrar(LogCargaExcel log);
    List<LogCargaExcel> listarPorUsuario(Long usuarioId);
	List<LogCargaExcel> findAll();
	void cargarDesdeExcel(InputStream inputStream, Long idUsuario, String nombreArchivo);
}