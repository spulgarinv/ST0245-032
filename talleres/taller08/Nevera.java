/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller8_;

/**
 *
 * @author spulgarinv && jcguerrerac
 */
public class Nevera {
    
    int codigo;
    String solicitudes;
    
    public Nevera (int codigo, String solicitudes) {
        this.codigo = codigo;
        this.solicitudes = solicitudes;
    }
    
    public int getCodigo(){
        return codigo;
    }
    
    public String getSolicitudes(){
        return solicitudes;
    }
}

