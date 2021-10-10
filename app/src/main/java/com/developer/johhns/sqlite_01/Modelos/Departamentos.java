package com.developer.johhns.sqlite_01.Modelos;

public class Departamentos {

    private int    numdpt ;
    private String nombre ;

    public Departamentos() {
    }

    public Departamentos(int numdpt, String nombre) {
        this.numdpt = numdpt;
        this.nombre = nombre;
    }

    public int getNumdpt() {
        return numdpt;
    }

    public void setNumdpt(int numdpt) {
        this.numdpt = numdpt;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
