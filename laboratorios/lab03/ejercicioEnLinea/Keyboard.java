import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author Juan Camilo Guerrero && Sanriago Pulgarin
 */

public class Keyboard {

    static LinkedList<Character> inv = new LinkedList<>();

    /*
    El metodo ordenar se encarga de encontrar los "[]" para asi ir ordenando la cadena de acuerdo al ejercicio
    y a su vez va añadiendo datos a la lista
     */
    public static void ordenar (String str){

        int cont = 0;
        boolean first = false;
        boolean last = false;

        for(int i = 0; i < str.length();i++ ){
            if (str.charAt(i) == '['){
                first = true;
                last = false;
                continue;
            }else if (str.charAt(i) == ']'){
                first = false;
                last = true;
                continue;
            }

            if(first == true){
                inv.add(cont, str.charAt(i));
                cont++;
            }else{
                inv.add(str.charAt(i));
            }
        }
    }

    /*
    writeList simplemente se encarga de mostrar los elementos que la componen y posteriormente vacia la lista
     */
    public static void writeList(){
        System.out.println("Salida del programa: ");
        Iterator showList = inv.iterator();

        while(showList.hasNext()){
            System.out.print(showList.next().toString());

        }
        System.out.println();
        inv.clear();
    }

    public static void main(String[] args) {
        ordenar("This_is_a_[Beiju]_text");
        writeList();
        ordenar("asd[fgh[jkl");
        writeList();

    }
}
