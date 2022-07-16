package com.mypackage;

import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.Random;

public class Board {
    private int row;
    private int column;
    private int mines;
    private int[][] mine;
    private int[][] display;
    private final int[] x = {-1, -1, -1, 0, 0, 1, 1, 1};
    private final int[] y = {-1, 0, 1, -1, 1, -1, 0, 1};

    public Board() {
        row = 8;
        column = 8;
        mines = 10;
        mine = new int[row][column];
        display = new int[row][column];
        createMineBoard();
        createAllMinus1(display);
    }
    public Board(int r, int c, int m) {
        row = r;
        column = c;
        mines = m;
        mine = new int[row][column];
        display = new int[row][column];
        createMineBoard();
        createAllMinus1(display);
    }

    private void createAllMinus1(int[][] a) {
        for (int i = 0; i<a.length; i++)
            for (int j = 0; j<a.length; j++)
                a[i][j] = -1;
    }

    public void showNum() {

    }

    public void showMineBoard() {
        for (int i = 0; i<row; i++) {
            for (int j = 0; j<column; j++)
                System.out.print(mine[i][j] + " ");
            System.out.println();
        }
    }

    public void showDisplayBoard() {
        for (int i = 0; i<row; i++) {
            for (int j = 0; j<column; j++)
                if (display[i][j] == -1)
                    System.out.print('.' + " ");
                else if (display[i][j] == 10)
                    System.out.print('F' + " ");
                else
                    System.out.print(display[i][j] + " ");
            System.out.println();
        }
    }

    public void createMineBoard() {
           createMines();
           for (int i = 0; i<row; i++) {
               for (int j = 0; j<column; j++) {
                   if (mine[i][j] == 0) {
                       int countMines = 0;
                       for (int k = 0; k<8; k++) {
                           int ii = i+x[k];
                           int jj = j+y[k];
                           if (isValid(ii, jj) && mine[ii][jj] == 9)
                               countMines++;
                       }
                       mine[i][j] = countMines;
                   }
               }
           }
    }

    public boolean isValid(int i, int j) {
        if (i >= 0 && i < row && j >= 0 && j < column)
            return true;
        return false;
    }

    public void createMines() {
        Random random = new Random();
        int count = 0;
        while (count < mines) {
            int i = random.nextInt(row);
            int j = random.nextInt(column);
            if (mine[i][j] == 9)
                continue;
            mine[i][j] = 9;
            count++;
        }
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getMines() {
        return mines;
    }

    public void setMines(int mines) {
        this.mines = mines;
    }
}
