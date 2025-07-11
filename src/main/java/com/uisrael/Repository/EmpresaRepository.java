package com.uisrael.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.uisrael.Entity.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
	
	@Query("SELECT e FROM Empresa e WHERE e.nombre = :nombre")
	Empresa findByNombre(String nombre);
	
	@Query("SELECT e FROM Empresa e WHERE e.ruc = :ruc")
	Empresa findByRuc(String ruc);
}
