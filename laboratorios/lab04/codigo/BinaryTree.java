
/**
 * @author jcguerrera && spulgarinv
 */

public class BinaryTree {


    // Raiz del arbol
    public Node root;

    private void recursivePrintAUX(Node node)
    {
        if (node != null)
        {
            recursivePrintAUX(node.left);
            recursivePrintAUX(node.right);
            System.out.println(node.data);
        }
    }

    public void recursivePrint() {
        recursivePrintAUX(root);
    }

    public static void dibujarArbol(BinaryTree a) {
        dibujarArbolAux(a.root);
        System.out.println("}");
    }

    public static void dibujarArbolAux(Node nodo) {
        if (nodo != null)
            //"x_\n__" -> "xo\n__";
            for(Node n: new Node[] {nodo.left, nodo.right} ){
                if (n != null)
                    System.out.println("\"" + nodo.data + "\" -> \"" + n.data + "\";");
                dibujarArbolAux(n);
            }
    }

    /**
     * Ejecicio 1.2
     *
     */

    public static void grandMother(Node r){
        if (r == null){
            System.out.println( "null" );
        }
        else{
            if(r.left == null){
                System.out.println("null");
            }else {
                if(r.left.left == null){
                    System.out.println("null");
                }
                else {
                    System.out.println(r.left.left.data);
                }
            }
        }

    }

    public Node buscar(Node nodo, String str) {
        if(nodo == null)
            return null;
        else{
            if(nodo.data.equals(str)) {
                return nodo;
            }
            Node left = buscar(nodo.left, str);
            if(left != null)
                return left;
            Node right = buscar(nodo.right, str);
            if(right != null)
                return right;
                return null;
        }
    }
    public String getGrandMothersName(String name) {
        Node gm = buscar(root, name);
        System.out.println(gm.data);
        if (gm != null) {
            gm = gm.left;
            if (gm != null) {
                gm = gm.left;
                if (gm != null) {
                    return gm.data;
                }
            }
        }
        return "";
    }

    public static void main(String[] args) {
        // Arbol Genealogico
        BinaryTree add = new BinaryTree();

        add.root = new Node("Juan Camilo ");
        add.root.left = new Node("Aura ");
        add.root.left.left = new Node("Gloria ");
        add.root.left.right = new Node("Guillermo ");
        add.root.left.left.left = new Node ("Dona ");
        add.root.left.left.right = new Node ("Pedro ");
        add.root.left.right.left = new Node("Rosana ");
        add.root.left.right.right = new Node ("Alfonso");
        add.root.right = new Node("Ernesto ");
        add.root.right.left = new Node("Alicia");
        add.root.right.right = new Node("Jesús ");

        add.recursivePrint();

        dibujarArbol(add);

    }

}
