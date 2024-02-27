package com.example;

public class Transferencias {
    private int valor;
    String fecha;
    String hora;
    private String destinatario;
    String categoria;

    //Constructor para los atributos
    public Transferencias(int valor, String fecha, String hora, String destinatario, String categoria){
        this.valor = valor;
        this.fecha = fecha;
        this.hora = hora;
        this.destinatario = destinatario;
        this.categoria = categoria;

    }

    //Get y Set
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }
    
    public String getFecha() {
        return fecha;
    }
    
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    public String getHora() {
        return hora;
    }
    
    public void setHora(String hora) {
        this.hora = hora;
    }
    
    public int getValor() {
        return valor;
    }
    
    public void setValor(int valor) {
        this.valor = valor;
    }

}
