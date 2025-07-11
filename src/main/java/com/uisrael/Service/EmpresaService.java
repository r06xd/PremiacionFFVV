package com.uisrael.Service;

import java.util.List;
import java.util.Optional;

import com.uisrael.Entity.Empresa;

public interface EmpresaService{
    //CRUD
	Empresa Crear(Empresa empresa);
	Optional<Empresa> BuscarPorId(Long id);
	Empresa Actualizar(Empresa empresa);
	Boolean Eliminar(Long id);
	List<Empresa> Listar();
	
	//Personalizadas
	Empresa BuscarPorNombre(String nombre);
	Empresa BuscarPorRuc(String ruc);
}
