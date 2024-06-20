package com.Prajwal.Recursion;

public class Patterns {
    public void reverseTriangle(int row, int column){
        if(row == 0) return;
        if(row > column){
            System.out.print("*");
            reverseTriangle(row, column + 1);
        }
        else{
            System.out.println();
            reverseTriangle(row - 1, 0);
        }
    }

    public void triangle(int row, int column){
        if(row == 0) return;
        if(row > column){
            triangle(row, column + 1);
            System.out.print("*");
        }
        else{
            triangle(row - 1, 0);
            System.out.println();
        }


    }
}
