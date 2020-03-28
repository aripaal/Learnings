package com.mylearnings.datastructure;

import java.util.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Stream;

public class GraphDS {
    public static class Graph {
        int V;
        List<Integer> adjList[] ;

        public Graph(int v) {
            V = v;
            adjList=new LinkedList[V];
            for(int i=0;i<V;i++)
                adjList[i]=new LinkedList<>();
        }

        public void addEdge(int src,int dest){
            adjList[src].add(dest);
           // adjList[dest].add(src);
        }

        public void BFS(int src){
            boolean[] visited = new boolean[V];
            Queue<Integer> queue[]= new LinkedList[V];
            Arrays.fill(queue,new LinkedList<>());
            queue[0].offer(src);
            visited[src]=true;
            int level=1;

            while(!queue[level-1].isEmpty()){
                int s = queue[level-1].poll();
                System.out.print(s+" ");
                Iterator<Integer> it = adjList[s].iterator();

                while(it.hasNext()){
                    int vtx = it.next();
                    if(!visited[vtx]) {
                        queue[level].offer(vtx);
                        visited[vtx]=true;
                    }
                }
                if(queue[level-1].isEmpty())
                    ++level;

            }
        }
        public void DFS(int src){
            boolean[] visited=new boolean[V];
            DFSUtil(src,visited);
        }
        public void DFSUtil(int src,boolean[] visited){
            System.out.print(src+" ");
            visited[src]=true;

            Iterator<Integer> it = adjList[src].iterator();
            while(it.hasNext()){
                int vtx=it.next();
                if(!visited[vtx])
                    DFSUtil(vtx,visited);
            }
        }
        public void topologicalSort(){
            Stack<Integer> stack=new Stack<>();
            boolean[] visited=new boolean[V];

            for(int i=0;i<V;i++){
                if(!visited[i])
                    topologicalSortUtil(i,visited,stack);
            }

            while(!stack.isEmpty())
                System.out.print(stack.pop()+" ");


        }

        public void topologicalSortUtil(int v,boolean[] visited,Stack s){
            visited[v]=true;

            Iterator<Integer> it = adjList[v].iterator();
            while(it.hasNext()){
                int vtx = it.next();
                if(!visited[vtx]){
                    topologicalSortUtil(vtx,visited,s);
                }
            }
            s.push(v);
        }
    }



    public static void main(String... args){
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        g.BFS(2);
        System.out.println("");
        g.DFS(2);
        System.out.println(" ");
        Graph g2=new Graph(6);
        g2.addEdge(5, 2);
        g2.addEdge(5, 0);
        g2.addEdge(4, 0);
        g2.addEdge(4, 1);
        g2.addEdge(2, 3);
        g2.addEdge(3, 1);
        g2.topologicalSort();

    }




}
