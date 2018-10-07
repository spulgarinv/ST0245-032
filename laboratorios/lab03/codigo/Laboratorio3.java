/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorio3;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author spulgarinv && jcguerrera
 */
public class Laboratorio3 {

    public static void SmartInsertPunto (ArrayList <Integer> miLista,  int numeroAInsertar){
        for (int i = 0; i < miLista.size(); i++  ) {
            if(miLista.get(i) != numeroAInsertar){
                miLista.add(numeroAInsertar);
            } else {
                break;
            }
            }
        }
    
    public static void SmartInsertPunto (LinkedList <Integer> miLista,  int numeroAInsertar){
        for (int i = 0; i < miLista.size(); i++  ) {
            if(miLista.get(i) != numeroAInsertar){
                miLista.add(numeroAInsertar);
            } else {
                break;
            }
            }
        }
    
    public static void pivote (ArrayList <Integer> miLista2) {
        int suma = 0;
        
        for (int i = 0; i < miLista2.size(); i++){
            suma += i;
        }
        
        int mejorPosicionPivote = suma/miLista2.size();
        
        System.out.println(mejorPosicionPivote);
    }
    
    public static void pivote (LinkedList <Integer> miLista2) {
        int suma = 0;
        
        for (int i = 0; i < miLista2.size(); i++){
            suma += i;
        }
        
        int mejorPosicionPivote = suma/miLista2.size();
        
        System.out.println(mejorPosicionPivote);
    }
    
    public static void neveras (ArrayList <Nevera> nevera, ArrayList <Pedidos> pedidos) {
      for(int i = 0; i < pedidos.size(); i++){
          Pedidos pedido1 = pedidos.get(i);
          for(int k = 0; k < pedido1.obtenerExsistencias(); k++){
              if (nevera.size() > 0) {
                  nevera.remove(0);
              }
          }
          
      }  
    }
    
    public static void neveras (LinkedList <Nevera> nevera, ArrayList <Pedidos> pedidos) {
      for(int i = 0; i < pedidos.size(); i++){
          Pedidos pedido1 = pedidos.get(i);
          for(int k = 0; k < pedido1.obtenerExsistencias(); k++){
              if (nevera.size() > 0) {
                  nevera.remove(0);
              }
          }
          
      }  
    }
    
     public static void main(String[] args) {
        
    }

}

