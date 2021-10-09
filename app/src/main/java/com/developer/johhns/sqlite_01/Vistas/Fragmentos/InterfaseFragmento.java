package com.developer.johhns.sqlite_01.Vistas.Fragmentos;

import android.database.Cursor;

import com.developer.johhns.sqlite_01.Adaptadores.AdaptadorDepartamentos;
import com.developer.johhns.sqlite_01.Modelos.Departamentos;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public interface InterfaseFragmento {

    public void generarLayout();

    public AdaptadorDepartamentos crearAdaptador(Cursor cusor);

    public void inicializarAdaptadorRecView(AdaptadorDepartamentos adaptador);

}
