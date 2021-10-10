package com.developer.johhns.sqlite_01.Vistas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;

import com.developer.johhns.sqlite_01.Adaptadores.AdaptadorDepartamentos;
import com.developer.johhns.sqlite_01.R;
import com.developer.johhns.sqlite_01.Vistas.Fragmentos.InterfaseFragmento;

public class DepartamentosActivity extends AppCompatActivity implements InterfaseFragmento {

    RecyclerView recyclerView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_departamentos);

        recyclerView = findViewById(R.id.recViewDepto) ;
        recyclerView.setAdapter( new AdaptadorDepartamentos(this) );
        recyclerView.setLayoutManager( new LinearLayoutManager(this));

    }

    @Override
    public void generarLayout() {

    }

    @Override
    public AdaptadorDepartamentos crearAdaptador(Cursor cusor) {
        return null;
    }

    @Override
    public void inicializarAdaptadorRecView(AdaptadorDepartamentos adaptador) {

    }
}