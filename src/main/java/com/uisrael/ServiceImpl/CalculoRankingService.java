package com.uisrael.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uisrael.Entity.RankingMensual;
import com.uisrael.Entity.Usuario;
import com.uisrael.Repository.RankingMensualRepository;
import com.uisrael.Repository.ResultadoKPIRepository;

//Servicio para calcular puntos y ranking mensual
@Service
public class CalculoRankingService {

 @Autowired
 private ResultadoKPIRepository resultadoKpiRepository;

 @Autowired
 private RankingMensualRepository rankingMensualRepository;

 public void calcularRankingMensual(int mes, int anio) {
     // Paso 1: Agrupar resultados por usuario
     List<Object[]> resultadosAgrupados = resultadoKpiRepository.sumarPuntosPorUsuario(mes, anio);

     // Paso 2: Ordenar por puntos y asignar posiciones
     List<RankingMensual> ranking = new ArrayList<>();

     resultadosAgrupados.sort((a, b) -> Double.compare((double) b[1], (double) a[1]));

     int posicion = 1;
     for (Object[] fila : resultadosAgrupados) {
         Usuario usuario = (Usuario) fila[0];
         double puntosTotales = (double) fila[1];

         RankingMensual rankingMensual = new RankingMensual();
         rankingMensual.setUsuario(usuario);
         rankingMensual.setPeriodoMes(mes);
         rankingMensual.setPeriodoAnio(anio);
         rankingMensual.setPeriodo(mes + "/" + anio);
         rankingMensual.setPuntosTotales(puntosTotales);
         rankingMensual.setPosicion(posicion++);

         // Aceleradores básicos (ejemplo):
         rankingMensual.setAcelerador1Aplicado(puntosTotales > 100);
         rankingMensual.setAcelerador2Aplicado(puntosTotales > 200);

         ranking.add(rankingMensual);
     }

     rankingMensualRepository.saveAll(ranking);
 }
}