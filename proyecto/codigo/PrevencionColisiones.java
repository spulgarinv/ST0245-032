import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.IOException;
import javafx.geometry.Point3D;
import java.util.ArrayList;
import java.lang.Math;
/**
 * Implementacion de un algoritmo para prevenir Colisiones
 * Estructura de datos utilizada: Arreglos
 * Complejidad: Peor Caso O(n al cubo) y Mejor caso O(n al cuadrado)
 *
 * @author Mauricio Toro
 * @version 1
 */
public class PrevencionColisiones
{
    /**
    * Metodo para aproximar la distancia entre dos abejas roboticas
    *
    * @param  abeja1  la primera abeja
    * @param  abeja2  la segunda abeja
    * @return la distancia aproximada entre las dos abejas, aproximando 1 grado como 111111 metros
    */
    public static double distancia(Point3D abeja1, Point3D abeja2){
        return Math.sqrt(  Math.pow((abeja1.getX() - abeja2.getX())*111111,2) +     //Constante*n
                           Math.pow((abeja1.getY() - abeja2.getY())*111111,2) +    //Constante*n
                           Math.pow(abeja1.getZ() - abeja2.getZ(),2)              //Constante*n
                        );
    }

    /**
    * Metodo para leer un archivo de abejas y almacenarlas en un arreglo de puntos en 3D
    *
    * @param  numeroDeAbejas  El numero de abejas a leer
    * @return un arreglo de puntos 3D donde cada elemento representa las coordenadas de una abeja
    */
    public static Point3D[] leerArchivo(int numeroDeAbejas){
          final String nombreDelArchivo = "ConjuntoDeDatosCon"+numeroDeAbejas+"abejas.txt"; //n*Constante
          Point3D[] arregloDeAbejas = new Point3D[numeroDeAbejas]; //Constante
          try {            
            BufferedReader br = new BufferedReader(new FileReader(nombreDelArchivo)); //Constante
            String lineaActual = br.readLine();   //Constante
            lineaActual = br.readLine(); // Constante
            int index = 0; //Constante
            while (lineaActual != null){ //Constante
                String [] cadenaParticionada = lineaActual.split(","); //Constante
                Point3D abeja = new Point3D(Double.parseDouble(cadenaParticionada[0]),
                                            Double.parseDouble(cadenaParticionada[1]),
                                            Double.parseDouble(cadenaParticionada[2])); //Constante*n
                arregloDeAbejas[index++] = abeja; //Constante
                lineaActual = br.readLine(); //Constante
            }
          }
          catch(IOException ioe) {
              System.out.println("Error leyendo el archivo de entrada"); //Constante
          }
          return arregloDeAbejas; //Constante
    }
    
    /**
    * Algoritmo para prevenir colisiones (genera muchas respuestas repetidas)
    *
    * @param  arregloDeAbejas  Un arreglo con coordenadas de las abejas
    * @return una lista definida con arreglos con las abejas que tienen riesgo de colision
    */
    public static ArrayList<Point3D> detectarColisiones(Point3D[] arregloDeAbejas){
          ArrayList<Point3D> abejasConRiesgoDeColision = new ArrayList(); //Constante
          for (int i = 0; i < arregloDeAbejas.length ; ++i) //Constante + T(n+1)*Constante
              for(int j = i+1; j < arregloDeAbejas.length; ++j) //(Constante + T(n+1)*Constante)*n
                if (distancia(arregloDeAbejas[i], arregloDeAbejas[j]) <= 100){ //Constante*n^2
                   abejasConRiesgoDeColision.add(arregloDeAbejas[i]); //Constante*n
                   abejasConRiesgoDeColision.add(arregloDeAbejas[j]);//Constante*n
                }
          return abejasConRiesgoDeColision; //Constante
    }
        
    /**
    * Metodo para escribir un archivo con la respuesta
    *
    * @param  abejasConRiesgoDeColision  Lista definida con arreglos con las abejas con riesgo de colision
    * @param  numeroDeAbejas  Numero de abejas del conjunto de datos original
    */
    public static void guardarArchivo(ArrayList<Point3D> abejasConRiesgoDeColision, int numeroDeAbejas){
          final String nombreDelArchivo = "respuestaConjuntoDeDatosCon"+numeroDeAbejas+"abejas.txt";   //Constante
          try { 
             PrintWriter escritor = new PrintWriter(nombreDelArchivo, "UTF-8"); //Constante
             for (Point3D abeja : abejasConRiesgoDeColision)  //Constante + T(n+1)*Constante
                escritor.println(abeja.getX()+","+abeja.getY()+","+abeja.getZ()); // Constante*n
             escritor.close(); //Constante*n
          }
          catch(IOException ioe) {
              System.out.println("Error escribiendo el archivo de salida"); //Constante
          }  
    }
    
    public static void main(String[] args){
          // Recibir el numero de abejas como parametro
          final int numeroDeAbejas = args.length == 0 ? 100000 : Integer.parseInt(args[0]); //Constante
          // Leer el archivo con las coordenadas de las abejas
          Point3D[] arregloDeAbejas = leerArchivo(numeroDeAbejas); //Constante
          // Prevenir las colisiones revisando todas con todas
          long startTime = System.currentTimeMillis(); //Constante
          ArrayList<Point3D> abejasConRiesgoDeColision = detectarColisiones(arregloDeAbejas); //Constante
          // Guardar en un archivo las abejas con riesgo de colision   
          long estimatedTime = System.currentTimeMillis() - startTime; //Constante
          System.out.println("El algoritmo tomo un tiempo de: "+estimatedTime+" ms"); //Constante
          guardarArchivo(abejasConRiesgoDeColision, numeroDeAbejas); //Constante
        
   }
    }
