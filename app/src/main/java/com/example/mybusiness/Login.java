package com.example.mybusiness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Login extends AppCompatActivity {
    private EditText et1,et2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        et1= findViewById(R.id.etEmail);
        et2= findViewById(R.id.etPassword);
    }
    public void volver(View v){
       Intent nuev= new Intent(this, MainActivity.class);
       startActivity(nuev);
        finish();
    }
    public void registrar(View v){
      Intent ac=  new Intent(this, Register.class);
      startActivity(ac);
    }
    public void logearse(View v){
        AdminSQLiteOpenHelper admin= new AdminSQLiteOpenHelper(this,"administracion",null,1);
        SQLiteDatabase bd=admin.getWritableDatabase();
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        String email=et1.getText().toString();
        String clave=et2.getText().toString();

        Matcher mather = pattern.matcher(email);
        if ( email.equals("")||clave.equals("")){
            Toast.makeText(this, "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show();
        }else if(mather.find()==false){
            Toast.makeText(this, "Email incorrecto", Toast.LENGTH_SHORT).show();
        }else if(clave.length()<6) {
            Toast.makeText(this, "la contraseña debe tener 6 caracteres", Toast.LENGTH_SHORT).show();
        }else{
            Cursor fila= bd.rawQuery("select * from administrativos where email='"+email+"' and clave='"+clave+"'",null);
            if (fila.moveToFirst()){
                String user=fila.getString(0);
                Intent ac= new Intent(this, general.class);
                ac.putExtra("usuario", user);
                et1.setText("");
                et2.setText("");
                SharedPreferences preferencias=getSharedPreferences("datos",Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=preferencias.edit();
                editor.putString("clave",clave);
                editor.commit();
                startActivity(ac);
                finish();
            }else{
                Toast.makeText(this, "Datos incorrectos", Toast.LENGTH_SHORT).show();
            }
            bd.close();;

        }
    }
    public void recordar(View v){
        SharedPreferences prefe=getSharedPreferences("datos", Context.MODE_PRIVATE);
        et2.setText(prefe.getString("clave",""));
    }
}