/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc;

import dominio.Cuenta;
import dominio.Recibo;
import dominio.Retiro;
import dtos.ReciboDTO;
import java.util.List;

/**
 *
 * @author maria
 */
public class ModeloRetiro implements IModeloRetiro {

    private Retiro retiro;
    private Cuenta cuenta;
    private Recibo recibo;
    private List<Cuenta> cuentas;
    private String error;
    private List<IObserverRetiro> subs;
    
    @Override
    public void suscribir(IObserverRetiro sub) {
        subs.add(sub);
    }

    @Override
    public String getNombreUsuario() {
        return cuenta.getNombre();
    }

    @Override
    public String getSaldoUsuario() {
        return String.valueOf(cuenta.getSaldo());
    }

    @Override
    public String getRetiro() {
        return String.valueOf(retiro.getCant());
    }

    @Override
    public String getComision() {
        return String.valueOf(retiro.getComision());
    }

    @Override
    public String getTotalDescontar() {
        return String.valueOf(retiro.getCant()+retiro.getComision());
    }

    @Override
    public ReciboDTO getRecibo() {
        return new ReciboDTO(recibo.getCuenta(), recibo.getNombre(), recibo.getCantRetirada(), recibo.getComision(), recibo.getTotalDesc());
    }
    
    public void autenticarUsuario(String num){
        for (Cuenta c : cuentas){
            if(num.equals(c.getNumeroCuenta())){
                cuenta = c;
            }
        }
        if(cuenta == null){
            error = "No se pudo verificar dicha cuenta!";
        }
        notificarSubs();
    }
    
    public void validarMontoRetirar(Float monto){
        Double comision = monto*0.10;
        Float suma = monto + comision.floatValue();
        if(cuenta.getSaldo()-suma < 0){
            error = "La cuenta no cuenta con el saldo para realizar dicho retiro. Pruebe con una cantidad más pequeña!";
        } else {
            retiro = new Retiro(monto, comision.floatValue());
        }
        notificarSubs();
    }
    
    public void retirar(){
        if(!descontar()){
            error = "No se pudo descontar el dinero de la cuenta! Intente en otra ocasión.";
            notificarSubs();
        }
        String c = "**** **** **** " + cuenta.getNumeroCuenta().substring(cuenta.getNumeroCuenta().length() - 4);
        recibo = new Recibo(c, cuenta.getNombre(), retiro.getCant(), retiro.getComision(), retiro.getCant()+retiro.getComision());
        notificarSubs();
    }
    
    private boolean descontar(){
        Float saldoActual = cuenta.getSaldo();
        cuenta.setSaldo(cuenta.getSaldo()-(retiro.getCant()+retiro.getComision()));
        return saldoActual > cuenta.getSaldo();
    }
    
    //private Recibo generarRecibo(){}
    
    private void notificarSubs(){
        for(IObserverRetiro s : subs){
            s.update(this);
        }
    }

    @Override
    public String getError() {
        return this.error;
    }
}
