/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc;

/**
 *
 * @author maria
 */
public class ControlRetiro {
    
    private ModeloRetiro modelo;
    
    public void autenticarUsuario(String num){
        modelo.autenticarUsuario(num);
    }
    
    public void validarMontoRetirar(Float monto){
        modelo.validarMontoRetirar(monto);
    }
    
    public void retirar(){
        modelo.retirar();
    }
}
