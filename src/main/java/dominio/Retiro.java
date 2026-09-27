/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author maria
 */
public class Retiro {
    
    private Float cant;
    private Float comision;

    public Retiro() {}

    public Retiro(Float cant, Float comision) {
        this.cant = cant;
        this.comision = comision;
    }

    public Float getCant() {
        return cant;
    }

    public void setCant(Float cant) {
        this.cant = cant;
    }

    public Float getComision() {
        return comision;
    }

    public void setComision(Float comision) {
        this.comision = comision;
    }
    
}
