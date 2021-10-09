package com.developer.johhns.sqlite_01.Datos;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BaseDatos extends SQLiteOpenHelper {

    public BaseDatos( @Nullable Context contexto ) {
        super( contexto , DB_DDL.DB_NOMBRE , null , 1 ) ;
    }

    @Override
    public void onCreate(SQLiteDatabase db ) {
       db.execSQL( DB_DDL.GEN_DEPARTAMENTOS );
       db.execSQL( DB_DDL.GEN_MUNICIPIOS );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int version_anterior, int nueva_version ) {
       db.execSQL("DROP IF EXISTS GEN_DEPARTAMENTOS");
       db.execSQL("DROP IF EXISTS GEN_MUNICIPIOS");
       onCreate(db);
    }

    public void insertarRegistros(String tabla , ContentValues columnas ){
        SQLiteDatabase db = this.getWritableDatabase() ;
        db.insert( tabla , null , columnas ) ;
        db.close();
    }

    public int eliminarRegistros(String tabla, String filtro, String[] valores ) {
        SQLiteDatabase db = this.getWritableDatabase() ;
        int registros ;
        registros = db.delete( tabla , filtro , valores) ;
        db.close();
        return registros ;
    }

    public int actualizarTabla(String tabla, ContentValues columnas, String filtro, String[] valores){
        SQLiteDatabase db = this.getWritableDatabase();
        int registros ;
        registros = db.update( tabla , columnas , filtro , valores );
        db.close();
        return registros ;
    }


}
