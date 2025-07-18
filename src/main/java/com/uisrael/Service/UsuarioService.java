package com.uisrael.Service;

import java.io.InputStream;
import java.util.List;
import java.util.Optional;

import com.uisrael.Entity.Usuario;

public interface UsuarioService {
    Usuario guardar(Usuario usuario);
    Optional<Usuario> buscarPorId(Long id);
    Optional<Usuario> buscarPorUsername(String username);
    Optional<Usuario> buscarPorCorreo(String correo);
    List<Usuario> listarTodos();
	void eliminar(Long id);
	
}