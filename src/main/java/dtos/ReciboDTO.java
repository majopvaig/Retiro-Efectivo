/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

/**
 *
 * @author maria
 */
public class ReciboDTO {
    
    private String cuenta;
    private String nombre;
    private Float cantRetirada;
    private Float comision;
    private Float totalDesc;

    public ReciboDTO(String cuenta, String nombre, Float cantRetirada, Float comision, Float totalDesc) {
        this.cuenta = cuenta;
        this.nombre = nombre;
        this.cantRetirada = cantRetirada;
        this.comision = comision;
        this.totalDesc = totalDesc;
    }

    public String getCuenta() {
        return cuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public Float getCantRetirada() {
        return cantRetirada;
    }

    public Float getComision() {
        return comision;
    }

    public Float getTotalDesc() {
        return totalDesc;
    }
    
}
