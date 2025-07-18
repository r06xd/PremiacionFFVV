package com.uisrael.Service;

import java.util.List;

import com.uisrael.Entity.Empresa;

public interface EmpresaService {
    List<Empresa> listarTodas();
    Empresa guardar(Empresa empresa);
    void eliminar(Long id);

}
