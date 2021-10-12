package com.developer.johhns.sqlite_01.Datos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class DB_DML extends BaseDatos {

    Context   contexto ;
    BaseDatos db       ;

    public DB_DML(Context contexto) {
        super(contexto);
        this.contexto = contexto;
        this.db       = new BaseDatos( contexto ) ;
    }

    public  void insertarDepartamento(int codigo , String nombre ){
        ContentValues datos = new ContentValues() ;
        datos.put("NUMDPT",codigo);
        datos.put("NOMBRE",nombre);
        try {
            db.insertarRegistros( "GEN_DEPARTAMENTOS" , datos);
        }
        catch ( Exception e ) {
            Toast.makeText(contexto , e.getMessage().toString() , Toast.LENGTH_LONG).show();
        }

    }

    public void eliminarDepartamentos(){
        db.eliminarRegistros("GEN_DEPARTAMENTOS","1=1", null);
    }

    public Cursor  obtenerDepartamentos(){
        String         consulta = "SELECT NUMDPT , NOMBRE FROM GEN_DEPARTAMENTOS ORDER BY NUMDPT" ;
        SQLiteDatabase cursor = this.getReadableDatabase();
        return cursor.rawQuery( consulta , null ) ;
    }


}
