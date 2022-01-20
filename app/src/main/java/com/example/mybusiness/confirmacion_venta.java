package com.example.mybusiness;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class confirmacion_venta extends AppCompatActivity {
    private ImageView img;
    private EditText doc;
    private TextView nombre_plan, descripcion,codigo,precioe;
    private Double precio=0.0;
    private String codigoGen="",nombreVenta="",usuario="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacion_venta);

        img= findViewById(R.id.imagen);
        nombre_plan=findViewById(R.id.nombre_plan);
        descripcion=findViewById(R.id.descripcion_plan);
        codigo=findViewById(R.id.codigo);
        doc=findViewById(R.id.et);
        precioe=findViewById(R.id.precio);

        AdminSQLiteOpenHelper admin= new AdminSQLiteOpenHelper(this,"administracion",null,1);
        SQLiteDatabase bd=admin.getWritableDatabase();

        SharedPreferences prefe =getSharedPreferences("carga", Context.MODE_PRIVATE);
        String validar=prefe.getString("dato","");
        if (validar.equals("")){
            SharedPreferences.Editor editor=prefe.edit();
            editor.putString("dato","ya");
            editor.commit();
            cargarPlanes ejecutar=new cargarPlanes();
            ejecutar.cargar(admin,bd);
        }
        Bundle datos = getIntent().getExtras();
        usuario=datos.getString("usuario");
        String poscicion= datos.getString("posicion");
        String plataforma= datos.getString("afiliado");

         if (plataforma.equals("netflix")){
             int codigop=Integer.parseInt(poscicion);
            Cursor fila= bd.rawQuery("select nombre,descripcion,precio  from planesg where codigo="+codigop+" and plat='"+plataforma+"'",null);
            if (fila.moveToFirst()){
                nombre_plan.setText("•\t"+fila.getString(0));
                descripcion.setText(fila.getString(1));
                precio=Double.parseDouble(fila.getString(2));
            }
            bd.close();
        }else if (  plataforma.equals("spotify")) {
             int codigop=Integer.parseInt(poscicion)+4;
             img.setImageResource(R.drawable.ic_spotify);
             Cursor fila = bd.rawQuery("select nombre,descripcion,precio  from planesg where codigo="+codigop+" and plat='" + plataforma + "'", null);
             if (fila.moveToFirst()) {
                 nombre_plan.setText("•\t" + fila.getString(0));
                 descripcion.setText(fila.getString(1));
                 precio = Double.parseDouble(fila.getString(2));
             }
             bd.close();
         }else if ( plataforma.equals("xbox")) {
             int codigop=Integer.parseInt(poscicion)+8;
             img.setImageResource(R.drawable.ic_xbox);
             Cursor fila = bd.rawQuery("select nombre,descripcion,precio  from planesg where codigo="+codigop+" and plat='" + plataforma + "'", null);
             if (fila.moveToFirst()) {
                 nombre_plan.setText("•\t" + fila.getString(0));
                 descripcion.setText(fila.getString(1));
                 precio = Double.parseDouble(fila.getString(2));
             }
             bd.close();
         }else if ( plataforma.equals("disney")) {
             int codigop=Integer.parseInt(poscicion)+12;
             img.setImageResource(R.drawable.ic_disney_plus);
             Cursor fila = bd.rawQuery("select nombre,descripcion,precio  from planesg where codigo="+codigop+" and plat='" + plataforma + "'", null);
             if (fila.moveToFirst()) {
                 nombre_plan.setText("•\t" + fila.getString(0));
                 descripcion.setText(fila.getString(1));
                 precio = Double.parseDouble(fila.getString(2));
             }
             bd.close();
         }else if ( plataforma.equals("hbo")) {
             int codigop=Integer.parseInt(poscicion)+16;
             img.setImageResource(R.drawable.ic_hbo);
             Cursor fila = bd.rawQuery("select nombre,descripcion,precio  from planesg where codigo="+codigop+" and plat='" + plataforma + "'", null);
             if (fila.moveToFirst()) {
                 nombre_plan.setText("•\t" + fila.getString(0));
                 descripcion.setText(fila.getString(1));
                 precio = Double.parseDouble(fila.getString(2));
             }
             bd.close();
         }else if ( plataforma.equals("amazon")) {
             int codigop=Integer.parseInt(poscicion)+20;
             img.setImageResource(R.drawable.ic_amazon);
             Cursor fila = bd.rawQuery("select nombre,descripcion,precio  from planesg where codigo="+codigop+" and plat='" + plataforma + "'", null);
             if (fila.moveToFirst()) {
                 nombre_plan.setText("•\t" + fila.getString(0));
                 descripcion.setText(fila.getString(1));
                 precio = Double.parseDouble(fila.getString(2));
             }
             bd.close();
         }else{
            bd.close();
        }
         //cambio en git  (commit)
        precioe.setText(precio+" pesos");
        codigo.setText(codigoAl());
        codigoGen=codigo.getText().toString();
    }
    public String codigoAl(){
        String[] datos = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
                "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O",
                "P", "Q", "R", "S", "U", "V", "W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
        int tamaño = datos.length;
        String codigoH="";
        for(int i=0;  i<6;  i=i+1){
            int num=(int)(Math.random()*tamaño);
            codigoH=codigoH+datos[num];
        }
        return (codigoH);
    }
    public void confirmar(View v){
        String documento=doc.getText().toString();
        boolean val=false;
        for(int i=0; i<documento.length(); i++) {
            if (documento.charAt(i) == '.' || documento.charAt(i) == ',' || documento.charAt(i) == ' '|| documento.charAt(i) == '-') {
                val = true;
            }
        }
        if (documento.length()>=5 && val==false){
            AlertDialog.Builder dialogo1=new AlertDialog.Builder(confirmacion_venta.this);
            dialogo1.setTitle("importante");
            dialogo1.setMessage("¿Desea efectuar la compra?");
            dialogo1.setCancelable(false);
            dialogo1.setPositiveButton("confirmar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogo1, int i) {
                    confirmar1();
                }
            });
            dialogo1.setNegativeButton("cancelar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogo1, int i) {
                }
            });
            dialogo1.show();
        }else if(documento.equals("")){
            Toast.makeText(this, "El documento es obligatorio", Toast.LENGTH_SHORT).show();
        }else if(documento.length()<5){
            Toast.makeText(this, "El documento debe tener mas de 5 caracteres", Toast.LENGTH_SHORT).show();
        }else if(val){
            Toast.makeText(this, "Documento invalido", Toast.LENGTH_SHORT).show();
        }
    }
    public void confirmar1(){
        String documento=doc.getText().toString();
        TimeZone myTimeZone = TimeZone.getTimeZone("America/Bogota");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MMMM/dd HH:mm:ss");
        simpleDateFormat.setTimeZone(myTimeZone);
        String dateTime = simpleDateFormat.format(new Date());

        nombreVenta=nombre_plan.getText().toString();
        boolean con=false;
        AdminSQLiteOpenHelper admin= new AdminSQLiteOpenHelper(this,"administracion",null,1);
        SQLiteDatabase bd=admin.getWritableDatabase();
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("dd");
        simpleDateFormat1.setTimeZone(myTimeZone);
        String dia = simpleDateFormat1.format(new Date());
        Cursor filan= bd.rawQuery("select dia_venta,precio_ventas_dia,codigo,usuario from venta_dia where dia_venta='"+dia+"' and usuario='"+usuario+"'",null);
        if (filan.moveToFirst()){
            double contador_venta=Double.parseDouble(filan.getString(1)) ;
            contador_venta=contador_venta+precio;
            System.out.println("total hasta ahora; "+contador_venta);
            if (contador_venta>1000000){
                bd.close();
                Toast.makeText(this, "Supero el monto de ventas por dia", Toast.LENGTH_SHORT).show();
            }else{
                con=true;
                String cod=filan.getString(2);
                ContentValues nueva_venta=new ContentValues();
                nueva_venta.put("precio_ventas_dia",contador_venta);
                int can=bd.update("venta_dia",nueva_venta,"codigo="+cod,null);
                if (can==1){
                    Toast.makeText(this, "Venta exitosa", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this, "upss", Toast.LENGTH_SHORT).show();
                }
            }
        }else{
            con=true;
            ContentValues registronuevo=new ContentValues();
            registronuevo.put("dia_venta",dia);
            registronuevo.put("hora_venta",dateTime);
            registronuevo.put("precio_ventas_dia",precio);
            registronuevo.put("usuario",usuario);
            bd.insert("venta_dia",null,registronuevo);
            Toast.makeText(this, "Venta exitosa", Toast.LENGTH_SHORT).show();
        }
        if (con){
            Cursor fila= bd.rawQuery("select pin from historial where pin='"+codigoGen+"'",null);
            if(fila.moveToFirst()){
                Toast.makeText(this, "Ese pin ya existe", Toast.LENGTH_SHORT).show();
                codigo.setText(codigoAl());
                codigoGen=codigo.getText().toString();
            }else{
                Cursor datos= bd.rawQuery("select usuario,ventas from administrativos where usuario='"+usuario+"'",null);
                if (datos.moveToFirst()){
                    String user=datos.getString(0);
                    int contador_ventas=Integer.parseInt(datos.getString(1)) ;
                    System.out.println("Las ventas del usuaro son: "+contador_ventas);
                    contador_ventas=contador_ventas+1;
                    ContentValues añadir_ventas=new ContentValues();
                    añadir_ventas.put("ventas",contador_ventas);
                    int can=bd.update("administrativos",añadir_ventas,"usuario='"+usuario+"'",null);
                    System.out.println(can);
                }
                ContentValues registro=new ContentValues();
                registro.put("pin",codigoGen);
                registro.put("nombre",nombreVenta);
                registro.put("documento_cliente",documento);
                registro.put("hora_venta",dateTime);
                registro.put("precio",precio);
                registro.put("usuario",usuario);
                bd.insert("historial",null,registro);
                bd.close();
                doc.setText("");
                Intent nueva= new Intent(confirmacion_venta.this, general.class);
                nueva.putExtra("usuario",usuario);
                startActivity(nueva);
            }
        }
    }
    public void volver(View v){
        finish();
    }
}