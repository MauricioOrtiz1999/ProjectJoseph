

package TDAs;

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

    @Override
    public void clear(){
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
    
    /*public Node<E> getNode(int index) {
        Node<E> nodoEncontrado = null;
        if (!isEmpty()) {
            if (index == 0) {
                nodoEncontrado = first;
            } else {
                if (index > 0 && index < effectiveSize) {
                    Node<E> aux = first;
                    for (int i = 0; i < effectiveSize - 1; i++) {
                        if (i == index - 1) {
                            Node<E> mod = aux.getNext();
                            nodoEncontrado = mod;
                        } else {
                            aux = aux.getNext();
                        }
                    }
                }
            }
        }
        return nodoEncontrado;
        
    }*/
    
    
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