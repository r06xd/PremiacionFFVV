package com.uisrael.Service;

import java.util.List;

import com.uisrael.Entity.RankingMensual;

public interface RankingService {
    RankingMensual guardar(RankingMensual ranking);
    List<RankingMensual> listarPorPeriodo(String periodo);
	List<RankingMensual> findAll();
}