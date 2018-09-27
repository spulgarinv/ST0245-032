package taller8_;

import java.util.Stack;

/**
 * La clase Taller8 tiene la intención de
 * enfatizar en el uso de pilas y colas ya 
 * implementadas en java
 * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/util/Queue.html"> Ver más acerca de colas<a/>
 * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/util/Stack.html"> Ver más acerca de pilas <a/> 
 * @author Mauricio Toro, Andrés Páez 
 */
public class Taller8 {
/**
    * @param string es una cadena de texto que viene de este modo 3 4 5 * + o de esta manera 2 3 * 5 +
    * todo viene separado por espacios por lo que la funcion split.("") vendría muy bien para separarlos
    * Se intenta hacer el calculo por medio del metodo polaco posfijo
    * @return un entero resultado de la operación
    */
    public static int polaca  (String string){
        String[]s = string.split(" ");
        Stack <Integer> j = new Stack <Integer>();
        int cont = 0;
        for(int i=0; i<s.length; i++){
            if(!(s[i].equals("+"))&&!(s[i].equals("-"))&&!(s[i].equals("*"))&&!(s[i].equals("/"))){
                j.push(Integer.parseInt(s[i]));
            } else if (s[i].equals("+")){
                cont = j.pop() + j.pop();
                j.push(cont);
            } else if (s[i].equals("-")){
                cont = Math.abs(j.pop() - j.pop());
                j.push(cont);
            } else if (s[i].equals("*")){
                cont = j.pop() * j.pop();
                j.push(cont);
            } else if (s[i].equals("/")){
                cont = j.pop() / j.pop();
                j.push(cont);
            }
        }
        return j.pop();
    }
    
    public static void main(String[] args) {
        System.out.println(polaca("3 4 + 1 -"));
        System.out.println(polaca("3 5 * 2 +"));
        System.out.println(polaca("6 5 - 4 +"));
    }
    
}
