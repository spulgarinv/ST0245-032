/**
* La clase UnaTablaDeHash, es un plantilla para crear nuestra propia estructura hash
* Dentro de sus características esta que tiene un string como llave (key) y un entero
* como valor (value)
* @author Mauricio Toro, Andres Paez
* @version 1
*/
import java.util.ArrayList;
import java.util.LinkedList;
import javafx.util.Pair;
public class UnaTablaDeHash
{
  //NO SUBRAYAR, POR FAVOR QUITEN EL MOUSE DESPUES DE COPIAR.
   /*
   * Utilizamos array por simplicidad sin embargo el uso de este no permite manejar coliciones
   * de manera eficiente, por lo cual esta primera versión de hash no implementa colisiones, esta
   * característica se implementará posteriormente.
   */
   private ArrayList<LinkedList<Pair<String,Integer>>> tabla;

   private int size;
   /**
   * Este método define el array utilizado con 10 posiciones de manera que tenemos un límite de 10 elementos
   * 
     * @param size
   */
   public UnaTablaDeHash(int size){
       int[] tabla = new int[size];
       this.size=size;
   }

   /**
   * @param k es la llave del elemento que servirá como referencia al buscar
   * Este método se utiliza para darle una posicion dentro de la tabla, donde el %10 asegura que solo
   * se utilicen digitos de 0 a 10.
   */
   private int funcionHash(String k){
       //return ((int) k.charAt(0)) % size;
       int suma = 0;
       for(int i = 0; i < k.length(); i++)
         suma += ((int) k.charAt(i)) * i * (int) Math.pow(2,31-i);
       return suma % size;
   }

   /**
   * @param k es la llave del elemento que servirá como referencia al buscar
   * Este método se utiliza para obtener el elmento con la clave k, se enlaza con funcionHash
   */
   public int get(String k){
       int laFuncionHashDeK =  funcionHash(k);
       return tabla.get();
   }

   /**
   * @param k es la llave del elemento que servirá como referencia al buscar posteriormente
   * @param v es el valor asociado a la llave k
   * Este método se utiliza para agregar un nuevo elemento
   */
   public void put(String k, int v){
         int laFuncionHashDeK =  funcionHash(k);
         tabla[laFuncionHashDeK] = v;
   }
}
