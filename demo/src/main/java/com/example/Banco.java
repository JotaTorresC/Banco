package com.example;

import java.util.List;
import java.util.ArrayList;

public class Banco {
    
    private List<RegistroUsuario> usuarios;
    private List<Transferencias> transferencias;
    private List<CrearCuenta> cuentas;
    
    
    //Listas de usuarios tranferencias y cuentas
    public Banco(){
        usuarios = new ArrayList<>();
        transferencias = new ArrayList<>();
        cuentas = new ArrayList<>();
   
    }

    //Metodo para guardar los usuarios en la lista
    public void agregarUsuario(RegistroUsuario usuario){
        usuarios.add(usuario);

    }

    //Metodo para actualizar datos
    public void actualizarDatosUsuario(String nombreUsuario, String nuevaDireccion, String nuevoCorreo, String nuevaClave) {
        // Buscar el usuario por nombre
        for (RegistroUsuario usuario : usuarios) {
            if (usuario.getNombre().equals(nombreUsuario)) {
                // Actualizar la dirección usando el método set
                usuario.setDireccion(nuevaDireccion);
                usuario.setClave(nuevaClave);
                usuario.setCorreo(nuevoCorreo);
                System.out.println("Datos actualizados para el usuario " + nombreUsuario + " ahora su direccion es " + nuevaDireccion + " su correo es " +  nuevoCorreo + " y su clave es " + nuevaClave);
                return; // Salir del bucle una vez actualizado
            }
        }
        System.out.println("Usuario no encontrado: " + nombreUsuario);
    }

    //Metodo para borrar usuario datos
    public void borrarUsuario(String nombreUsuario) {
        // Buscar el usuario por nombre
        for (RegistroUsuario usuario : usuarios) {
            if (usuario.getNombre().equals(nombreUsuario)) {
                //Eliminar los datos de la lista usuarios
                usuarios.remove(usuario);
                System.out.println("el usuario de " + nombreUsuario + " a sido eliminado");
                return; // Salir del bucle una vez eliminado
            }
        }
        System.out.println("Usuario no encontrado: " + nombreUsuario);
    }

    //Metodo para guardar las cuentas en la lista
    public void agregarCuenta(CrearCuenta cuenta){
        cuentas.add(cuenta);
    }

    //Metodo para verificar si el numero de la cuenta ya existe
    public void verificarCuenta(String numeroPrueba) {
        // Buscar la cuenta por nombre
        for (CrearCuenta cuenta : cuentas) {
            if (cuenta.getNumero().equals(numeroPrueba)) {
                System.out.println("no se a podido registrar la cuenta porfavor vuelve a intentarlo");
                return;
            }
        }
        System.out.println("su cuenta se a registrado exitosamente");
    }

    //Metodo para guardar las tranferencias en la lista
    public void guardarTranferencia(Transferencias transferencia){
        transferencias.add(transferencia);
    
    }

    //Metodo para realizar la transferencia
    public void realizarTransaccion(int Envio, String Remitente, String Emisor, String Fecha, String Categoria, String Hora){
        for (CrearCuenta cuenta : cuentas){
            if(cuenta.getNumero().equals(Remitente)){
                if ((cuenta.getSaldo() - 200) >= Envio){
                    cuenta.setSaldo(cuenta.getSaldo() - Envio - 200);
                    System.out.println("saldo restante " + cuenta.getSaldo());
                    for(Transferencias transferencia : transferencias){
                        transferencia.setDestinatario(Emisor);
                        transferencia.setFecha(Fecha);
                        transferencia.setCategoria(Categoria);
                        transferencia.setHora(Hora);
                        System.out.println("los datos de la tranferencia se han guardado");
                        return;
                    }
                    
                }               
            }
        }
        System.out.println("no tienes suficiente dinero");
    }

    //Metodo para colsultar saldo
    public void  colsultaSaldo(String Cedula, String Clave){
        for (RegistroUsuario usuario : usuarios){
            if (usuario.getNumeroIdentificacion().equals(Cedula)){
                if (usuario.getClave().equals(Clave)){
                    for (CrearCuenta cuenta : cuentas){
                        System.out.println("su saldo es de " + cuenta.getSaldo());
                        for(Transferencias transferencia : transferencias){
                            System.out.println(transferencia);
                            return;
                        }

                    }
                }             
            }   
        } 
        System.out.println("Usp algo salio mal porfavor vuelve a intentarlo");  
    }


}
