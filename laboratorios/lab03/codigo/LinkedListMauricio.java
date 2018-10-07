/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorio3;

/**
 *
 * @author spulgarinv && jcguerrera
 */
public class LinkedListMauricio {
    public Node first;
    public int size;
    public Node temp = first;
    
    public LinkedListMauricio()
    {
        size = 0;
        first = null;   
    }

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

    public int get(int index) throws IndexOutOfBoundsException {
        temp = getNode(index);
        return temp.data;
    }

    public int size()
    {
        return size;
    }

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