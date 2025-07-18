package com.uisrael.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.Entity.RankingMensual;

public interface RankingMensualRepository extends JpaRepository<RankingMensual, Long> {
    List<RankingMensual> findByPeriodo(String periodo);
    List<RankingMensual> findByPeriodoMesAndPeriodoAnio(int mes, int anio);
   // void deleteByMesAndAnio(int mes, int anio);
    
}
