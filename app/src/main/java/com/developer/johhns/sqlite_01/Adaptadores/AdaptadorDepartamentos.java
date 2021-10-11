package com.developer.johhns.sqlite_01.Adaptadores;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.developer.johhns.sqlite_01.Datos.DB_DML;
import com.developer.johhns.sqlite_01.Modelos.Departamentos;
import com.developer.johhns.sqlite_01.R;

public class AdaptadorDepartamentos extends RecyclerView.Adapter<AdaptadorDepartamentos.ViewHolder> {

    private Cursor  cursor   ;
    private Context contexto ;
    private DB_DML  dml      ;

    public AdaptadorDepartamentos(Context contexto) {
        this.contexto = contexto;
        this.dml      = new DB_DML( contexto ) ;

        /*
        dml.insertarDepartamento( 1 , "San Salvador" );
        dml.insertarDepartamento( 2 , "Santa Ana" );
        dml.insertarDepartamento( 3 , "La Paz" );
        */

        this.cursor   = dml.obtenerDepartamentos() ;
    }

    @NonNull
    @Override
    public AdaptadorDepartamentos.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from( parent.getContext() ).inflate( R.layout.card_departamentos , null , false ) ;
        return new ViewHolder( view ) ;
    }

    private Departamentos deptoPosicion( int posicion ){
        Departamentos depto = new Departamentos();
        cursor.moveToPosition( posicion ) ;
        depto.setNumdpt( cursor.getInt(0) );
        depto.setNombre( cursor.getString(1) );
        return depto ;
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorDepartamentos.ViewHolder holder, int position) {
        Departamentos depto = deptoPosicion( position ) ;
        holder.txtNumDpt.setText( String.valueOf( depto.getNumdpt() ) );
        holder.txtNombre.setText( depto.getNombre() );
        holder.itemView.setTag( new Integer( position ) );
    }

    @Override
    public int getItemCount() {
        if ( cursor != null ) {
            return cursor.getCount() ;
        } else {
            return 0;
        }
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtNumDpt , txtNombre ;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNumDpt = itemView.findViewById( R.id.txtNumDpt ) ;
            txtNombre = itemView.findViewById( R.id.txtNombreDepto ) ;
        }
    }
}
