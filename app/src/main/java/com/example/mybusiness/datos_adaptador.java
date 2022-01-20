package com.example.mybusiness;

public class datos_adaptador {
    private String nombre;
    private String hora;
    private String pin;
    private String documento;

    public datos_adaptador() {
    }
    public datos_adaptador(String nombre, String hora, String pin, String documento) {
        this.nombre = nombre;
        this.hora = hora;
        this.pin = pin;
        this.documento = documento;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getHora() {
        return hora;
    }

    public String getPin() {
        return pin;
    }

    public String getDocumento() {
        return documento;
    }
}

