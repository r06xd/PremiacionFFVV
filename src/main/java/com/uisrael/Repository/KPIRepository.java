package com.uisrael.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.Entity.Kpi;

public interface KPIRepository extends JpaRepository<Kpi, Long> {
	
	
    List<Kpi> findByEmpresaId(Long empresaId);
}