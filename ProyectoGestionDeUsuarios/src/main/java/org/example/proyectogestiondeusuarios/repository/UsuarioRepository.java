package org.example.proyectogestiondeusuarios.repository;

import org.example.proyectogestiondeusuarios.Dao.UsuarioDao;
import org.example.proyectogestiondeusuarios.UsuariosJsonDao;
import org.example.proyectogestiondeusuarios.model.Usuarios;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class UsuarioRepository {
    private final UsuariosJsonDao dao;
    private final List<Usuarios> usuarios = new ArrayList<>();

    public(UsuariosJsonDao dao){
        this.dao = dao;
    }

    public void cargar(){
        usuarios.clear();
        usuarios.addAll(dao.cargarUsuario());
    }

    public List<Usuarios> listar(){
        return Collections.unmodifiableList(usuarios);
    }

    public void agregar(Usuarios nuevo){
        usuarios.add(nuevo);
        try{
            guardare();
        }catch (RuntimeException e){
            usuarios.remove(nuevo);
        }
    }

    public void eliminar(Usuarios existente){
        int posicion = usuarios.indexOf(existente);
        if(posicion < 0){
            return;
        }
        usuarios.remove(posicion);
        try {
            guardar();
        }catch (RuntimeException e){
            usuarios.add(posicion,existente);
            throw e;
        }
    }

    private void guardar(){
        List<Usuarios> lista1 = new ArrayList<>();
        for(Usuarios elemento  : usuarios){
            if(elemento instanceof Usuarios a ){
                lista1.add(a);
            }
        }

    }


}
