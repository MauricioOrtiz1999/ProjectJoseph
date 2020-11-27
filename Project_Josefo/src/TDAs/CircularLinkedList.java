/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDAs;

/**
 *
 * @param <E>
 */
public class CircularLinkedList<E> implements List<E>{
    private NodeCircularList<E> last;
    private int current;
    public CircularLinkedList(){
        last = null;
        current = 0;
    }
    private class NodeCircularList<E>{
        private E data;
        private NodeCircularList<E> next;        
        public NodeCircularList(E data){
            this.data = data;
            this.next = null;
        }
    }
    @Override
    public boolean addFirst(E e) {
        NodeCircularList<E> n = new NodeCircularList<>(e);
        if(isEmpty()){
            last = n;
            last.next = last;
        }else{
            n.next=last.next;
            last.next = n;            
        }
        current++;
        return true;
    }
    @Override
    public boolean addLast(E e) {
        NodeCircularList<E> n = new NodeCircularList<>(e);
        if(isEmpty()){
            last = n;
            last.next = last;
        }else{
            n.next = last.next;
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
    public E removeLast(){
        if(isEmpty()) throw new IllegalStateException("La lista está vacia");
        E result=last.data;
        if (last.equals(last.next))
            last=null;
        else{
            NodeCircularList<E> n=last;
            for(int i=0;i<current-1;i++)
                n=n.next;            
            n.next=last.next;
            last.next=null;
            last.data=null;
            last=n;
        }
        current--;
        return result;
    }
    @Override
    public E removeFirst(){
        if(isEmpty()) throw new IllegalStateException("La lista está vacia");
        E result=last.next.data;
        NodeCircularList<E> n=last.next;
        last.next=n.next;
        n.next=null;
        n.data=null;
        current--;
        return result;
    }
    @Override
    public void add(int index, E e) {
        if(index>=0 && index<=current && e!=null){
            if(index==current) addLast(e);
            if(index==0) addFirst(e);
            NodeCircularList<E> n=last.next;
            int i=0;
            while(i<index){
                i++;
                if(i==index){
                    NodeCircularList<E> n1=new NodeCircularList<>(e);
                    n1.next=n.next;
                    n.next=n1;
                    current++;
                }else
                    n=n.next;
            }
        }
    }
    @Override
    public E set(int index, E e){
        if (index>=current || index<0) throw new IndexOutOfBoundsException("El indice no es valido");               
        NodeCircularList<E> n=last;
        for(int i=0;i<=index;i++)
            n=n.next;
        E result=n.data;
        n.data=e;
        return result;     
    }
    @Override
    public boolean isEmpty() {
        return last == null;
    }
    @Override
    public E get(int index) {
        if(index>=current || index<0) throw new IndexOutOfBoundsException("El indice no es valido");
        NodeCircularList<E> n=last.next;
        for(int i=0;i<index;i++)
            n=n.next;        
        return n.data;
    }
    @Override
    public E remove(int index){
        if(index>=current || index<0) throw new IndexOutOfBoundsException("El indice no es valido");
        E result=last.data;
        if (index==current-1)
            removeLast();
        else{
            NodeCircularList<E> n=last;
            for(int i=0;i<index;i++)
                n=n.next;
            NodeCircularList<E> m=n.next;
            result=m.data;
            n.next=m.next;
            m.next=null;
            m.data=null;            
        }
        current--;
        return result;
    }
    @Override
    public void clear(){
        NodeCircularList<E> n=last.next;
        for(int i=0;i<current;i++){
            NodeCircularList m=n.next;
            n.data=null;
            n.next=null;
            n=m;
        }
        last=null;
        current=0;
    }
    @Override
    public String toString(){
        if(current==0) return "[]";
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        NodeCircularList<E> m=last.next;
        for(int i=0;i<current-1;i++){
            sb.append(m.data);
            sb.append(",");
            m=m.next;
        }    
        sb.append(last.data);
        sb.append("]");
        return sb.toString();
    }
}