package com.mylearnings.datastructure;

import java.util.Arrays;

public class Dijkstra {
    int V;
    int [] dist;
    boolean [] visited;
    int[][] graph;

    public Dijkstra(int[][] graph) {
        this.graph = graph;
        V=graph.length;
        visited=new boolean[V];
        dist=new int[V];
    }


    public void printSolution(){
        for(int v=0;v<V;v++)
            System.out.println("From vertex :"+v+"\t"+dist[v]);
    }

    int findMin(int [] dist,boolean [] visited){
        int min_index=-1;
        int min=Integer.MAX_VALUE;

        for(int v=0;v<V;v++){
            if(!visited[v] && dist[v]<min){
                min=dist[v];
                min_index=v;
            }
        }
        return min_index;
    }

    public void solve(int src){

        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;

        for(int count=1;count<V;count++){

            int u=findMin(dist,visited);
            visited[u]=true;
            for(int v=0;v<V;v++){
                if(!visited[v] && graph[u][v]!=0 &&
                        dist[u]!=Integer.MAX_VALUE && dist[u]+graph[u][v]<dist[v]){
                    dist[v]=dist[u]+graph[u][v];

                }
            }
        }

        printSolution();
    }



    public static void main (String[] args)
    {
        /* Let us create the example graph discussed above */
        int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };
        Dijkstra t = new Dijkstra(graph);
        t.solve( 0);
    }

}
