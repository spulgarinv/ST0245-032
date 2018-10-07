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
public class Nevera {
    
    int codigo;
    String descripcion;
    
    public Nevera(int codigo, String descripcion){
        this.codigo = codigo;
        this.descripcion = descripcion;
    }
    
    public int obtenerCodigo (){
        return codigo;
    }
    
    public void cambiarCodigo (int nuevoCodigo){
        codigo = nuevoCodigo;
    }
    
    public String obtenerDescripcion (){
        return descripcion;
    }
    
    public void cambiarDescripcion (String nuevaDescripcion){
        descripcion = nuevaDescripcion;
    }
}
