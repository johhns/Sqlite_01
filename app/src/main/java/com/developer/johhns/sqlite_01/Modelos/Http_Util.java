package com.developer.johhns.sqlite_01.Modelos;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;


public class Http_Util {

    private static Http_Util instancia ;
    private RequestQueue mPeticion ;

    public static final String URL_DEPTOS = "http://appserver.iea.com.sv/wsag/Sag_HH_Util.Sincronizar_Departamentos" ;
    public static final String URL_MUNICIPIOS = "http://appserver.iea.com.sv/wsag/Sag_HH_Util.Sincronizar_Municipios" ;

    private Http_Util( Context contexto ){
       this.mPeticion = Volley.newRequestQueue( contexto.getApplicationContext() ) ;
    }

    public static synchronized Http_Util get( Context contexto ){
        if ( instancia == null ) {
            instancia = new Http_Util(contexto);
        }
        return instancia ;
    }

    public RequestQueue obtenerPeticion() {
        return mPeticion ;
    }

}
