package org.example.modelo;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;

public class Avengers {
    private int id;
    private String nombre;
    private String alias;
    private String poder;
    private String ocupacion;
    private String url;

    public Avengers() {
    }

    public Avengers(int id, String nombre, String alias, String poder, String ocupacion, String url) {
        this.id = id;
        this.nombre = nombre;
        this.alias = alias;
        this.poder = poder;
        this.ocupacion = ocupacion;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getPoder() {
        return poder;
    }

    public void setPoder(String poder) {
        this.poder = poder;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Avengers{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", alias='" + alias + '\'' +
                ", poder='" + poder + '\'' +
                ", ocupacion='" + ocupacion + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    //excepcion del tipo URL
    public ImageIcon getFotoUrl() throws MalformedURLException {
        URL urlFoto = new URL(this.url);
        return new ImageIcon(urlFoto);
    }
}
