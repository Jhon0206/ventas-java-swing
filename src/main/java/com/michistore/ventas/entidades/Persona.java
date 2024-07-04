package com.michistore.ventas.entidades;

public abstract class Persona {
    protected Integer id;
    protected String dni;
    protected String nombres;
    protected String correo;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nID=").append(id);
        sb.append("\nDni=").append(dni);
        sb.append("\nNombres=").append(nombres);
        sb.append("\nCorreo=").append(correo);
        sb.append("\n");
        return sb.toString();
    }   
    
}
