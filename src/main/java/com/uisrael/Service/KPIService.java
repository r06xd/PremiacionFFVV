package com.uisrael.Service;

import java.util.List;

import com.uisrael.Entity.Kpi;

public interface KPIService {
    Kpi guardar(Kpi kpi);
    List<Kpi> listarPorEmpresa(Long empresaId);
	List<Kpi> findAll();
	void eliminar(Long id);

}