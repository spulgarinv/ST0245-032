import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.lang.Math;
import java.util.ArrayList;

/**
 * @author Juan Camilo Guerrero && Santiago Pulgarin
 */

class PrevencionColisionesPrueba {
    static ArrayList<Abeja>[][][] bees;
    static int tamX = 0;
    static int tamY = 0;
    static int tamZ = 0;
    static double minX = 0;
    static double minY= 0;
    static double minZ= 0;
    static long totalTiempo;
    static long tiempoInicio;

    /**
     * Metodo para leer un archivo de abejas y almacenarlas en un arreglo de tipo Abeja
     *
     * @param  numeroDeAbejas  El numero de abejas a leer
     * @return un arreglo de Abejas donde cada elemento representa las coordenadas de una abeja
     */
    public static Abeja[] leerArchivo(int numeroDeAbejas){
        tiempoInicio=System.currentTimeMillis();
        final String nombreDelArchivo = "ConjuntoDeDatosCon"+numeroDeAbejas+"abejas.txt";
        Abeja[] arregloDeAbejas = new Abeja[numeroDeAbejas];

        try {
            BufferedReader br = new BufferedReader(new FileReader(nombreDelArchivo));
            String lineaActual = br.readLine();
            lineaActual = br.readLine(); // Descarta la primera linea
            int index = 0;
            while (lineaActual != null){ // Mientras no llegue al fin del archivo
                String [] cadenaParticionada = lineaActual.split(",");
                Abeja abeja = new Abeja(Double.parseDouble(cadenaParticionada[0]),
                        Double.parseDouble(cadenaParticionada[1]),
                        Double.parseDouble(cadenaParticionada[2]));
                arregloDeAbejas[index++] = abeja;
                lineaActual = br.readLine();

            }

        }
        catch(IOException ioe) {
            System.out.println("Error leyendo el archivo de entrada");
        }
        totalTiempo=System.currentTimeMillis()-tiempoInicio;
        System.out.println("Tiempo leer archivo: "+totalTiempo+"ms");
        return arregloDeAbejas;
    }

    public static void guardarArchivo(int numeroDeAbejas){
        tiempoInicio=System.currentTimeMillis();
        final String nombreDelArchivo = "respuestaConjuntoDeDatosCon"+numeroDeAbejas+"abejas.txt";
        try {
            PrintWriter escritor = new PrintWriter(nombreDelArchivo, "UTF-8");
            for (int i = 0; i < tamX; i++) {
                for(int j = 0; j < tamY; j++){
                    for(int h = 0; h < tamZ; h++){
                        if(bees[i][j][h] != null ){
                            ArrayList<Abeja> add = bees[i][j][h];
                            if(add.size() > 1) {
                                while(add == null){
                                    Abeja abeja = add.get(i);
                                    abeja = add.get(j);
                                    abeja = add.get(h);
                                }
                            }
                        }
                    }
                }
            }
            escritor.close();
        }
        catch(IOException ioe) {
            System.out.println("Error escribiendo el archivo de salida");
        }
        totalTiempo=System.currentTimeMillis()-tiempoInicio;
        System.out.println("Tiempo guardar archivo: "+totalTiempo+"ms");
    }


    public static void añadirAbejas (Abeja[] arregloDeAbejas){
        tiempoInicio=System.currentTimeMillis();
        minX = arregloDeAbejas[0].getX();
        minY = arregloDeAbejas[0].getY();
        minZ = arregloDeAbejas[0].getZ();
        double maxX= arregloDeAbejas[0].getX();
        double maxY= arregloDeAbejas[0].getY();
        double maxZ= arregloDeAbejas[0].getZ();

        for (int i=0;i<=arregloDeAbejas.length-1;i++){
            if (arregloDeAbejas[i].getX()<=minX){
                minX=arregloDeAbejas[i].getX();
            }
            if (arregloDeAbejas[i].getX()>=maxX){
                maxX=arregloDeAbejas[i].getX();
            }
            if (arregloDeAbejas[i].getY()<=minY){
                minY=arregloDeAbejas[i].getY();
            }
            if (arregloDeAbejas[i].getY()>=maxY){
                maxY=arregloDeAbejas[i].getY();
            }
            if (arregloDeAbejas[i].getZ()<=minZ){
                minZ=arregloDeAbejas[i].getZ();
            }
            if (arregloDeAbejas[i].getZ()>=maxZ){
                maxZ=arregloDeAbejas[i].getZ();
            }
        }

        double tamañoX= ((maxX-minX)*100000/70);
        double tamañoY= ((maxY-minY)*100000/70);
        double tamañoZ= ((maxZ-minZ)/70);

        tamX = Math.abs((int)tamañoX);
        tamY = Math.abs((int)tamañoY);
        tamZ = Math.abs((int)tamañoZ);

        bees = new ArrayList[tamX][tamY][tamZ];
        totalTiempo=System.currentTimeMillis()-tiempoInicio;
        System.out.println(" tamaño: "+totalTiempo+"ms");
    }


    public static void detectarColisiones(Abeja[] arregloDeAbejas){
        tiempoInicio=System.currentTimeMillis();
        Abeja aux = null;
        int x = 0;
        int y = 0;
        int z = 0;
        for (int i = 0; i < arregloDeAbejas.length ; ++i)
        {
            aux = arregloDeAbejas[i];
            x = (int) ((aux.getX()-minX)*100000  / 70);
            y = (int)((aux.getY()-minY)*100000 / 70);
            z = (int)((aux.getZ() -minZ)  / 70);

            if(x >0) {
                x--;
            }
            if(y>0) {
                y--;
            }
            if(z >0) {
                z--;
            }
            if(bees[x][y][z] == null) {
                ArrayList<Abeja> n= new ArrayList<>();
                n.add(aux);
                bees[x][y][z] = n;
            }else {
                bees[x][y][z].add(aux);
            }
        }
        totalTiempo=System.currentTimeMillis()-tiempoInicio;
        System.out.println(" detectar colision: "+totalTiempo+" ms");
    }



    public static void main(String[] args){
        // Recibir el numero de abejas como parametro
        final int numeroDeAbejas = args.length == 0 ? 1000000 :  Integer.parseInt(args[0]);
        // Leer el archivo con las coordenadas de las abejas
        Abeja[] arregloDeAbejas = leerArchivo(numeroDeAbejas);
        // Prevenir las colisiones revisando todas con todas
        long startTime = System.currentTimeMillis();
        añadirAbejas(arregloDeAbejas);
        detectarColisiones(arregloDeAbejas);
        // Guardar en un archivo las abejas con riesgo de colision
        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("El algoritmo tomo un tiempo de: "+estimatedTime+" ms");
        //guardarArchivo(numeroDeAbejas);
        //Calcular Memoria

        int dataSize = 1024*1024;
        Runtime runtime=Runtime.getRuntime();

        System.out.println("Memoria: " + runtime.totalMemory()/dataSize);
        //System.out.println("Memoria: "+runtime.maxMemory()/dataSize);
    }
}
