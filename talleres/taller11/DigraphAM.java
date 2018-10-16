package taller11;

import java.util.ArrayList;
import taller11.Graph;
/**
 * Esta clase es una implementación de un digrafo usando matrices de adyacencia
 * 
 * @author Mauricio Toro 
 * @version 1
 */
public class DigraphAM extends Graph
{
   int[][] matriz;
   
   public DigraphAM(int size)
   {
        super(size);
        matriz = new int[size][size];
   }
   
   @Override
   public int getWeight(int source, int destination)
   {
       return matriz[source][destination];
   }
   
    /**
     *
     * @param source
     * @param destination
     * @param weight
     */
    @Override
   public void addArc(int source, int destination, int weight)
   {
       matriz[source][destination] = weight;
   }
  
   @Override
   public ArrayList<Integer> getSuccessors(int vertex)
   {
       ArrayList<Integer> sucesoresOVecinosAdyacentes;
       for(int i = 0; i < size; i++){
           if (matriz[vertex][i] != 0){
               sucesoresOVecinosAdyacentes
           }
           
       }
   }
}