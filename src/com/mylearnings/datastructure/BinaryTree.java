package com.mylearnings.datastructure;

import org.omg.CORBA.MARSHAL;

import java.util.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Map;
import java.util.Stack;
/**
 * Created by ronnie on 3/29/17.
 */
public class BinaryTree<T extends Comparable<T>> {

    Node<T> root;
    public void add(T value){
        if(root==null){
            root=new Node<>(value);
            return;
        }
        add(root,value);
    }
    private void add(Node<T> cursor, T value){
        if(value.compareTo(cursor.value)<0){
            if(cursor.left==null)
                cursor.left=new Node<>(value);
            else
                add(cursor.left,value);
        }else{
            
            if(cursor.right==null)
                cursor.right=new Node<>(value);
            else
                add(cursor.right,value);
        }
    }

    public void inOrderIt(List<T> view){
        if(root==null)
            return;
        inOrderIt(view,root);
    }

    private void inOrderIt(List<T> view, Node<T> cursor){
      Stack<Node<T>> stack = new Stack<>();
      int k=0;
      Node<T> n=cursor;
      while(!stack.empty() || n!=null){
          if(n!=null){
              stack.push(n);
              n=n.left;
          }
          else{
              Node<T> temp = stack.pop();
              ++k;
              if(k==3)
                  System.out.println("3rd smallest ->"+temp.value);
              view.add(temp.value);
              n=temp.right;
          }
      }


    }
    public  int longestConsecutive(Node<T> cursor) {
        Queue<Node<T>> queue = new LinkedList<>();
        int max = 0;
        queue.offer(cursor);
        int left = 0, right = 0;
        while (!queue.isEmpty()) {
            Node<T> temp = queue.poll();

            if (temp.left != null) {
                if (temp.left.value.compareTo(temp.value) == -1) {
                    ++left;
                    max = Math.max(max, left);
                } else
                    left = 0;

                queue.offer(temp.left);
            }

            if (temp.right != null) {
                if (temp.right.value.compareTo(temp.value) == 1) {
                    ++right;
                    max = Math.max(max, right);
                } else
                    right = 0;
                queue.offer(temp.right);
            }
        }
        return max;
    }



    public void inOrder(List<T> view){
        if(root==null)
            return;
        inOrder(view,root);
    }

    private void inOrder(List<T> view, Node<T> cursor){
        if(cursor.left!=null)
            inOrder(view,cursor.left);
        view.add(cursor.value);
        if(cursor.right!=null)
            inOrder(view,cursor.right);
    }
    public void preOrderIt(List<T> view){
        if(root==null)
            return;
        preOrderIt(view,root);
    }
    public int calcSize(Node n){
        if(n==null)
            return 0;
        if(n.left==null & n.right==null)
            return 1;

        int sum=1+calcSize(n.left)+calcSize(n.right);
        return sum;

    }
    private void preOrderIt(List<T> view, Node<T> cursor){

        Stack<Node<T>> stack = new Stack<>();
        stack.push(cursor);

        while(!stack.empty()){
            Node<T> temp = stack.pop();
            view.add(temp.value);

            if(temp.right!=null)
                stack.push(temp.right);

            if(temp.left!=null)
                stack.push(temp.left);
        }

    }
    public void preOrder(List<T> view){
        if(root==null)
            return;
        preOrder(view,root);
    }
    private void preOrder(List<T> view,Node<T> cursor){
        view.add(cursor.value);
        if(cursor.left!=null)
            preOrder(view,cursor.left);
        if(cursor.right!=null)
            preOrder(view,cursor.right);
    }
    int funct(Node n,int h){
        if(n==null)
            return 0;

        if(n.left==null & n.right==null)
            return h;

        int lheight=funct(n.left,h+1);
        int rheight=funct(n.right,h+1);

        return Math.max(lheight,rheight);
    }
    public void levelOrder(List<T> view){
        levelOrder(view,root);
    }
    private void levelOrder(List<T> view,Node<T> cursor){

        Queue<Node<T>> queue= new LinkedList<>();
        queue.offer(cursor);
        while(!queue.isEmpty()){
            Node<T> temp = queue.poll();
            view.add(temp.value);

            if(temp.left!=null)
                queue.offer(temp.left);

            if(temp.right!=null)
                queue.offer(temp.right);

        }

    }
    public void levelOrderRec(List<T> view){
        view.add(root.value);
        levelOrderRec(view,root);
    }
    private void levelOrderRec(List<T> view, Node<T> cursor){
        if(cursor.left!=null)
            view.add(cursor.left.value);
        if(cursor.right!=null)
            view.add(cursor.right.value);

        if(cursor.left!=null)
            levelOrderRec(view,cursor.left);
        if(cursor.right!=null)
            levelOrderRec(view,cursor.right);
    }
    public T findSmallestElement(){

        T min = root.value;
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){

            Node<T> temp = queue.poll();
            if(temp.value.compareTo(min)<0)
                min=temp.value;

            if(temp.left!=null)
                queue.add(temp.left);

            if(temp.right!=null)
                queue.add(temp.right);


        }
        return min;

    }

    public void levelOrderMap(){

        Queue<Node> queue = new LinkedList<>();
        Queue<Node> next = new LinkedList<>();
        Map<Integer,List<T>> map = new HashMap<>();
        List<T> inputList = new LinkedList<>();
        Integer level=0;
        queue.offer(root);
        while(!queue.isEmpty()){
            Node<T> node=queue.poll();
            inputList.add(node.value);
            if(node.left!=null)
                next.offer(node.left);
            if(node.right!=null)
                next.offer(node.right);

            if(queue.isEmpty()){
                queue=next;
                next=new LinkedList<>();
                map.put(++level,inputList);
                inputList=new LinkedList<T>();
            }
        }

        System.out.println(map);
    }

    public boolean isBalanced(Node<T> node){
        if (node==null)
            return true;
        int lh=height(node.left);
        int rh=height(node.right);

        return (Math.abs(lh-rh) <=1
                && isBalanced(node.left)
                && isBalanced(node.right)
                );

    }

    public List<List<T>> levelOrderIterative(Node<T> current){

        List<List<T>> myList = new LinkedList<>();
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(current);
        myList.add(Arrays.asList(current.value));

        while(!queue.isEmpty()){
            Node<T> temp = queue.poll();
            List<T> tempList = new LinkedList<>();

            if(temp.left!=null){
                queue.add(temp.left);
                tempList.add(temp.left.value);
            }

            if(temp.right!=null){
                queue.add(temp.right);
                tempList.add(temp.right.value);
            }
            myList.add(tempList);
        }

        return myList;
    }


    private int height(Node<T> node){
        if(node==null)
            return 0;

        return 1+ Math.max(height(node.left),height(node.right));

    }
    public static class Node<T>{
        T value;
        Node<T> left,right;

        public Node(T value) {
            this.value = value;
        }


    }

}
