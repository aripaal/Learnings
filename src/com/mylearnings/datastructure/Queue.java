package com.mylearnings.datastructure;

/**
 * Created by ronnie on 3/29/17.
 */
public class Queue<T> {

    Node<T> head,tail;
    int size=0;

    public int getSize() {
        return size;
    }
    public Node<T> getFirst(){
        return head;
    }
    public Node<T> getLast(){
        return tail;
    }


    public void enQueue(T value){
        if(head==null)
            head=tail=new Node<>(value);
        else{
            tail.next=new Node<>(value);
            tail=tail.next;
        }
        ++size;

    }
    public T deQueue(){
        if(size==0)
            return null;
        --size;
        T value=head.value;
        if(head==tail){
            head=tail=null;

        }else
            head=head.next;
        return value;
    }


    public static class Node<T>{
        T value;
        Node<T> next;

        public T getValue() {
            return value;
        }

        public Node(T value) {
            this.value = value;
        }
    }



}
