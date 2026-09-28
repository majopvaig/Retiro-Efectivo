/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc;

import dominio.Cuenta;
import dominio.Recibo;
import dominio.Retiro;
import dtos.ReciboDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author maria
 */
public class ModeloRetiro implements IModeloRetiro {

    private Retiro retiro;
    private Cuenta cuenta;
    private Recibo recibo;
    private List<Cuenta> cuentas = new ArrayList<>();
    private String error;
    private List<IObserverRetiro> subs = new ArrayList<>();
    
    private void cargarCuentas(){
        Cuenta c1 = new Cuenta("Eiji Okumura", "0812020312071985", 5417.02f);
        cuentas.add(c1);
        Cuenta c2 = new Cuenta("Ash Lynx", "1985120702030812", 126.34f);
        cuentas.add(c2);
        Cuenta c3 = new Cuenta("Suguru Geto", "1234567891011123", 103245.71f);
        cuentas.add(c3);
        Cuenta c4 = new Cuenta("Satoru Gojo", "6666666666666666", 541328.16f);
        cuentas.add(c4);
    }
    
    public ModeloRetiro(){
        cargarCuentas();
    }
    
    @Override
    public void suscribir(IObserverRetiro sub) {
        subs.add(sub);
    }

    @Override
    public String getNombreUsuario() {
        if (cuenta == null) return null;
        return cuenta.getNombre();
    }

    @Override
    public String getSaldoUsuario() {
        if (cuenta == null) return null;
        return String.valueOf(cuenta.getSaldo());
    }

    @Override
    public String getRetiro() {
        if (retiro == null) return null;
        return String.valueOf(retiro.getCant());
    }

    @Override
    public String getComision() {
        if (retiro == null) return null;
        return String.valueOf(retiro.getComision());
    }

    @Override
    public String getTotalDescontar() {
        if (retiro == null) return null;
        return String.valueOf(retiro.getCant()+retiro.getComision());
    }

    @Override
    public ReciboDTO getRecibo() {
        if (recibo == null) return null;
        return new ReciboDTO(recibo.getCuenta(), recibo.getNombre(), recibo.getCantRetirada(), recibo.getComision(), recibo.getTotalDesc());
    }
    
    public void autenticarUsuario(String num) {
        if(num == null){
            error = "Ingrese un número de cuenta!";
            notificarSubs();
            return;
        }
        String noCuenta = num.replaceAll("\\s+", "");
        if (noCuenta.isEmpty() || noCuenta.isBlank()) {
            error = "Ingrese un número de cuenta!";
        } else if (!noCuenta.matches("^\\d{16}$")) {
            error = "Número de cuenta con formato inválido.";
        } else {
            for (Cuenta c : cuentas) {
                if (noCuenta.equals(c.getNumeroCuenta())) {
                    cuenta = c;
                    retiro = null;
                    error = "";
                    break;
                }
            }
            if (cuenta == null) {
                error = "No se pudo verificar dicha cuenta!";
            }
        }
        notificarSubs();
    }
    
    public void validarMontoRetirar(Float monto){
        Double comision = monto*0.10;
        Float suma = monto + comision.floatValue();
        if(cuenta.getSaldo()-suma < 0){
            error = "La cuenta no cuenta con el saldo para realizar dicho retiro. Pruebe con una cantidad más pequeña!";
        } else {
            error = "";
            retiro = new Retiro(monto, comision.floatValue());
        }
        notificarSubs();
    }
    
    public void retirar() {
        if (!descontar()) {
            error = "No se pudo descontar el dinero de la cuenta! Intente en otra ocasión.";
            recibo = null;
        } else {
            error = "";
            String c = "**** **** **** " + cuenta.getNumeroCuenta().substring(cuenta.getNumeroCuenta().length() - 4);
            recibo = new Recibo(c, cuenta.getNombre(), retiro.getCant(), retiro.getComision(), retiro.getCant() + retiro.getComision());
        }
        notificarSubs();
    }
    
    private boolean descontar(){
        Float saldoActual = cuenta.getSaldo();
        cuenta.setSaldo(cuenta.getSaldo()-(retiro.getCant()+retiro.getComision()));
        for(Cuenta c : cuentas){
            if(c.getNumeroCuenta().equals(cuenta.getNumeroCuenta())){
                c.setSaldo(cuenta.getSaldo());
            }
        }
        return saldoActual > cuenta.getSaldo();
    }
    
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
