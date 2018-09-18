/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller7;

/**
 *
 * @author Juan Camilo Guerrero Alarcón && Santiago Pulgarin Vasquez
 */
import java.lang.IndexOutOfBoundsException; // Usar esto cuando se salga el índice
// Una lista simplemente enlazada
public class LinkedListMauricio {
    public Node first;
    public int size;
    public Node temp = first;
    public LinkedListMauricio()
    {
        size = 0;
        first = null;   
    }

    /**
     * Returns the node at the specified position in this list.
     * @param index - index of the node to return
     * @return the node at the specified position in this list
     * @throws IndexOutOfBoundsException
     */
    public Node getNode(int index) throws IndexOutOfBoundsException {
        if (index >= 0 && index < size) {
            Node temp = first;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return temp;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Returns the element at the specified position in this list.
     * @param index - index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException
     */
    public int get(int index) throws IndexOutOfBoundsException {
        temp = getNode(index);
        return temp.data;
    }

    // Retorna el tamaño actual de la lista
    public int size()
    {
        return size;
    }

    // Inserta un dato en la posición index
    public void insert(int data, int index)
    { 
        Node nuevo = new Node(data);
        if (index == 0) {            
            nuevo.next = first;
            first = nuevo;
        } else {
            Node actual = first;
            int i = 0;
            while(i < index - 1) {
                actual = actual.next;
                
                i++;
            }
            nuevo.next = actual.next;
            actual.next = nuevo;
            }
        size++;
    }

    // Borra el dato en la posición index
    public void remove(int index)
    {
       Node actual = first;
       if (index < size ){
           int i = 0;
           while(i < index - 1 ){
              actual = actual.next;
               i++;
           }
           actual.next = actual.next.next;
          
       }
       size--;
    }

    // Verifica si está un dato en la lista
    public boolean contains(int data)
    {
        Node nodoQueEstoyVisitando = first;
        while (nodoQueEstoyVisitando != null) {
            if (nodoQueEstoyVisitando.data == data){
                return true;
            }
            nodoQueEstoyVisitando = nodoQueEstoyVisitando.next;
        }
        return false;
    }

}
