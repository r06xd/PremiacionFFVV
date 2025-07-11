package com.uisrael.Service;

import java.util.List;

import com.uisrael.Entity.PremioAsignado;

public interface PremioAsignadoService {

	PremioAsignado save(PremioAsignado premioAsignado);

	List<PremioAsignado> findAll();

}
