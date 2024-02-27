package com.example;



public class CrearCuenta {
    public int saldo;
    //private int numeroAleatorio = (int) (Math.random() * 1000000000);
    //private String numeroFinal = String.valueOf(numeroAleatorio);
    public String numero;

    //Constructor para los atributos
    public CrearCuenta(int saldo , String numero){
        this.saldo = saldo;
        this.numero = numero;
    }
   
    //get y set
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
    
}
