package com.example;

public class RegistroUsuario {
    
    String nombre;
    private String direccion;
    private String numeroIdentificacion;
    private String correo;
    private String clave; 
 
    //Construtor para los atributos 
    public RegistroUsuario(String nombre, String direccion, String numeroIdentificacion, String correo, String clave){
        this.nombre = nombre;
        this.direccion = direccion;
        this.numeroIdentificacion = numeroIdentificacion;
        this.correo = correo;
        this.clave = clave;
        
    }

    
    //Get y Set 
    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }
    
}