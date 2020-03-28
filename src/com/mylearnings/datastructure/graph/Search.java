package com.mylearnings.datastructure.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Search {

    public static class Vertex{
        int data;
        List<Vertex> adjList;
        boolean visited;
        boolean beingVisited;

        public Vertex(int data) {
            this.data = data;
            adjList=new LinkedList<>();
        }
        public void addEdge(Vertex v){
            this.adjList.add(v);
        }

        public void setVisited() {
            this.visited = true;
        }

        public boolean isVisited() {
            return visited;
        }

        @Override
        public String toString() {
            return ""+data;
        }
    }

    public static void BFS(Vertex src){
        src.setVisited();
        Queue<Vertex> queue= new LinkedList<>();
        queue.offer(src);

        while(!queue.isEmpty()){
            Vertex v = queue.poll();
            System.out.print(v+" ");
            Iterator<Vertex> it = v.adjList.iterator();
            while(it.hasNext()){
                Vertex vtx = it.next();
                if(!vtx.isVisited()){
                    queue.offer(vtx);
                }
            }

        }

    }

    public static void DFS(Vertex src){
        src.setVisited();
        System.out.print(src+" ");
        src.beingVisited=true;
        Iterator<Vertex> it = src.adjList.iterator();
        while(it.hasNext()){
            Vertex v = it.next();
            if(!v.isVisited())
                DFS(v);
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
        System.out.println();
        DFS(v1);
    }


}
