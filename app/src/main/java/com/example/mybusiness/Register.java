package com.example.mybusiness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Register extends AppCompatActivity {
    private EditText et1,et2,et3,et4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        et1= findViewById(R.id.etUser);
        et2= findViewById(R.id.etEmail);
        et3= findViewById(R.id.etPassword);
        et4= findViewById(R.id.etPassword2);
    }
    public void volver(View v){
        finish();
    }

    public void registrar(View v){
        AdminSQLiteOpenHelper admin= new AdminSQLiteOpenHelper(this,"administracion",null,1);
        SQLiteDatabase bd=admin.getWritableDatabase();
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        String usuario=et1.getText().toString().trim();
        String email=et2.getText().toString().trim();
        String clave=et3.getText().toString();
        String clave2=et4.getText().toString();
        Cursor fila= bd.rawQuery("select usuario from administrativos where usuario='"+usuario+"' or email='"+email+"'",null);
        Matcher mather = pattern.matcher(email);
        boolean val=false;
        for(int i=0; i<clave.length(); i++){
            if (clave.charAt(i)=='.'   ||  clave.charAt(i)==',' || clave.charAt(i)==' ') {
                val=true;
            }
        }
        if (usuario.equals("")||email.equals("")||clave.equals("")||clave2.equals("")){
            Toast.makeText(this, "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show();
        }else if(clave.equals(clave2)==false){
            Toast.makeText(this, "contraseña diferente", Toast.LENGTH_SHORT).show();
        }else if(mather.find()==false){
            et2.setError("");
            Toast.makeText(this, "Email incorrecto", Toast.LENGTH_SHORT).show();
        }else if(clave.length()<6) {
            Toast.makeText(this, "la contraseña debe tener 6 caracteres", Toast.LENGTH_SHORT).show();
        }else if(val) {
            Toast.makeText(this, "contraseña invalida", Toast.LENGTH_SHORT).show();
        }else if(fila.moveToFirst()){
            Toast.makeText(this, "usuario y/o correo ya estan registrados", Toast.LENGTH_SHORT).show();
            bd.close();
        }else{
            ContentValues registro=new ContentValues();
            registro.put("usuario",usuario);
            registro.put("email",email);
            registro.put("clave",clave);
            registro.put("ventas",0);
            bd.insert("administrativos",null,registro);
            bd.close();
            Intent ac= new Intent(this, general.class);
            ac.putExtra("usuario", usuario);
            ac.putExtra("ventas", 0+"");
            startActivity(ac);
            et1.setText("");
            et2.setText("");
            et3.setText("");
            et4.setText("");
        }
    }
}