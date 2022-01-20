package com.example.mybusiness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private final int TIEMPO = 1500;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent ac=new Intent(MainActivity.this,Login.class);
                startActivity(ac);
            }
        },TIEMPO);
    }
    public void login(View v){
        Intent ac=new Intent(this,Login.class);
        startActivity(ac);
    }
    public void registrar(View v){
        Intent ac=new Intent(this,Register.class);
        startActivity(ac);
    }


}