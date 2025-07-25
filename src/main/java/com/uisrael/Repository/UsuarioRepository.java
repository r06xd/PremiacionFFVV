package com.uisrael.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.uisrael.Entity.Usuario;

//public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
//    Optional<Usuario> findByUsername(String username);
//}

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    @Query("SELECT u FROM Usuario u WHERE u.empresa.id = :empresaId")
    List<Usuario> findByEmpresaId(@Param("empresaId") Long empresaId);
    Optional<Usuario> findByCorreo(String correo);

}