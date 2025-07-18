package com.uisrael.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.Entity.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {}
