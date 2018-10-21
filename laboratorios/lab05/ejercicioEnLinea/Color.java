import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author spulgarinv && jcguerrera
 */
public class Color {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nod = sc.nextInt();
        while (nod != 0) {
            DigraphAM g = new DigraphAM(nod);
            int arcos = sc.nextInt();
            for (int i = 0; i < arcos; i++) {
                int arc1 = sc.nextInt();
                int arc2 = sc.nextInt();
                g.addArc(arc1, arc2, nod);
            }
            System.out.println(isBicolorable(g));
            nod = sc.nextInt();
        }
    }

    public static String isBicolorable(DigraphAM g) {
        int n = g.size;
        int color[] = new int[n];
        for (int i = 0; i < n; i++) {
            color[i] = -1;
        }
        color[0] = 1;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {

                if (g.getWeight(j, i) != 0 && color[i] == -1) {

                    color[i] = 1 - color[j];

                } else if (g.getWeight(j, i) != 0 && color[j] == color[i]) {
                    return "NOT BICOLORABLE";
                }
            }
        }

        return "BICOLORABLE";
    }
}
