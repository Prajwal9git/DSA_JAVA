package com.Prajwal.Recursion;

import java.util.Arrays;

public class Backtracking {
    public static void main(String[] args) {
        boolean maze[][] = {{true,true,true},{true,true,true},{true,true,true}};
        int[][] path = new int[maze.length][maze[0].length];

        MazeAllDirectionPrint("", maze, 0, 0,path,1);
    }
    public static int Maze(int row, int column){
        if(row == 1 || column == 1) return 1;
        int count = 0;

        count+=Maze( row-1, column);
        count+=Maze( row, column-1);
        return count;
    }

    public static void MazePath(String p, int row, int column){
        if(row == 1 && column == 1){
            System.out.println(p);
            return;
        }
        int count = 0;
        if(row!=1)
        MazePath(p+" ↓", row-1, column);
        if(column!=1)
        MazePath( p+" →",row, column-1);
    }

    public static void MazeAllDirection(String p, boolean maze[][], int row, int column){
        if(row == maze.length-1 && column == maze[0].length - 1){
            System.out.println(p);
            return;
        }
        if(!maze[row][column]) return;
        maze[row][column] = false;
        if(row < maze.length-1)
            MazeAllDirection(p+"D", maze, row+1, column);
        if(column < maze[0].length - 1)
            MazeAllDirection( p+"R", maze, row, column+1);
        if(row > 0)
            MazeAllDirection( p+"U", maze, row-1, column);
        if(column > 0)
            MazeAllDirection( p+"L", maze, row, column-1);

        //this line is where the function ends
        //so undo the changes you have made
        maze[row][column] = true;
    }

    public static void MazeAllDirectionPrint(String p, boolean maze[][], int row, int column, int[][] path, int step){
        if(row == maze.length-1 && column == maze[0].length - 1){
            path[row][column] = step;
            for(int arr[]:path)
                System.out.println(Arrays.toString(arr));
            System.out.println(p);
            System.out.println();
            return;
        }
        if(!maze[row][column]) return;
        maze[row][column] = false;
        path[row][column] = step;
        if(row < maze.length-1)
            MazeAllDirectionPrint(p+"D", maze, row+1, column, path, step+1);
        if(column < maze[0].length - 1)
            MazeAllDirectionPrint( p+"R", maze, row, column+1, path, step+1);
        if(row > 0)
            MazeAllDirectionPrint( p+"U", maze, row-1, column, path, step+1);
        if(column > 0)
            MazeAllDirectionPrint( p+"L", maze, row, column-1, path, step+1);

        //this line is where the function ends
        //so undo the changes you have made
        maze[row][column] = true;
        path[row][column] = 0;
    }
}
