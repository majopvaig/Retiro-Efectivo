/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mvc;

import dtos.ReciboDTO;

/**
 *
 * @author maria
 */
public interface IModeloRetiro {
    
    void suscribir(IObserverRetiro subs);
    
    String getNombreUsuario();
    
    String getSaldoUsuario();
    
    String getRetiro();
    
    String getComision();
    
    String getTotalDescontar();
    
    ReciboDTO getRecibo();
    
    String getError();
}
