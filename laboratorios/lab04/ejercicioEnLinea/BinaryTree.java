package laboratorio4;

import java.util.Scanner;

/**
 *
 * @author spulgarinv && jcguerrera
 */
public class BinaryTree {
	
    public Node root;
        
    public void insertar(int n) {
        root = new Node (n);
        insertarAux(root, n);       
    }
    
    private void insertarAux(Node node, int n) {
       
        if (n < node.data) {
            if (node.left == null) {
                node.left = new Node(n);
            }
            else {
                insertarAux(node.left, n);
            }
        }
        if (n > node.data) {
            if (node.right == null) {
                node.right = new Node(n);
            }else {
	    	insertarAux(node.right,n);
	    }
        }
    }
    
    private void ImprimirEnPosOrden (Node node) {
        if (node != null) {
            ImprimirEnPosOrden(node.left);
            ImprimirEnPosOrden(node.right);
            System.out.println(node.data);
        }
    }
    
    private static void main(String[] args) {
        BinaryTree arbolBinario = new BinaryTree();
        Scanner console = new Scanner(System.in);
        int data = console.nextInt();
        while (data != -1){
            arbolBinario.insertar(data);
            data = console.nextInt();
            
        }
        System.out.println();
        arbolBinario.ImprimirEnPosOrden(arbolBinario.root);
    }
}
