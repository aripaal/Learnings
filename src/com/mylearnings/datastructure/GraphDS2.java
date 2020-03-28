package com.mylearnings.datastructure;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphDS2 {
    public static class Vertex{
        int data;
        boolean visited;
        List<Vertex> adjList=new LinkedList<>();

        public Vertex(int data) {
            this.data = data;
        }

        public void setVisited() {
            this.visited = false;
        }

        public boolean isVisited() {
            return visited;
        }



        public void addEdge(Vertex v){
            this.adjList.add(v);
        }

        @Override
        public String toString() {
            return "Vertex{" +
                    "data=" + data +
                    '}';
        }
    }

    public static void BFS(Vertex root){
        Queue<Vertex> queue=new LinkedList<>();
        root.setVisited();

        queue.add(root);
        while(!queue.isEmpty()){
            Vertex v = queue.poll();
            System.out.printf(v+" ");
            Iterator<Vertex> it = v.adjList.iterator();
            while(it.hasNext()){
                Vertex vtx = it.next();
                if(!vtx.isVisited())
                    queue.add(vtx);
            }

        }

    }
    public static void main(String... args){
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Vertex v4 = new Vertex(4);
        Vertex v5 = new Vertex(5);

        v1.addEdge(v2);
        v1.addEdge(v4);
        v4.addEdge(v5);
        v2.addEdge(v3);

        BFS(v1);

    }


}
