package com.example.mybusiness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class planes extends AppCompatActivity {
    private ArrayList<planesG> listaplanesn,listaplaness,listaplanesx,listaplanesd,listaplanesh,listaplanesa;
    private String usuario="";
    private ImageView imagen;
    private ListView lv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planes);
        imagen= findViewById(R.id.image);
        lv1= findViewById(R.id.lista);

        listaplanesn= new ArrayList<planesG>();
        listaplanesn.add(new planesG("•\tPlan básico: $16900  cada  mes." ));
        listaplanesn.add(new planesG("•\tPlan standard: $26900 mensuales." ));
        listaplanesn.add(new planesG("•\tPlan Premium: $38900 cada mes. " ));
        listaplanesn.add(new planesG("•\tPlan Top/Prm: $77900 cada mes." ));

        listaplaness= new ArrayList<planesG>();
        listaplaness.add(new planesG("•\tMini: $3000 por semana 1 cuenta."));
        listaplaness.add(new planesG("•\tIndividual: $14900  mes 1 cuenta."));
        listaplaness.add(new planesG("•\tDuo: $19900 el mes 2 cuentas." ));
        listaplaness.add(new planesG("•\tFamiliar: $23900 mes 6 cuentas."));

        listaplanesx= new ArrayList<planesG>();
        listaplanesx.add(new planesG("•\tXbox Live Gold $32900 el mes." ));
        listaplanesx.add(new planesG("•\tGame Pass for Console $29900." ));
        listaplanesx.add(new planesG("•\tXbox Game Pass Ultimate $44900." ));
        listaplanesx.add(new planesG("•\tPC Game Pass $29900 el mes." ));

        listaplanesd= new ArrayList<planesG>();
        listaplanesd.add(new planesG("•\tPlan mes Disney Precio $23900."));
        listaplanesd.add(new planesG("•\tPlan año Disney Precio $239900." ));
        listaplanesd.add(new planesG("•\tMes Disney + Star Plus $38900." ));
        listaplanesd.add(new planesG("•\tAño Disney + Star Plus $389900." ));

        listaplanesh= new ArrayList<planesG>();
        listaplanesh.add(new planesG("•\tPlan móvil $13900 el mes."));
        listaplanesh.add(new planesG("•\tPlan estándar  $19900 el mes."));
        listaplanesh.add(new planesG("•\tPlan móvil $37899 tres meses."));
        listaplanesh.add(new planesG("•\tPlan estándar $52900 tres meses."));

        listaplanesa= new ArrayList<planesG>();
        listaplanesa.add(new planesG("•\tPlan estandar de un mes $14900." ));
        listaplanesa.add(new planesG("•\tPlan estandar de 3 meses $40000." ));
        listaplanesa.add(new planesG("•\tPlan exclusivo de un mes $17900." ));
        listaplanesa.add(new planesG("•\tPlan exclusivo  3 meses $52000." ));

        Bundle bundle = getIntent().getExtras();
        String afiliado= bundle.getString("dato");
        usuario=bundle.getString("usuario");
        if (afiliado.equals("netflix")){
            AdaptadorPlanes1 adaptar= new AdaptadorPlanes1(this);
            lv1.setAdapter(adaptar);
            lv1.setClickable(true);
            lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    String posicion=i+"";
                    Intent n=new Intent(planes.this, confirmacion_venta.class);
                    n.putExtra("posicion",posicion);
                    n.putExtra("usuario",usuario);
                    n.putExtra("afiliado","netflix");
                    startActivity(n);
                }
            });
        }else if(afiliado.equals("spotify")){
            imagen.setImageResource(R.drawable.ic_spotify);
            AdaptadorPlanes2 adaptar= new AdaptadorPlanes2(this);
            lv1.setAdapter(adaptar);
            lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    String posicion=i+"";
                    Intent s=new Intent(planes.this, confirmacion_venta.class);
                    s.putExtra("posicion",posicion);
                    s.putExtra("usuario",usuario);
                    s.putExtra("afiliado","spotify");
                    startActivity(s);
                }
            });
        } else if(afiliado.equals("xbox")){
        imagen.setImageResource(R.drawable.ic_xbox);
        AdaptadorPlanes3 adaptar= new AdaptadorPlanes3(this);
        lv1.setAdapter(adaptar);
            lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    String posicion=i+"";
                    Intent n=new Intent(planes.this, confirmacion_venta.class);
                    n.putExtra("posicion",posicion);
                    n.putExtra("usuario",usuario);
                    n.putExtra("afiliado","xbox");
                    startActivity(n);

                }
            });
        } else if(afiliado.equals("disney")){
                imagen.setImageResource(R.drawable.ic_disney_plus);
                AdaptadorPlanes4 adaptar= new AdaptadorPlanes4(this);
                lv1.setAdapter(adaptar);
                lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    String posicion=i+"";
                    Intent n=new Intent(planes.this, confirmacion_venta.class);
                    n.putExtra("posicion", posicion);
                    n.putExtra("usuario",usuario);
                    n.putExtra("afiliado","disney");
                    startActivity(n);

                }
            });
        } else if(afiliado.equals("hbo")){
                imagen.setImageResource(R.drawable.ic_hbo);
                AdaptadorPlanes5 adaptar= new AdaptadorPlanes5(this);
                lv1.setAdapter(adaptar);
            lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    String posicion=i+"";
                    Intent n=new Intent(planes.this,confirmacion_venta.class);
                    n.putExtra("posicion", posicion);
                    n.putExtra("usuario",usuario);
                    n.putExtra("afiliado","hbo");
                    startActivity(n);

                }
            });
        } else if(afiliado.equals("amazon")){
            imagen.setImageResource(R.drawable.ic_amazon);
            AdaptadorPlanes6 adaptar= new AdaptadorPlanes6(this);
            lv1.setAdapter(adaptar);
            lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    String posicion=i+"";
                    Intent n=new Intent(planes.this, confirmacion_venta.class);
                    n.putExtra("posicion", posicion);
                    n.putExtra("usuario",usuario);
                    n.putExtra("afiliado","amazon");
                    startActivity(n);
                }
            });
        }

    }
    class  AdaptadorPlanes1 extends ArrayAdapter<planesG>{
        AppCompatActivity appcompatActivity;
        AdaptadorPlanes1(AppCompatActivity context){
            super(context,R.layout.listaplanes,listaplanesn);
            appcompatActivity=context;
        }
        public View getView(int position, View convertView, ViewGroup parent){
            LayoutInflater inflater=appcompatActivity.getLayoutInflater();
            View item=inflater.inflate(R.layout.listaplanes, null);
            TextView textView1=item.findViewById(R.id.textView);
            textView1.setText( listaplanesn.get(position).getDescripcion());
            ImageView iv1=item.findViewById(R.id.image);
            iv1.setImageResource(R.drawable.ic_netflix);
            return (item);
        }
    }
    class  AdaptadorPlanes2 extends ArrayAdapter<planesG>{
        AppCompatActivity appcompatActivity;
        AdaptadorPlanes2(AppCompatActivity context){
            super(context,R.layout.listaplanes,listaplaness);
            appcompatActivity=context;
        }
        public View getView(int position, View convertView, ViewGroup parent){
            LayoutInflater inflater=appcompatActivity.getLayoutInflater();
            View item=inflater.inflate(R.layout.listaplanes, null);
            TextView textView1=item.findViewById(R.id.textView);
            textView1.setText( listaplaness.get(position).getDescripcion());
            ImageView iv1=item.findViewById(R.id.image);
            iv1.setImageResource(R.drawable.ic_spotify);
            return (item);
        }
    }
    class  AdaptadorPlanes3 extends ArrayAdapter<planesG>{
        AppCompatActivity appcompatActivity;
        AdaptadorPlanes3(AppCompatActivity context){
            super(context,R.layout.listaplanes,listaplanesx);
            appcompatActivity=context;
        }
        public View getView(int position, View convertView, ViewGroup parent){
            LayoutInflater inflater=appcompatActivity.getLayoutInflater();
            View item=inflater.inflate(R.layout.listaplanes, null);
            TextView textView1=item.findViewById(R.id.textView);
            textView1.setText( listaplanesx.get(position).getDescripcion());
            ImageView iv1=item.findViewById(R.id.image);
            iv1.setImageResource(R.drawable.ic_xbox);
            return (item);
        }
    }
    class  AdaptadorPlanes4 extends ArrayAdapter<planesG>{
        AppCompatActivity appcompatActivity;
        AdaptadorPlanes4(AppCompatActivity context){
            super(context,R.layout.listaplanes,listaplanesd);
            appcompatActivity=context;
        }
        public View getView(int position, View convertView, ViewGroup parent){
            LayoutInflater inflater=appcompatActivity.getLayoutInflater();
            View item=inflater.inflate(R.layout.listaplanes, null);
            TextView textView1=item.findViewById(R.id.textView);
            textView1.setText( listaplanesd.get(position).getDescripcion());
            ImageView iv1=item.findViewById(R.id.image);
            iv1.setImageResource(R.drawable.ic_disney_plus);
            return (item);
        }
    }
    class  AdaptadorPlanes5 extends ArrayAdapter<planesG>{
        AppCompatActivity appcompatActivity;
        AdaptadorPlanes5(AppCompatActivity context){
            super(context,R.layout.listaplanes,listaplanesh);
            appcompatActivity=context;
        }
        public View getView(int position, View convertView, ViewGroup parent){
            LayoutInflater inflater=appcompatActivity.getLayoutInflater();
            View item=inflater.inflate(R.layout.listaplanes, null);
            TextView textView1=item.findViewById(R.id.textView);
            textView1.setText( listaplanesh.get(position).getDescripcion());
            ImageView iv1=item.findViewById(R.id.image);
            iv1.setImageResource(R.drawable.ic_hbo);
            return (item);
        }
    }
    class  AdaptadorPlanes6 extends ArrayAdapter<planesG>{
        AppCompatActivity appcompatActivity;
        AdaptadorPlanes6(AppCompatActivity context){
            super(context,R.layout.listaplanes,listaplanesa);
            appcompatActivity=context;
        }
        public View getView(int position, View convertView, ViewGroup parent){
            LayoutInflater inflater=appcompatActivity.getLayoutInflater();
            View item=inflater.inflate(R.layout.listaplanes, null);
            TextView textView1=item.findViewById(R.id.textView);
            textView1.setText( listaplanesa.get(position).getDescripcion());
            ImageView iv1=item.findViewById(R.id.image);
            iv1.setImageResource(R.drawable.ic_amazon);
            return (item);
        }
    }
    public void volver(View v){
        finish();
    }

}