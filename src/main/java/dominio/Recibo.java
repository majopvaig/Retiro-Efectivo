/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author maria
 */
public class Recibo {
    
    private String cuenta;
    private String nombre;
    private Float cantRetirada;
    private Float comision;
    private Float totalDesc;

    public Recibo() {}

    public Recibo(String cuenta, String nombre, Float cantRetirada, Float comision, Float totalDesc) {
        this.cuenta = cuenta;
        this.nombre = nombre;
        this.cantRetirada = cantRetirada;
        this.comision = comision;
        this.totalDesc = totalDesc;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Float getCantRetirada() {
        return cantRetirada;
    }

    public void setCantRetirada(Float cantRetirada) {
        this.cantRetirada = cantRetirada;
    }

    public Float getComision() {
        return comision;
    }

    public void setComision(Float comision) {
        this.comision = comision;
    }

    public Float getTotalDesc() {
        return totalDesc;
    }

    public void setTotalDesc(Float totalDesc) {
        this.totalDesc = totalDesc;
    }    
    
}
