package com.company;

import java.util.ArrayList;

public class Main {

    static void search(int[][] matrix, int n, int start, int[] visited, int [][] treeMatrix, int help) {
        System.out.print(start + " ");

        visited[start] = 1;
        for(int i=0; i<n; i++) {
            if(i == start) {
                continue;
            }

            if(matrix[start][i] == 1) {

                if(visited[i] == 0) {

                    search(matrix, n, i, visited, treeMatrix, start);
                }
                else if(i != help) {
                    treeMatrix[start][i] = 0;
                    treeMatrix[i][start] = 0;
                }

            }
        }
    }
    static void printGraph(int[][] tree, int n) {
        for(int i=0;i<n;i++){
            for(int j=0; j<n;j++) {
                System.out.print(tree[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    public static void main(String[] args) {
        int n=8;
        int start = 7;
        int[][] graph  = new int[][]{
                     {0, 1, 1, 1, 0, 0, 0, 0},
                     {1, 0, 0, 0, 1, 1, 0, 0},
                     {1, 0, 0, 0, 0, 0, 1, 0},
                     {1, 0, 0, 0, 0, 0, 0, 1},
                     {0, 1, 0, 0, 0, 0, 0, 1},
                     {0, 1, 0, 0, 0, 0, 0, 1},
                     {0, 0, 1, 0, 0, 0, 0, 1},
                     {0, 0, 0, 1, 1, 1, 1, 0},
             };
//        int n = 4;
//        int start = 0;
//        int [][] graph = new int[][]{
//                {0,1,0,1},
//                {1,0,1,0},
//                {0,1,0,0},
//                {1,0,0,0},
//        };
        int[] visited =  new int[n];
        search(graph, n, start, visited, graph, start);
        System.out.println("\n--");

        printGraph(graph, n);
        System.out.println("--");
    }
}
