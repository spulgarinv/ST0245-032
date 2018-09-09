
import java.util.Arrays;

/**
 * @author Juan Camilo Guerrero Alarcon && Santiago Pulgarin Vasquez
 */
public class Punto1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        for (int i = 10000; i <= 200000; i = i + 10000){
            int[] a = new int[i];
            for (int j = 0; j < i; j++ ){
                a[j] = j;
            }
            long start = System.currentTimeMillis();
            InsertionSort(a);

            long fin = System.currentTimeMillis();
            System.out.println(fin-start);
        }
        for (int i = 100000; i <= 2000000; i = i + 100000){
            int[] a = new int[i];
            for (int j = 0; j < i; j++ ){
                a[j] = j;
            }
            long start = System.currentTimeMillis();
            mergeSort(a);
            long fin = System.currentTimeMillis();
            System.out.println(fin-start);
        }

    }


    public static int[] InsertionSort(int[] a){
        int temp;
        for (int i = 1; i < a.length; i++) {
            for(int j = i ; j > 0 ; j--){
                if(a[j] < a[j-1]){
                    temp = a[j];
                    a[j] = a[j-1];
                    a[j-1] = temp;
                }
            }
        }
        return a;
    }

    /*
    Title : Merge sort
    Autor : Tinker
    date  : 2012
    version : 1.0
    Availability : https://stackoverflow.com
     */
    static void mergeSort(int[] A) {
        if (A.length > 1) {
            int q = A.length/2;
            int[] leftArray = Arrays.copyOfRange(A, 0, q);
            int[] rightArray = Arrays.copyOfRange(A,q+1,A.length);
            mergeSort(leftArray);
            mergeSort(rightArray);
            A = merge(leftArray,rightArray);
        }
    }

    static int[] merge(int[] l, int[] r) {
        int totElem = l.length + r.length;
        int[] a = new int[totElem];
        int i,li,ri;
        i = li = ri = 0;
        while ( i < totElem) {
            if ((li < l.length) && (ri<r.length)) {
                if (l[li] < r[ri]) {
                    a[i] = l[li];
                    i++;
                    li++;
                }
                else {
                    a[i] = r[ri];
                    i++;
                    ri++;
                }
            }
            else {
                if (li >= l.length) {
                    while (ri < r.length){
                        a[i] = r[ri];
                        i++;
                        ri++;
                    }
                }
                if (ri >= r.length){
                    while (li < l.length) {
                        a[i] = l[li];
                        li++;
                        i++;
                    }
                }
            }
        }
        return a;

    }

}
