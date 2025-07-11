package com.uisrael.Service;

import java.util.List;

import com.uisrael.Entity.Kpi;

public interface KPIService {
	
	//CRUD
    Kpi Guardar(Kpi kpi);
    Boolean Eliminar(Long id);
    
    //Personalizado
    List<Kpi> ListarPorEmpresa(Long empresaId);
}