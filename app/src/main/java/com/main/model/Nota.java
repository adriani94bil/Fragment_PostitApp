package com.main.model;

import java.io.Serializable;
import java.util.Date;

public class Nota implements Serializable {
    private String mensaje;
    private Date fechaCreacion;
    private String autor;

    public Nota(String mensaje,  String autor) {
        this.mensaje = mensaje;
        this.fechaCreacion = new Date();
        this.autor = autor;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return mensaje;
    }
}
