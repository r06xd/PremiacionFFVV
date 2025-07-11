package com.uisrael.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.Entity.RankingMensual;

public interface RankingRepository extends JpaRepository<RankingMensual, Long> {
    List<RankingMensual> findByPeriodo(String periodo);
}
