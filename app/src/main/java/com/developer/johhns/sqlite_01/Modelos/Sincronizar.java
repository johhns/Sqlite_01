package com.developer.johhns.sqlite_01.Modelos;

import android.app.DownloadManager;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.developer.johhns.sqlite_01.Datos.DB_DML;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Sincronizar {

    private RequestQueue colaPeticiones ;
    private Context      contexto ;
    private DB_DML       dml      ;

    public Sincronizar(Context contexto) {
        this.contexto  = contexto;
        dml            = new DB_DML(contexto);
        colaPeticiones = Http_Util.get(contexto).obtenerPeticion();
    }

    public void sincronizarDeptos(){
        Log.i("JSON","Iniciando sincronizacion...... "  ) ;
        JsonArrayRequest peticion = new JsonArrayRequest(Request.Method.GET, Http_Util.URL_DEPTOS, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            dml.eliminarDepartamentos();
                            //JSONArray jsonArray = response.getJSONArray(null) ;
                            for ( int n = 0 ; n < response.length() ; n++ ){
                                JSONObject depto = response.getJSONObject(n) ;
                                dml.insertarDepartamento( depto.getInt("NUMDPT") , depto.getString("NOMBRE") );
                                Log.i("JSON","Insertando fila : " + n ) ;
                            }
                            Toast.makeText(contexto,"Proceso finalizado",Toast.LENGTH_LONG).show();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(contexto,"Ocurrio un error : " + error.getMessage(),Toast.LENGTH_LONG).show();
                        Log.i("JSON","Ocurrio un error : " + error.getMessage() ) ;
                    }
                }
            ) ;
           colaPeticiones.add( peticion ) ;
        }







}
