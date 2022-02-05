package com.gtxc.games;

/*
    Created by gt at 6:13 PM on Saturday, February 05, 2022.
    Project: mine-sweeper, Package: com.gtxc.games.
*/

import java.util.Scanner;

public class MineSweeper {
    private int row;
    private int column;
    private int mineCount;
    private int[][] board;
    private int[][] boardMap;

    public Scanner scanner = new Scanner(System.in);


    public void setRow(int row) {
        this.row = row;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public void setMineCount(int mineCount) {
        this.mineCount = mineCount;
    }

    public void setBoard(int r, int c) {
        this.board = new int[r][c];
    }

    public void setBoardMap(int r, int c) {
        this.boardMap = new int[r][c];
    }

    private void fillBoard() {
        for (int i = 0; i < this.row; ++i) {
            for (int j = 0; j < this.column; ++j) {
                this.board[i][j] = '-';
                this.boardMap[i][j] = '-';
            }
        }
    }

    private void placeMines() {
        int mines = this.mineCount;
        while (mines > 0) {
            int mineLocationRow = (int) Math.floor(Math.random() * this.row);
            int mineLocationColumn = (int) Math.floor(Math.random() * this.column);
            if (boardMap[mineLocationRow][mineLocationColumn] == '-') {
                boardMap[mineLocationRow][mineLocationColumn] = '*';
                --mines;
            }
        }
    }

    private void fillMap() {
        for (int i = 0; i < this.row; ++i) {
            for (int j = 0; j < this.column; ++j) {
                int mCount = 0;
                if (boardMap[i][j] != '*') {
                    try {if (boardMap[i][j-1] == '*') ++mCount;} catch (ArrayIndexOutOfBoundsException ignored) {}
                    try {if (boardMap[i][j+1] == '*') ++mCount;} catch (ArrayIndexOutOfBoundsException ignored) {}
                    try {if (boardMap[i-1][j] == '*') ++mCount;} catch (ArrayIndexOutOfBoundsException ignored) {}
                    try {if (boardMap[i+1][j] == '*') ++mCount;} catch (ArrayIndexOutOfBoundsException ignored) {}
                    try {if (boardMap[i-1][j-1] == '*') ++mCount;} catch (ArrayIndexOutOfBoundsException ignored) {}
                    try {if (boardMap[i-1][j+1] == '*') ++mCount;} catch (ArrayIndexOutOfBoundsException ignored) {}
                    try {if (boardMap[i+1][j-1] == '*') ++mCount;} catch (ArrayIndexOutOfBoundsException ignored) {}
                    try {if (boardMap[i+1][j+1] == '*') ++mCount;} catch (ArrayIndexOutOfBoundsException ignored) {}
                    boardMap[i][j] = 48 + mCount;
                }
            }
        }
    }

    private void showMap() {
        for (int i = 0; i < this.row; ++i) {
            for (int j = 0; j < this.column; ++j) {
                System.out.printf("%c ", boardMap[i][j]);
            }
            System.out.println();
        }
    }

    private void showBoard() {
        for (int i = 0; i < this.row; ++i) {
            for (int j = 0; j < this.column; ++j) {
                System.out.printf("%c ", board[i][j]);
            }
            System.out.println();
        }
    }

    private boolean checkInput(int r, int c) {
        return r >= 0 && r < this.row && c >= 0 && c < this.column && board[r][c] == '-';
    }

    private boolean processInput(int r, int c) {
        if (boardMap[r][c] != '*') {
            board[r][c] = boardMap[r][c];
            return true;
        }
        return false;
    }

    private boolean checkWin() {
        int indexCount = 0;
        for (int i = 0; i < this.row; ++i) {
            for (int j = 0; j < this.column; ++j) {
                if (board[i][j] != '-') {
                    ++indexCount;
                }
            }
        }
        return indexCount == (this.row * this.column) - mineCount;
    }

    private void initGame() {
        int r;
        int c;
        System.out.println(" *** Mine Sweeper *** ");
        System.out.println("Create board:");
        System.out.print("\tRow number: ");
        r = scanner.nextInt();
        setRow(r);
        System.out.print("\tColumn number: ");
        c = scanner.nextInt();
        setColumn(c);
        setMineCount((r * c) / 4);
        setBoard(r, c);
        setBoardMap(r, c);
        fillBoard();
        placeMines();
        fillMap();
    }


    public void run() {
        initGame();
        int r;
        int c;
        showMap();
        System.out.println();
        while (true) {
            showBoard();
            System.out.print("\n\tRow number [0-" + (this.row-1) + "]: ");
            r = scanner.nextInt();
            System.out.print("\n\tColumn number [0-" + (this.column-1) + "]: ");
            c = scanner.nextInt();
            if (!checkInput(r, c)) {
                System.out.println("\n\u001B[31m" + "Invalid input" + "\u001B[0m");
                continue;
            }
            if (!processInput(r, c)) {
                System.out.println("\n\u001B[31m" + "GAME OVER!" + "\u001B[0m");
                showMap();
                break;
            }
            if (checkWin()) {
                System.out.println("\n\u001B[31m" + "CONGRATS!" + "\u001B[0m");
                showMap();
                break;
            }
        }
        scanner.close();
    }
}
