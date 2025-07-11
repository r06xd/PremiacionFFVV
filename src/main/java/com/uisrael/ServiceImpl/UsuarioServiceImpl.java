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
	public void cargarDesdeExcel(InputStream inputStream) {
	    try (Workbook workbook = new XSSFWorkbook(inputStream)) {
	        Sheet sheet = workbook.getSheetAt(0);
	        for (Row row : sheet) {
	            if (row.getRowNum() == 0) continue; // omitir cabecera

	            Usuario u = new Usuario();
	            u.setNombre(row.getCell(0).getStringCellValue());
	            u.setCorreo(row.getCell(1).getStringCellValue());
	            //u.setContrasena(Usuario.Rol.valueOf(row.getCell(2).getStringCellValue().toUpperCase()));

	            UsuarioRepository.save(u);
	        }
	    } catch (IOException e) {
	        throw new RuntimeException("Error al leer Excel", e);
	    }
	}

}
