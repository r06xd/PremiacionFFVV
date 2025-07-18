package com.uisrael.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uisrael.Entity.Kpi;
import com.uisrael.Repository.KPIRepository;
import com.uisrael.Service.KPIService;

@Service
public class KPIServiceImpl implements  KPIService{

	@Autowired
	private KPIRepository kpiRepository;

	@Override
	public Kpi guardar(Kpi kpi) {
	    return kpiRepository.save(kpi);
	}

	@Override
	public List<Kpi> listarPorEmpresa(Long empresaId) {
	    return kpiRepository.findByEmpresaId(empresaId);
	}

	@Override
	public List<Kpi> findAll() {
	    return kpiRepository.findAll();
	}
	
	
	@Override
	public void eliminar(Long id) {
	    kpiRepository.deleteById(id);
	}


}
