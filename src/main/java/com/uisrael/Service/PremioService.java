package com.uisrael.Service;

import java.util.List;

import com.uisrael.Entity.Premio;

public interface PremioService {
    Premio guardar(Premio premio);
    List<Premio> listarPorEmpresa(Long empresaId);
	List<Premio> findAll();
}