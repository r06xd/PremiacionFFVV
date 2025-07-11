package com.uisrael.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.Entity.Premio;

public interface PremioRepository extends JpaRepository<Premio, Long> {
    List<Premio> findByEmpresaId(Long empresaId);
}
