package com.Prajwal.Recursion;

import com.sun.security.jgss.InquireSecContextPermission;

import java.util.Arrays;


public class Backtracking {
    public static void main(String[] args) {
        int[][] board = {{5,3,0,0,7,0,0,0,0},
        {6,0,0,1,9,5,0,0,0},
        {0,9,8,0,0,0,0,6,0},
        {8,0,0,0,6,0,0,0,3},
        {4,0,0,8,0,3,0,0,1},
        {7,0,0,0,2,0,0,0,6},
        {0,6,0,0,0,0,2,8,0},
        {0,0,0,4,1,9,0,0,5},
        {0,0,0,0,8,0,0,7,9}};

        if(SudokuSolver(board)) displaySudoku(board);
        else System.out.println("Cannot Solve");
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

    public static int NQueen(boolean board[][], int row){
        if(row == board.length){
            display(board);
            return 1;
        }
        int count = 0;
        for(int col = 0; col<board[0].length; col++){
            if(checkValidQueen(board, row, col)){
                board[row][col] = true;
                count+=NQueen(board, row+1);
                board[row][col] = false;
            }
        }
        return count;
    }

    private static boolean checkValidQueen(boolean[][] board, int row, int column) {
        int r = row;
        int c = column;
        //vertical row checking
        while(r>0){
            r-=1;
            if(board[r][column] == true) return false;
        }
        r = row;
        c = column;
        while(r>0 && c>0){
            r-=1;
            c-=1;
            if(board[r][c] == true) return false;
        }
        r = row;
        c = column;
        while(r>0 && c<board[0].length-1){
            r-=1;
            c+=1;
            if(board[r][c]==true) return false;
        }
        return true;
    }

    public static void NKnights(boolean[][] board, int row, int column, int knights){
        if(knights == 0){
            display(board);
            System.out.println();
            return;
        }
        if(row == board.length - 1 && column == board[0].length - 1)
            return;

        if(column == board.length){
            NKnights(board, row+1, 0, knights);
            return;
        }

        if(checkValidKnight(board, row, column)){
            board[row][column] = true;
            NKnights(board, row, column+1, knights-1);
            board[row][column] = false;
        }
        NKnights(board, row, column+1, knights);
    }

    private static boolean checkValidKnight(boolean[][] board, int row, int column) {
        if(isValid(board, row-2, column-1)){
            if(board[row-2][column-1]) {
                return false;
            }
        }

        if(isValid(board, row-2, column+1)){
            if(board[row-2][column+1]) {
                return false;
            }
        }

        if(isValid(board, row-1, column-2)){
            if(board[row-1][column-2]) {
                return false;
            }
        }

        if(isValid(board, row-1, column+2)){
            if(board[row-1][column+2]) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValid(boolean [][]board, int row, int column){
        if(row < board.length && row >= 0 && column >= 0 && column < board[0].length){
            return true;
        }
        return false;
    }
    private static void display(boolean board[][]){
        for(boolean[] row:board){
            for(boolean element : row){
                if(element == true) System.out.print("K ");
                else System.out.print("X ");
            }
            System.out.println();
        }
    }

    public static boolean SudokuSolver(int[][] board){
        int n = board.length;
        int row = -1;
        int col = -1;
        boolean emptyLeft = true;
        //this is how we are replacing r, c, from argumetents when we only want to pass one argument to the function
        for(int i = 0; i<n; i++){
            for(int j =  0; j<n; j++){
                if(board[i][j] == 0){
                    row = i;
                    col = j;
                    emptyLeft = false;
                    break;
                }
            }
            //if you have found the empty element in the row then break
            if(emptyLeft == false) break;


        }
        if(emptyLeft == true) {
            //sudoku is solved
            return true;
        }
        for(int number = 1; number <= 9; number++){
            if(isSafe(board, row, col, number)){
                board[row][col] = number;
                if(SudokuSolver(board)){
                    //found the correct number then pass it to the board and call the next recursion
                    return true;
                }
                //otherwise backtrack
                else{
                    board[row][col] = 0;
                }
            }
        }
        return false;
    }

    private static void displaySudoku(int[][] board) {
        for (int k = 0; k < 25; k++) {
            System.out.print("-");
        }
        System.out.println();
        for(int i = 0; i<board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(j%3 == 0) System.out.print("| ");
                System.out.print(board[i][j]+" ");
            }
            System.out.print("|");
            if(i%3-2== 0) {
                System.out.println();
                for (int k = 0; k < 25; k++) {
                    System.out.print("-");
                }
            }
            System.out.println();
        }
    }

    static boolean isSafe(int[][] board, int row, int column, int num){
        //check rows
        for(int i = 0; i<board.length; i++){
            //check if the number is already in the row or not
            if(board[row][column] == num) return false;
        }

        //check the columns
        for(int[] nums:board){
            if(nums[column] == num) return false;
        }

        int sqrt = (int)Math.sqrt(board.length);
        int rowStart = row - row%sqrt;
        int colStart = column - column%sqrt;

        for(int r = rowStart; r<rowStart+sqrt; r++){
            for(int c = colStart; c<colStart+sqrt; c++){
                if(board[r][c] == num) return false;
            }
        }
        return true;
    }
}
