package com.developer.johhns.sqlite_01.Modelos;

public class Municipios {

    private int    numdpt ;
    private int    nummun ;
    private String nombre ;

    public Municipios(int numdpt, int nummun, String nombre) {
        this.numdpt = numdpt;
        this.nummun = nummun;
        this.nombre = nombre;
    }

    public int getNumdpt() {
        return numdpt;
    }

    public void setNumdpt(int numdpt) {
        this.numdpt = numdpt;
    }

    public int getNummun() {
        return nummun;
    }

    public void setNummun(int nummun) {
        this.nummun = nummun;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
