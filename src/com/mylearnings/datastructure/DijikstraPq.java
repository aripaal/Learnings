package com.mylearnings.datastructure;

import java.util.*;
import java.util.LinkedList;

public class DijikstraPq {

    public static class Edge{
        int weight;
        Vertex end;

        public Edge(Vertex end,int weight) {
            this.weight = weight;
            this.end = end;
        }
    }
    static class Vertex implements Comparable<Vertex>{
        String name;
        List<Edge> adjList;
        Vertex predecessor;
        int distance=Integer.MAX_VALUE;

        public Vertex(String name) {
            this.name = name;
            adjList=new LinkedList<>();
        }
        public void addNeighbor(Edge e){
            this.adjList.add(e);
        }

        @Override
        public int compareTo(Vertex o) {
            return this.distance-o.distance;
        }
        public String toString(){
            return name;
        }
    }

    public void solve(Vertex src){
        src.distance=0;

        PriorityQueue<Vertex> queue=new PriorityQueue<>();
        queue.add(src);

        while(!queue.isEmpty()){
            Vertex v = queue.poll();


            Iterator<Edge> it = v.adjList.iterator();
            while(it.hasNext()){
                Edge current = it.next();
                int tempDist = v.distance+current.weight;
                if(tempDist<current.end.distance){
                    queue.remove(current.end);
                    current.end.distance=tempDist;
                    current.end.predecessor=v;
                    queue.add(current.end);
                }


            }
        }
    }


    public static void main(String... args){
        Vertex v0 = new Vertex("A");
        Vertex v1 = new Vertex("B");
        Vertex v2 = new Vertex("C");

        v0.addNeighbor(new Edge(v1,1));
        v0.addNeighbor(new Edge(v2,1));
        v1.addNeighbor(new Edge(v2,1));

        DijikstraPq dijikstraPq=new DijikstraPq();
        dijikstraPq.solve(v0);
        System.out.println(dijikstraPq.printSolution(v2));


    }

    private List<Vertex> printSolution(Vertex target) {
        List<Vertex> v=new LinkedList<>();
        for(Vertex from=target;from!=null;from=from.predecessor){
            v.add(from);
        }
        Collections.reverse(v);
        return v;
    }

}
