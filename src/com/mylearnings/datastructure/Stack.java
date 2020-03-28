package com.mylearnings.datastructure;

/**
 * Created by ronnie on 3/29/17.
 */
public class Stack<T> {
    Node<T> top,bottom;
    int size=0;

    public int getSize() {
        return size;
    }

    public Node<T> getTop() {
        return top;
    }

    public Node<T> getBottom() {
        return bottom;
    }

    public void push(T value){
        ++size;
        if(top==null){
            top=bottom=new Node<>(value);
        }else{
            Node<T> temp=new Node<>(value);
            temp.next=top;
            top=temp;
        }
    }

    public T pop(){
        if(size==0)
            return null;
        --size;
        T value=top.value;
        if(top==bottom){

            top=bottom=null;

        }else{
            top=top.next;
        }


        return value;

    }

    public static class Node<T>{
        T value;
        Node<T> next;

        public Node(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }
    }


}
