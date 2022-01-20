package com.example.mybusiness;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class adapterDatos extends RecyclerView.Adapter<adapterDatos.ViewHolderDatos> {
    private ArrayList<datos_adaptador> listaDatos;
    private Context context;

    public adapterDatos(ArrayList<datos_adaptador> listaDatos,Context context) {
        this.listaDatos = listaDatos;
        this.context=context;
    }

    @Override
    public  ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,null,false);

        return new ViewHolderDatos(v);
    }

    @Override
    public void onBindViewHolder(@NonNull  ViewHolderDatos holder, int position) {
        holder.hora.setText(listaDatos.get(position).getHora());
        datos_adaptador datos= listaDatos.get(position);
        holder.dato.setText(datos.getNombre());
        holder.codigo.setText(datos.getPin());
        holder.documento.setText(datos.getDocumento());
    }

    @Override
    public int getItemCount() {
        return listaDatos.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {
        TextView dato,codigo,hora,documento;

        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            dato=itemView.findViewById(R.id.nombre);
            codigo=itemView.findViewById(R.id.codigo);
            hora=itemView.findViewById(R.id.hora);
            documento=itemView.findViewById(R.id.documento);
        }
    }
}
