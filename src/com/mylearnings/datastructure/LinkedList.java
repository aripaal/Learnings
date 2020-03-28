package com.mylearnings.datastructure;

import java.util.Comparator;
import java.util.Iterator;
import java.util.function.Consumer;

/**
 * Created by ronnie on 3/27/17.
 */
public class LinkedList<T> implements Iterable<T>{
    Node<T> head,tail;
    int size=0;

    public void addNode(T value){
        if(head==null && tail==null)
            head=tail=new Node<>(value);
        else {
            tail.next = new Node<>(value);
            tail=tail.next;
        }
        ++size;
    }

    public int getSize() {
        return size;
    }

    public Node<T> getFirst() {
        return head;
    }

    public Node<T> getLast() {
        return tail;
    }

    public void removeDuplicates(){
        Node<T> cursor,fastCursor;
        cursor=head;

        while(cursor!=null){
            fastCursor=cursor;
            while(fastCursor.getNext()!=null){
                if(cursor.getValue()==fastCursor.getNext().getValue()){
                    fastCursor.setNext(fastCursor.next.next);
                }
                fastCursor=fastCursor.getNext();
            }
            cursor=cursor.getNext();
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator<>(head);
    }

    public static class ListIterator<T> implements Iterator<T>{
        Node<T> cursor;

        public ListIterator(Node<T> cursor) {
            this.cursor = cursor;
        }

        @Override
        public boolean hasNext() {
            return cursor.getNext()!=null;
        }

        @Override
        public T next() {
            T value=cursor.value;
            cursor=cursor.getNext();
            return value;
        }
    }

    public static class Node<T>{
      T value;

        public T getValue() {
            return value;
        }

        public Node(T value) {
          this.value = value;
      }
      Node<T> next;

      public Node<T> getNext() {
          return next;
      }

      public void setNext(Node<T> next) {
          this.next = next;
      }
  }
}