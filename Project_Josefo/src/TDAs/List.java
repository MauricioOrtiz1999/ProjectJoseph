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
public interface List <E>{
    boolean addFirst(E e);
    boolean addLast(E e);
    E removeFirst();
    E removeLast();
    void add(int index, E e);
    E remove(int index);
    E get(int index);
    E set(int index, E e);
    int size();   
    boolean isEmpty();
    void clear();
    @Override
    String toString();
}