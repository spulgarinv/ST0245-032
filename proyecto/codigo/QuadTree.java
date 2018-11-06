    import java.io.IOException;
    import java.io.PrintWriter;
    import java.util.ArrayList;
    import java.util.LinkedList;
    import java.util.List;

    public class QuadTree {

        static LinkedList<Abeja> beeA = new LinkedList<>(); //List auxiliar que guarda las abejas para ser comparadas con el resto de abejas

        final int MAX_LEVEL = 4;//variable que define el limite de abejas por cuadrante
        int level = 0;
        static int col =0;

        List<Abeja> beeB;

        // cuadrantes de la frontera
        QuadTree northWest = null;
        QuadTree northEast = null;
        QuadTree southWest = null;
        QuadTree southEast = null;
        Boundry boundry;
        Boolean split;

        QuadTree(int level, Boundry boundry) {
            this.level = level;
            beeB = new ArrayList<Abeja>();
            this.boundry = boundry;
        }

        void split() {
            int xOffset = this.boundry.getxMin()
                    + (this.boundry.getxMax() - this.boundry.getxMin()) / 2;
            int yOffset = this.boundry.getyMin()
                    + (this.boundry.getyMax() - this.boundry.getyMin()) / 2;


            northWest = new QuadTree(this.level + 1, new Boundry(
                    this.boundry.getxMin(), this.boundry.getyMin(), xOffset,
                    yOffset));
            northEast = new QuadTree(this.level + 1, new Boundry(xOffset,
                    this.boundry.getyMin(), xOffset, yOffset));
            southWest = new QuadTree(this.level + 1, new Boundry(
                    this.boundry.getxMin(), xOffset, xOffset,
                    this.boundry.getyMax()));
            southEast = new QuadTree(this.level + 1, new Boundry(xOffset, yOffset,
                    this.boundry.getxMax(), this.boundry.getyMax()));
            split=true;
        }

        void insert(double x, double y, int val) {



            if (!this.boundry.inRange(x, y)) {
                return;
            }

            Abeja bee = new Abeja(x, y, val);
            if (beeB.size() < MAX_LEVEL) {
                beeB.add(bee);
                return;
            }
            // Exceeded the capacity so split it in FOUR
            if (northWest == null) {
                split();
            }

            // Check coordinates belongs to which partition
            if (this.northWest.boundry.inRange(x, y))
                this.northWest.insert(x, y,val);
            else if (this.northEast.boundry.inRange(x, y))
                this.northEast.insert(x, y,val);
            else if (this.southWest.boundry.inRange(x, y))
                this.southWest.insert(x, y,val);
            else if (this.southEast.boundry.inRange(x, y))
                this.southEast.insert(x, y,val);
        }

        public static  boolean colision(Abeja abeja1, Abeja abeja2) {
            double x = abeja1.getX();
            double y = abeja1.getY();
            double x2 = abeja2.getX();
            double y2 = abeja2.getY();


            double diffX = x - x2;
            double diffY = y - y2;

            double distancia=(int)Math.sqrt(Math.pow(diffX,2) + Math.pow(diffY,2) );
            boolean colision = false;

            if(distancia <= 100) {
                colision = true;
            }

            return colision;

        }

        public void escribir(int numeroDeAbejas){

            final String nombreDelArchivo = "respuestaConjuntoDeDatosCon"+numeroDeAbejas+"abejas.txt";
            try {
                PrintWriter escritor = new PrintWriter(nombreDelArchivo, "UTF-8");
                for(int i=0; i < beeA.size();i++){
                    for(int p = i + 1; p < beeA.size(); p++) {
                        Abeja a = beeA.get(i);
                        Abeja b = beeA.get(p);

                        if(colision(a,b)) {
                            escritor.println(" La Abeja " +a.val+" Coliciona con: " +b.val);

                            col++;
                        }
                    }
                }
                escritor.close();
            }
            catch(IOException ioe) {
                System.out.println("Error escribiendo el archivo de salida");
            }
        }

        /**
         * @param tree Arbol que recibe para recorrrerlo
         *
         */
        public void comprobarColisiones(QuadTree tree) {
            if (tree == null)
                return ;

            for (Abeja bee : tree.beeB) {
                beeA.add(bee);
            }
            comprobarColisiones(tree.northWest);
            comprobarColisiones(tree.northEast);
            comprobarColisiones(tree.southWest);
            comprobarColisiones(tree.southEast);

        }
    }