package com.developer.johhns.sqlite_01.Vistas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.developer.johhns.sqlite_01.Datos.BaseDatos;
import com.developer.johhns.sqlite_01.Datos.DB_DML;
import com.developer.johhns.sqlite_01.Modelos.Sincronizar;
import com.developer.johhns.sqlite_01.R;

public class MainActivity extends AppCompatActivity {

    Button btnDeptos, btnMunicipios , btnNuevoDepto, btnSincronizar , btnEliminarDeptos ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDeptos = findViewById( R.id.btnDeptos ) ;
        btnDeptos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity( new Intent( view.getContext() , DepartamentosActivity.class ) );
            }
        });

        btnNuevoDepto = findViewById( R.id.btnNuevoDepto ) ;
        btnNuevoDepto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity( new Intent( view.getContext() , NuevoDepto.class ) );
            }
        });

        btnSincronizar = findViewById( R.id.btnSincronizarDeptos ) ;
        btnSincronizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Sincronizar sincronizar = new Sincronizar( view.getContext() ) ;
                sincronizar.sincronizarDeptos();
            }
        });

        btnEliminarDeptos = findViewById( R.id.btnEliminarDeptos ) ;
        btnEliminarDeptos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DB_DML dml = new DB_DML(view.getContext()) ;
                dml.eliminarDepartamentos();
            }
        });

    }
}