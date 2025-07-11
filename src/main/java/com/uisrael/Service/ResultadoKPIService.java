package com.uisrael.Service;

import java.util.List;

import com.uisrael.Entity.ResultadoKpi;

public interface ResultadoKPIService {
    ResultadoKpi guardar(ResultadoKpi resultado);
    List<ResultadoKpi> listarPorUsuarioYPeriodo(Long usuarioId, String periodo);
}