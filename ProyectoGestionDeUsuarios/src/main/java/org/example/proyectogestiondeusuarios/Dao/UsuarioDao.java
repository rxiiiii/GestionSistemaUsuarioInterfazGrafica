package org.example.proyectogestiondeusuarios.Dao;

import org.example.proyectogestiondeusuarios.model.Usuarios;
import org.example.proyectogestiondeusuarios.repository.UsuarioRepository;

import java.util.List;

public interface UsuarioDao {
    List<Usuarios> cargarUsuario();
    void guardarUsuario(List<Usuarios> datos);

}
