package com.developer.johhns.sqlite_01.Datos;

public class DB_DDL {

    public static final String DB_NOMBRE = "DB_GEA.db3" ;

    public static final String GEN_DEPARTAMENTOS = "CREATE TABLE IF NOT EXISTS GEN_DEPARTAMENTOS ( " +
                                                   "NUMDPT    INTEGER ," +
                                                   "NOMBRE    TEXT )" ;

    public static final String GEN_MUNICIPIOS    = "CREATE TABLE IF NOT EXISTS GEN_MUNICIPIOS ( " +
                                                   "NUMMUN    INTEGER  ," +
                                                   "NOMBRE    TEXT," +
                                                   "NUMDPT    INTEGER " +
                                                   " " +
                                                   " )";


}
