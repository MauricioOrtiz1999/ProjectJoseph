

package TDAs;

import java.util.ListIterator;

/**
 *
 * @author PC
 * @param <E>
 */
public class CircularDoublyLinkedList<E> implements List<E> {
    private Node<E> last;
    private int current;    
    public CircularDoublyLinkedList(){
        last = null;
        current = 0;
    }
    public ListIterator<E> ListIterator(int indx){
        ListIterator<E> li = new ListIterator<E>(){
            Node<E> nodo=new Node<>(null);
            int iN=indx-1;
            int iP=indx+1;
            @Override
            public boolean hasNext() {
                return iN<current-1;
            }
            @Override
            public E next() {
                if(nodo.data==null){
                    nodo=last;
                    for(int i=0;i<indx;i++)
                        nodo=nodo.next;                    
                }
                nodo=nodo.next;
                iN++;
                return nodo.data; 
            }
            @Override
            public boolean hasPrevious() {
                return iP>0;
            }
            @Override
            public E previous() {
                if(nodo.data==null){
                    nodo=last.next;
                    for(int i=0;i<current-indx-1;i++)
                        nodo=nodo.previous;                    
                }
                nodo=nodo.previous;
                iP--;
                return nodo.data;
            }
            @Override
            public int nextIndex() {
                if(hasNext()){
                    Node<E> n=last;
                    for(int i=0;i<current;i++){
                        n=n.next;
                        if(nodo.data==n.data)return i+1;
                    }
                }else throw new IllegalStateException("No hay más next");
                return 0;
            }
            @Override
            public int previousIndex() {
                if(hasPrevious()){
                    Node<E> n=last;
                    for(int i=0;i<current;i++){
                        n=n.next;
                        if(nodo.data==n.data)return i-1;                        
                    }
                }else throw new IllegalStateException("No hay más previous");
                return 0;
            }
            @Override
            public void remove(){
                if(current==0 ||nodo.data==null) throw new IllegalStateException("La lista está vacia");
                Node<E> m=nodo.next;
                nodo.previous.next=m;
                m.previous=nodo.previous;
                nodo.data=null;
                nodo.next=nodo.previous=null;
                current--;
            }
            @Override
            public void set(E e) {
                if(current==0 ||nodo.data==null) throw new IllegalStateException("La lista está vacia");
                nodo.data=e;
            }
            @Override
            public void add(E e) {
                if(nodo.data==null)addFirst(e);
                Node<E> m=new Node<>(e);
                m.next=nodo.next;
                m.previous=nodo;
                nodo.next.previous=m;
                nodo.next=m;
                current++;
            }
        };
        return li;
    }
    @Override
    public void clear(){
        if(!isEmpty()){
            Node<E> n=last.next;
            for(int i=0;i<current;i++){
                Node m=n.next;
                n.data=null;
                n.previous=null;
                n.next=null;
                n=m;
            }
            last=null;
            current=0;
        }
    }
    private class Node<E>{
        private E data;
        private Node<E> next;
        private Node<E> previous;
        
        public Node(E data){
            this.data = data;
            this.next = null;
            this.previous = null;
        }       
    }
    @Override
    public boolean addFirst(E e) {
        Node<E> n = new Node<>(e);
        if(isEmpty()){
            last = n;
            last.next=last.previous= last;
        }else{
            last.next.previous=n;
            n.next=last.next;
            n.previous=last;
            last.next = n;
        }
        current++;
        return true;
    }
    @Override
    public boolean addLast(E e) {
        Node<E> n = new Node<>(e);
        if(isEmpty()){
            last = n;
            last.next=last.previous=last;
        }else{
            last.next.previous=n;
            n.next = last.next;
            n.previous=last;
            last.next = n;
            last = n;
        }
        current++;
        return true;
    }
    @Override
    public int size() {
        return current;
    }
    @Override
    public E removeLast() {
        if(isEmpty())throw new IllegalStateException("La lista está vacia");
        E result=last.data;
        if(current == 1){
            last.data = null;
            last.previous=last.next=null;
            last = null;
        }else{
            Node<E> prev = last.previous;
            prev.next = null;
            last.previous = null;
            last.next=null;
            last.data = null;
            last = prev;
        }
        current--;
        return result;
    }
    @Override
    public E removeFirst() {
        if(isEmpty()) throw new IllegalStateException("La lista está vacia");
        E result=last.next.data;
        Node<E> n=last.next;
        last.next=n.next;
        n.next.previous=last;
        n.next=null;
        n.previous=null;
        n.data=null;
        current--;
        return result;
    }
    @Override
    public void add(int index, E e) {
        if (index>=0 && index<=current && e!=null){
            if(index==current && current>0) addLast(e);
            if(index==0) addFirst(e);
            Node<E> n=last.next;
            int i=0;
            while(i<index){            
                i++;
                if(i==index){
                    Node<E> n1=new Node<>(e);               
                    n1.next=n.next;
                    n1.previous=n;
                    n.next.previous=n1;
                    n.next=n1;
                    current++;
                }
                n=n.next;
            }
        }
    }
    @Override
    public E set(int index, E e){
        if (index>=current || index<0) throw new IndexOutOfBoundsException("El indice no es valido");
        Node<E> n=last;
        for(int i=0;i<=index;i++)
            n=n.next;
        E result=n.data;
        n.data=e;
        return result;
    }
    @Override
    public boolean isEmpty() {
        return current == 0;
    }
    @Override
    public E get(int index) {
        if(index>=current) throw new IndexOutOfBoundsException("El indice no es valido");
        Node<E> n=last.next;
        for(int i=0;i<index;i++)
            n=n.next;        
        return n.data;
    }
    @Override
    public E remove(int index) {
        if(index>=current || index<0) throw new IndexOutOfBoundsException("El indice no es valido");
        E result=last.data;
        if (last.equals(last.next)){
            last.data=null;
            last=null;
        }else{
            Node<E> n=last.next;
            for(int i=0;i<index-1;i++)
                n=n.next;            
            Node<E> m=n.next;
            n.next=m.next;
            m.next.previous=n;
            m.next=null;
            m.previous=null;
            result=m.data;
            m.data=null;      
        }
        current--;
        return result;
    }    
    @Override
    public String toString(){
        if(isEmpty()) return "[]";
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(Node<E> p = last.next; p!=last; p=p.next){        
            sb.append(p.data);
            sb.append(",");
        }
        sb.append(last.data);
        sb.append("]");
        return sb.toString();
    }
}