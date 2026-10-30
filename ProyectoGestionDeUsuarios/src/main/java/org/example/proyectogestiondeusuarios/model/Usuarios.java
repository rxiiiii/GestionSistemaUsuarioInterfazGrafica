
package org.example.proyectogestiondeusuarios.model;

public class Usuarios {

    private String nombre;
    private int edad;
    private String correo;

    public Usuarios(String nombre, int edad, String correo) {
        setNombre(nombre);
        setEdad(edad);
        setCorreo(correo);
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "El nombre no puede estar vacío."
            );
        }

        for (int i = 0; i < nombre.length(); i++) {
            char caracter = nombre.charAt(i);

            if (!Character.isLetter(caracter) && caracter != ' ') {
                throw new IllegalArgumentException(
                        "El nombre solo puede contener letras y espacios."
                );
            }
        }

        this.nombre = nombre.trim();
    }

    public void setEdad(int edad) {
        if (edad <= 0 || edad >= 120) {
            throw new IllegalArgumentException(
                    "La edad debe ser mayor que 0 y menor que 120."
            );
        }

        this.edad = edad;
    }

    public void setCorreo(String correo) {
        if (correo == null || correo.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "El correo no puede estar vacío."
            );
        }

        correo = correo.trim();

        if (correo.contains(" ")) {
            throw new IllegalArgumentException(
                    "El correo no puede contener espacios."
            );
        }

        int posicionArroba = correo.indexOf('@');
        int ultimoPunto = correo.lastIndexOf('.');

        if (posicionArroba <= 0|| ultimoPunto <= posicionArroba + 1 || ultimoPunto == correo.length() - 1 || correo.indexOf('@', posicionArroba + 1) != -1) {
            throw new IllegalArgumentException("El formato del correo no es válido.");
        }

        this.correo = correo;
    }
}
