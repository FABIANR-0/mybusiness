package com.example.mybusiness;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminSQLiteOpenHelper  extends SQLiteOpenHelper {
    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table administrativos(usuario text primary key,email text,clave text,ventas integer)");
        db.execSQL("create table planesg( codigo integer primary key,descripcion text,nombre text,precio real,plat text)");
        db.execSQL("create table historial(pin text primary key,nombre text,documento_cliente text,hora_venta text,precio real,usuario text)");
        db.execSQL("create table venta_dia(codigo integer primary key autoincrement,dia_venta text,hora_venta,precio_ventas_dia real,usuario text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
