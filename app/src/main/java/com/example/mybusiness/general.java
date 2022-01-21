package com.example.mybusiness;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

public class general extends AppCompatActivity {
    ArrayList<datos_adaptador> listaDatos;
    private String usuario = "";
    private CustomViewPager view1;
    private RelativeLayout dummyView;
    private ConstraintLayout pagina1, pagina2;
    private ImageButton imgHome, imgHis, imgSal;


    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general);

        view1 = findViewById(R.id.view1);
        view1.setPagingEnabled(false);
        imgHome = findViewById(R.id.imgHome);
        imgHis = findViewById(R.id.historial);
        imgSal = findViewById(R.id.salir);
        view1.setAdapter(new AdminPageAdapter());
        Bundle bundle = getIntent().getExtras();
        usuario = bundle.getString("usuario");
    }

    @Override
    public void onBackPressed() {
    }

    class AdminPageAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public Object instantiateItem(ViewGroup collection, int position) {
            View actual = null;
            switch (position) {
                case 0:
                    if (pagina1 == null) {
                        pagina1 = (ConstraintLayout) LayoutInflater.from(general.this).inflate(R.layout.home1, null);
                    }
                    actual = pagina1;
                    break;
                case 1:
                    if (pagina2 == null) {
                        pagina2 = (ConstraintLayout) LayoutInflater.from(general.this).inflate(R.layout.historial, null);
                    }
                    actual = pagina2;
                    break;
                default:
                    break;
            }
            ViewPager vp = (ViewPager) collection;
            vp.addView(actual, 0);
            pagina1(actual);
            return actual;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            super.destroyItem(container, position, object);
            ((ViewPager) container).removeView((View) object);
        }

        @Override
        public void destroyItem(View collection, int position, Object view) {
            ((ViewPager) collection).removeView((View) view);
        }
    }

    public void pagina1(View v) {
        TimeZone myTimeZone = TimeZone.getTimeZone("America/Bogota");
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("dd");
        simpleDateFormat1.setTimeZone(myTimeZone);
        String dia = simpleDateFormat1.format(new Date());
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        Cursor filan = bd.rawQuery("select precio_ventas_dia from venta_dia where dia_venta='" + dia + "' and usuario='" + usuario + "'", null);
        TextView tvprecio = (TextView) findViewById(R.id.textView8);
        if (filan.moveToFirst()) {
            tvprecio.setText(filan.getString(0) + " presos");
        } else {
            tvprecio.setText("0 pesos");
        }
        TextView tvusuario = (TextView) findViewById(R.id.textView2);
        TextView tvventas = (TextView) findViewById(R.id.textView6);
        Cursor datos = bd.rawQuery("select ventas from administrativos where usuario='" + usuario + "'", null);
        String ventas;
        if (datos.moveToFirst()) {
            ventas = datos.getString(0);
        } else {
            ventas = "";
        }
        tvusuario.setText(usuario);
        tvventas.setText(ventas + " ventas");
        view1.setCurrentItem(0);
        imgHome.setImageResource(R.drawable.ic_home2);
        imgHis.setImageResource(R.drawable.ic_historial);
        imgSal.setImageResource(R.drawable.ic_volver);
        bd.close();
    }

    public void pagina2(View v) {
        RecyclerView recyclr;
        recyclr = findViewById(R.id.rc);
        recyclr.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true));
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        Cursor fila = bd.rawQuery("select * from historial  where usuario='" + usuario + "'", null);
        datos_adaptador datos;
        if (fila.moveToFirst()) {
            listaDatos = new ArrayList<datos_adaptador>();
            do {
                datos = new datos_adaptador();
                datos.setNombre(fila.getString(fila.getColumnIndex("nombre")));
                datos.setHora(fila.getString(fila.getColumnIndex("hora_venta")));
                datos.setPin(fila.getString(fila.getColumnIndex("pin")));
                datos.setDocumento(fila.getString(fila.getColumnIndex("documento_cliente")));
                listaDatos.add(datos);
            } while (fila.moveToNext());
            adapterDatos adaptar = new adapterDatos(listaDatos, this);
            recyclr.setAdapter(adaptar);
        }

        bd.close();
        imgHome.setImageResource(R.drawable.ic_home);
        imgHis.setImageResource(R.drawable.ic_historial2);
        imgSal.setImageResource(R.drawable.ic_volver);
        view1.setCurrentItem(1);
    }

    public void pagina3(View v) {
        AlertDialog.Builder dialogo1 = new AlertDialog.Builder(general.this);
        dialogo1.setTitle("importante");
        dialogo1.setMessage("¿Desea cerrar sesion?");
        dialogo1.setCancelable(false);
        dialogo1.setPositiveButton("confirmar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogo1, int i) {
                Intent login = new Intent(general.this, Login.class);
                startActivity(login);
                finish();
            }
        });
        dialogo1.setNegativeButton("cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogo1, int i) {
            }
        });
        dialogo1.show();
    }

    public void netflix(View v) {
        Intent acn = new Intent(this, planes.class);
        acn.putExtra("dato", "netflix");
        acn.putExtra("usuario", usuario);
        startActivity(acn);

    }

    public void spotify(View v) {
        Intent acs = new Intent(this, planes.class);
        acs.putExtra("dato", "spotify");
        acs.putExtra("usuario", usuario);
        startActivity(acs);
    }

    public void xbox(View v) {
        Intent acx = new Intent(this, planes.class);
        acx.putExtra("dato", "xbox");
        acx.putExtra("usuario", usuario);
        startActivity(acx);
    }

    public void disney(View v) {
        Intent acd = new Intent(this, planes.class);
        acd.putExtra("dato", "disney");
        acd.putExtra("usuario", usuario);
        startActivity(acd);
    }

    public void hbo(View v) {
        Intent ach = new Intent(this, planes.class);
        ach.putExtra("dato", "hbo");
        ach.putExtra("usuario", usuario);
        startActivity(ach);

    }

    public void amazon(View v) {
        Intent acp = new Intent(this, planes.class);
        acp.putExtra("dato", "amazon");
        acp.putExtra("usuario", usuario);
        startActivity(acp);
    }
}