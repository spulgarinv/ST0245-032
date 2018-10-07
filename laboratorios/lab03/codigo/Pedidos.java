/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorio3;

/**
 *
 * @author spulgarinv && jcguerrera
 */
public class Pedidos {
    String nombreTienda;
    int existencias;
    
    public Pedidos (String nombreTienda, int existencias){
        this.nombreTienda = nombreTienda;
        this.existencias = existencias;
    }
    
    public String obtenerNombreTienda () {
        return nombreTienda;
    }
    
    public void cambiarNombreTienda (String nuevoNombreTienda) {
       nombreTienda = nuevoNombreTienda;
    }
    
    public int obtenerExsistencias (){
        return existencias;
    }
    
    public void cambiatExistencias (int nuevasExistencias){
        existencias = nuevasExistencias;
    }
}
