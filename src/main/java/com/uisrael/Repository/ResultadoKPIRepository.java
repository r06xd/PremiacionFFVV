package com.uisrael.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.uisrael.Entity.ResultadoKpi;

public interface ResultadoKPIRepository extends JpaRepository<ResultadoKpi, Long> {
	 @Query("SELECT rk.usuario, SUM(rk.puntosCalculados) " +
	           "FROM ResultadoKpi rk " +
	           "WHERE rk.periodoMes = :mes AND rk.periodoAnio = :anio " +
	           "GROUP BY rk.usuario")
	    List<Object[]> sumarPuntosPorUsuario(@Param("mes") int mes, @Param("anio") int anio);
	
   // List<ResultadoKpi> findByUsuarioIdAndPeriodo(Long usuarioId, String periodo);
   // List<ResultadoKpi> findByMesAndAnio(int mes, int anio);

}
