package com.mylearnings.challenges;


import com.mylearnings.datastructure.LinkedList;
import com.mylearnings.datastructure.Stack;

/**
 * Created by ronnie on 5/6/17.
 */
public class Add2Nos {

LinkedList<Integer> l1 = new LinkedList<>();
    LinkedList<Integer> l2 = new LinkedList<>();
    Add2Nos(){
        l1.addNode(4);
        l1.addNode(5);
        l1.addNode(6);

        l2.addNode(3);
        l2.addNode(5);
        l2.addNode(5);

    }

    public void addLists(){
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        Stack<Integer> res = new Stack<>();
        LinkedList<Integer> sumList = new LinkedList<>();
        LinkedList.Node<Integer> cur1 = l1.getFirst();
        LinkedList.Node<Integer> cur2 = l2.getFirst();
        while(cur1!=null && cur2!=null){
            s1.push(cur1.getValue());
            s2.push(cur2.getValue());
            cur1=cur1.getNext();
            cur2=cur2.getNext();
        }
        int carry=0;
        while(s1.getSize()!=0){
            int sum=s1.pop()+s2.pop()+carry;
            carry=sum/10;
            res.push(sum%10);

        }

        while(res.getSize()!=0){
            sumList.addNode(res.pop());
        }

        sumList.forEach(System.out::println);

    }


    public static void main(String... args){
        Add2Nos add2Nos=new Add2Nos();
        add2Nos.addLists();

    }
}
