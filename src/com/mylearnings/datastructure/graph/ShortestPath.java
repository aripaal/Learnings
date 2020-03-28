package com.mylearnings.datastructure.graph;

import java.util.*;

public class ShortestPath {
    public static class Edge{
        int weight;
        Vertex start,end;

        public Edge(int weight, Vertex start, Vertex end) {
            this.weight = weight;
            this.start = start;
            this.end = end;
        }
    }
    public static class Vertex implements Comparable<Vertex>{
        String name;
        int distance=Integer.MAX_VALUE;
        List<Edge> adjList;
        Vertex predecessor;

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

        @Override
        public String toString() {
            return name;
        }
    }

    public void dijikstra(Vertex src){
        src.distance=0;
        PriorityQueue<Vertex> queue=new PriorityQueue<>();
        queue.offer(src);

        while(!queue.isEmpty()){
            Vertex current = queue.poll();
            Iterator<Edge> it = current.adjList.iterator();
            while(it.hasNext()){
                Edge currEdge=it.next();
                int tempDistance= current.distance+currEdge.weight;
                if(tempDistance<currEdge.end.distance){
                    queue.remove(currEdge.end);
                    currEdge.end.distance=tempDistance;
                    currEdge.end.predecessor=current;
                    queue.offer(currEdge.end);
                }
            }
        }

    }

    public void bellmanford(List<Edge> edges,int numVertices,Vertex src){

        src.distance=0;
        for(int i=0;i<numVertices-1;i++){

            for(Edge e: edges){
                Vertex u=e.start;
                Vertex v=e.end;
                if(u.distance==Integer.MAX_VALUE) continue;

                int tempDistance=u.distance+e.weight;
                if(tempDistance<v.distance){
                    v.distance=tempDistance;
                    v.predecessor=u;
                }
            }

            for(Edge e: edges){
                if(e.start.distance!=Integer.MAX_VALUE){
                    if(hasCycle(e)) {
                        System.out.println("Cycle detected");
                        return;
                    }
                }

            }

        }

    }

    private boolean hasCycle(Edge e) {
        return e.start.distance+e.weight<e.end.distance;
    }

    public List<Vertex> printSolution(Vertex target){
        List<Vertex> list=new LinkedList<>();
        for(Vertex from=target;from!=null;from=from.predecessor){
            list.add(from);
        }
        Collections.reverse(list);
        return list;
    }
    public static void main(String... args){
        Vertex v0 = new Vertex("A");
        Vertex v1 = new Vertex("B");
        Vertex v2 = new Vertex("C");

        v0.addNeighbor(new Edge(1,v0,v1));
        v0.addNeighbor(new Edge(5,v0,v2));
        v1.addNeighbor(new Edge(1,v1,v2));

        ShortestPath sp = new ShortestPath();
        //sp.dijikstra(v0);
       // sp.bellmanford();
        System.out.println(sp.printSolution(v2));


    }
}
