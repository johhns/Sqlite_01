package com.developer.johhns.sqlite_01.Vistas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.developer.johhns.sqlite_01.Datos.DB_DML;
import com.developer.johhns.sqlite_01.R;
import com.developer.johhns.sqlite_01.databinding.ActivityNuevoDeptoBinding;

public class NuevoDepto extends AppCompatActivity {

    DB_DML  db = new DB_DML( this );
    private Button   btnInsertar , btnInsetarMas, btnCancelar ;
    private EditText txtCodigo , txtNombre ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_depto);

        txtCodigo = findViewById( R.id.txtCodigo ) ;
        txtNombre = findViewById( R.id.txtNombre ) ;

        btnInsertar   = findViewById( R.id.btnInsertar ) ;
        btnInsetarMas = findViewById( R.id.btnAdicionarMas ) ;
        btnCancelar   = findViewById( R.id.btnCancelar ) ;

        btnInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.insertarDepartamento( Integer.parseInt( txtCodigo.getText().toString() ) , txtNombre.getText().toString() );
                finish();
            }
        });

        btnInsetarMas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.insertarDepartamento( Integer.parseInt( txtCodigo.getText().toString() ) , txtNombre.getText().toString() );
                txtNombre.setText("");
                txtCodigo.setText("");
            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}