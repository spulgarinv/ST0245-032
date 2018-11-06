
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class AgregarAbejas {


    public void agregarAbejas(int numeroDeAbejas) throws IOException {

        QuadTree add = new QuadTree(1, new Boundry(0, 0, 1000, 1000));

        FileReader f = null;
        int i = 1;
        try {
            f = new FileReader("ConjuntoDeDatosCon"+numeroDeAbejas+"abejas.txt");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        BufferedReader b = new BufferedReader(f);

        try {
            String cadena = b.readLine();

            while ((cadena = b.readLine()) != null) {
                String[] tamaño = cadena.split(",");
                double x = Double.parseDouble(tamaño[0]);
                double y = Double.parseDouble(tamaño[1]);
                double dX = (double) (x + 75.50);
                int xAux = (int) (dX * 10000);
                int xt = (1000 + xAux);
                double dY = (double) (y - 6.30);
                int yAux = (int) (dY * 10000);
                int yt = ((yAux - 700) * -1);

                add.insert(xt, yt, i);

                i++;

            }

        } catch (NumberFormatException | IOException e) {

            e.printStackTrace();
        }
        try {
            b.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        add.comprobarColisiones(add);
        //tree.guardarAbeja();
        add.escribir(numeroDeAbejas);
    }
}
