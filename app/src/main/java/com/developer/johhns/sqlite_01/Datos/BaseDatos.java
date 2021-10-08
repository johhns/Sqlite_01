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

        db.delete() ;
        db.update() ;

        db.close();
    }

/*Cursor cursor = db.query(
    FeedEntry.TABLE_NAME,   // The table to query
    projection,             // The array of columns to return (pass null to get all)
    selection,              // The columns for the WHERE clause
    selectionArgs,          // The values for the WHERE clause
    null,                   // don't group the rows
    null,                   // don't filter by row groups
    sortOrder               // The sort order
    );
* */

    /*
    // Define 'where' part of query.
       String selection = FeedEntry.COLUMN_NAME_TITLE + " LIKE ?";
    // Specify arguments in placeholder order.
       String[] selectionArgs = { "MyTitle" };
    // Issue SQL statement.
       int deletedRows = db.delete(FeedEntry.TABLE_NAME, selection, selectionArgs);
    * */


    /*SQLiteDatabase db = dbHelper.getWritableDatabase();

// New value for one column
String title = "MyNewTitle";
ContentValues values = new ContentValues();
values.put(FeedEntry.COLUMN_NAME_TITLE, title);

// Which row to update, based on the title
String selection = FeedEntry.COLUMN_NAME_TITLE + " LIKE ?";
String[] selectionArgs = { "MyOldTitle" };

int count = db.update(
    FeedReaderDbHelper.FeedEntry.TABLE_NAME,
    values,
    selection,
    selectionArgs);
    * */


}
