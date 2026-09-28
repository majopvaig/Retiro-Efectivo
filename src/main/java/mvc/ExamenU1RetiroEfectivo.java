/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package mvc;

/**
 *
 * @author maria
 */
public class ExamenU1RetiroEfectivo {

    public static void main(String[] args) {
        
        ModeloRetiro modelo = new ModeloRetiro();
        ControlRetiro control = new ControlRetiro(modelo);
        PanelEstadoCuenta pnlE = new PanelEstadoCuenta();
        PanelRecibo pnlR = new PanelRecibo();
        VistaRetiro vista = new VistaRetiro(control, modelo, pnlR, pnlE);   
    }
}
