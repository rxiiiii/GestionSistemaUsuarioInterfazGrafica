package org.example.proyectogestiondeusuarios;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import org.example.proyectogestiondeusuarios.Dao.PersistenteException;
import org.example.proyectogestiondeusuarios.Dao.UsuarioDao;
import org.example.proyectogestiondeusuarios.model.Usuarios;

import java.io.Reader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UsuariosJsonDao implements UsuarioDao {

    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Override
    public List<Usuarios> cargarUsuario() {
        Path archivo = Path.of("Usuario.Json");
        if(!Files.exists(archivo)){
            return new ArrayList<>();
        }

        try(Reader lector = Files.newBufferedReader(archivo,StandardCharsets.UTF_8)){
            Usuarios[] leidos = gsonfromJson(lector, Usuarios[].class);

            if(leidos == null){
                return new ArrayList<>();
            }

            return new ArrayList<>(Arrays.asList(leidos));

        }catch (IOException | JsonParseException e){
            throw new PersistenteException("No se pudo leer el archivo Usuarios.Json",e);
        }
    }

    @Override
    public void guardarUsuario(List<Usuarios> datos) {
        escribir("Usuarios.json", datos);
    }
}





