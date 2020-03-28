package com.mylearnings.datastructure;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;

public class TSPNearestNeighbour
{
    private int numberOfNodes;
    private Stack<Integer> stack;

    public TSPNearestNeighbour()
    {
        stack = new Stack<Integer>();
    }

    public void tsp(int adjacencyMatrix[][])
    {
        numberOfNodes = adjacencyMatrix[0].length - 1;
        boolean[] visited = new boolean[numberOfNodes + 1];
        visited[1] = true;
        stack.push(1);
        int element, dst = 0, i;

        boolean minFlag = false;
        System.out.print(1 + "\t");

        while (!stack.isEmpty())
        {
            element = stack.peek();
            i = 1;
            int min = Integer.MAX_VALUE;
            while (i <= numberOfNodes)
            {
                if (adjacencyMatrix[element][i] > 1 && !visited[i] )
                {
                    if (min > adjacencyMatrix[element][i])
                    {
                        min = adjacencyMatrix[element][i];
                        dst = i;
                        minFlag = true;
                    }
                }
                i++;
            }
            if (minFlag)
            {
                visited[dst] = true;
                stack.push(dst);
                System.out.print(dst + "\t");
                minFlag = false;
                continue;
            }
            stack.pop();
        }
    }

    public static void main(String... arg)
    {
        int[][] graph=new int[][]{
                {0 ,374, 200, 223, 108, 178, 252, 285, 240, 356},
                 {374, 0, 255, 166, 433, 199, 135, 95, 136, 17},
                  {200, 255, 0 ,128 ,277 ,128 ,180 ,160 ,131 ,247},
                   {223 ,166 ,128 ,0 ,430 ,47 ,52 ,84 ,40 ,155},
                  {108 ,433 ,277 ,430 ,0 ,453 ,478 ,344 ,389 ,423},
                  {178 ,199 ,128 ,47 ,453 ,0 ,91 ,110 ,64 ,181},
                   {252 ,135 ,180 ,52 ,478 ,91 ,0 ,114 ,83 ,117},
                   {285 ,95 ,160 ,84 ,344 ,110 ,114 ,0 ,47 ,78},
                   {240 ,136 ,131 ,40 ,389 ,64 ,83 ,47 ,0 ,118},
                   {356 ,17 ,247 ,155 ,423 ,181 ,117 ,78 ,118 ,0}
        };
        TSPNearestNeighbour tsp =new TSPNearestNeighbour();
        tsp.tsp(graph);
    }
}
