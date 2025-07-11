package com.uisrael.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uisrael.Entity.Empresa;
import com.uisrael.Repository.EmpresaRepository;
import com.uisrael.Service.EmpresaService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor 
public class EmpresaServiceImpl implements EmpresaService {

	@Autowired
    private EmpresaRepository empresaRepository;

	@Override
	public Empresa Crear(Empresa empresa) {
		// TODO Auto-generated method stub
		return empresaRepository.save(empresa);
	}

	@Override
	public Optional<Empresa> BuscarPorId(Long id) {
		// TODO Auto-generated method stub
		return empresaRepository.findById(id);
	}

	@Override
	public Empresa Actualizar(Empresa empresa) {
		// TODO Auto-generated method stub
		return empresaRepository.save(empresa);
	}

	@Override
	public Boolean Eliminar(Long id) {
		// TODO Auto-generated method stub
		Optional<Empresa> empresa = empresaRepository.findById(id);
		if(empresa.isPresent())
		{
			empresaRepository.delete(empresa.get());
			return true;
		}
		return false;
	}

	@Override
	public List<Empresa> Listar() {
		// TODO Auto-generated method stub
		return empresaRepository.findAll();
	}

	@Override
	public Empresa BuscarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return empresaRepository.findByNombre(nombre);
	}

	@Override
	public Empresa BuscarPorRuc(String ruc) {
		// TODO Auto-generated method stub
		return empresaRepository.findByRuc(ruc);
	}	

}
