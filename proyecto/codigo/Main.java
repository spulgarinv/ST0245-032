import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {



        public static void main(String[]args) throws IOException{
            int numeroDeAbejas = 10;

            long startTime = System.currentTimeMillis();
            AgregarAbejas add = new AgregarAbejas();

            add.agregarAbejas(10);

            long estimatedTime = System.currentTimeMillis() - startTime;
            System.out.println("El algoritmo tomo un tiempo de: "+estimatedTime+" ms");

        }
}

