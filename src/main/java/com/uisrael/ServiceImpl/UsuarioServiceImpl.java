package com.uisrael.ServiceImpl;

import java.io.InputStream;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uisrael.Entity.Usuario;
import com.uisrael.Repository.UsuarioRepository;
import com.uisrael.Service.UsuarioService;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.InputStream;
import java.io.IOException;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository UsuarioRepository;



    @Override
    public List<Usuario> listarTodos() {
        return UsuarioRepository.findAll();
    }

    @Override
    public Usuario guardar(Usuario usuario) {
        usuario.setContrasena(usuario.getContrasena());
        return UsuarioRepository.save(usuario);
    }

    @Override
    public Optional<Usuario> buscarPorId(Long id) {
        return UsuarioRepository.findById(id);
    }

    @Override
    public void eliminar(Long id) {
    	UsuarioRepository.deleteById(id);
    }

	@Override
	public Optional<Usuario> buscarPorUsername(String username) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Optional<Usuario> buscarPorCorreo(String correo) {
		// TODO Auto-generated method stub
		return UsuarioRepository.findByCorreo(correo);
	}
}
