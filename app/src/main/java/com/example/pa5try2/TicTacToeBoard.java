package com.example.pa5try2;

import android.widget.Toast;

public class TicTacToeBoard {
    private int N;
    private Cell[][] grid;
    protected boolean whoTurn; //true if whoTurn is
    private char playerSymbol;

    //default constructor - never called, but is important as a backup.
    public TicTacToeBoard() {
        N = 3;
        grid = new Cell[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                grid[i][j] = new Cell(i, j, '-'); //create new cells in every location, idealized with '-'
        }

    }

    //explicit value constructor -- initialize the board to '-'s
    public TicTacToeBoard(int boardSize) {
        N = boardSize;
        grid = new Cell[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                grid[i][j] = new Cell(i, j, '-'); //create new cells in every location, populated with '-'
        }
    }



    //if the coordinate given by user is blank, allow them to play there, otherwise return false
    public boolean isValidMove(Coordinates coordinates) {
        if (grid[coordinates.getRow()][coordinates.getColumn()].getSymbol() != 'X' &&
                grid[coordinates.getRow()][coordinates.getColumn()].getSymbol() != 'O') {
            return true;
        }

        return false;
    }

    //as long as isValidMove() returns true, then go ahead and put their char in the location they want
    public boolean makeMove(Coordinates coordinates) {
        if(whoTurn)
            playerSymbol = 'X';
        else
            playerSymbol = 'O';

        if (isValidMove(coordinates)) {
            grid[coordinates.getRow()][coordinates.getColumn()].setSymbol(playerSymbol);
            return true;
        } else {
            return false;
        }
    }


    //if a row, a column, or one of the two diagonals returns true, then the isWinner function will return true, meaning
    //someone has won the game
    boolean isWinner() {
        if(checkTopLeftDownDiag('X') || checkTopLeftDownDiag('O')) {
            //Toast.makeText(null, "Top-left diag winner", Toast.LENGTH_SHORT).show();
            return true;
        } else if (checkBottomLeftUpDiag('X') || checkBottomLeftUpDiag('O')) {
            return true;
        } else if (checkRows('X') || checkRows('O')){
            return true;
        }
        else if (checkColumns('X') || checkColumns('O')){
            return true;
        }

        return false;
    }

    //iterates through each row to see if the player's symbol occupies every spot in a row
    private boolean checkRows(char playerSymbol) {
            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (grid[j][i].getSymbol() == playerSymbol)
                        count++;
                }
                if (count == N)
                    return true;
                count = 0;
            }
            return false;
    }

    //check columns individually
    private boolean checkColumns(char playerSymbol) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j].getSymbol() == (playerSymbol))
                    count++;
            }
            if (count == N)
                return true;
            count = 0;
        }
        return false;
    }

    private boolean checkTopLeftDownDiag(char playerSymbol) {
        //checking the top left-bottom right diagonal
        for (int i = 0; i < N; i++) {
            if (grid[i][i].getSymbol() != playerSymbol) {
                return false;
            }
        }
        return true;
    }

    //checking the bottom left-top right diagonal
    private boolean checkBottomLeftUpDiag(char playerSymbol) {
        int i = 0;
        for (int j = N - 1; j >= 0; j--) {
                if (grid[j][i].getSymbol() != playerSymbol)
                    return false;
                i++;
        }
        return true;
    }

    //iterates through the board to check if it is full. If the board is full, function returns true
    public boolean checkBoardFull() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j].getSymbol() == '-')
                    return false;
            }
        }
        return true;
    }

    //end TicTacToeBoard Class
}