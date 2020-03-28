package com.mylearnings.datastructure;

import java.util.Arrays;

public class GraphMatx {

    int V;
    int[][] graph;


    public GraphMatx(int[][] graph) {
        V = graph.length;
        this.graph=graph;
    }

    private int minIndx(boolean[] visited,int[] keys){

        int min=Integer.MAX_VALUE;
        int min_index = -1;

        for(int v=0;v<V;v++){
            if(!visited[v] && keys[v]<min){
                min_index=v;
                min=keys[v];
            }
        }
        return min_index;

    }

    public void MST(){

        boolean[] visited = new boolean[V];
        int[] parent = new int[V];
        int[] keys=new int[V];

        Arrays.fill(keys,Integer.MAX_VALUE);
        keys[0]=0;
        parent[0]=-1;
        for(int count=1;count<V;count++){

            int u=minIndx(visited,keys);
            visited[u]=true;

            for(int v=0;v<V;v++){
                if(graph[u][v]!=0 && graph[u][v]<keys[v] && !visited[v]){
                    parent[v]=u;
                    keys[v]=graph[u][v];
                }

            }

        }



    }


}
