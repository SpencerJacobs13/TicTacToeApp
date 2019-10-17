package com.example.pa5try2;
public class TicTacToeBoard {
    private int N;
    private Cell[][] grid;

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
                grid[i][j] = new Cell(i, j, '-'); //create new cells in every location, idealized with '-'
        }


    }

    //overriding the toString method to print out the board
   /* @Override
    public String toString() {
        String gridStr = " ";

        for (int i = 0; i < N; i++) {
            gridStr += " " + i;
        }

        for (int i = 0; i < N; i++) {
            gridStr += "\n" + i + " ";
            for (int j = 0; j < N; j++) {
                gridStr += grid[j][i].getSymbol() + " "; //append, rather than add
            }
        }
        return gridStr;
    }*/


//   public boolean playGame(Coordinates coordinates){
//       if(isValidMove(coordinates) && ! isWinner())
//   }


    //if the coordinate given by user is blank, allow them to play there, otherwise return false
    public boolean isValidMove(Coordinates coordinates) {
        if (grid[coordinates.getRow()][coordinates.getColumn()].getSymbol() != 'X' &&
                grid[coordinates.getRow()][coordinates.getColumn()].getSymbol() != 'O')
            return true;

        return false;
    }

    //as long as isValidMove() returns true, then go ahead and put their char in the location they want
    public boolean makeMove(Coordinates coordinates, char playerSymbol) {
        if (isValidMove(coordinates)) {
            grid[coordinates.getRow()][coordinates.getColumn()].setSymbol(playerSymbol);
            return true;
        } else {
            System.out.println("Invalid Move, try again.");
            return false;
        }
    }


    //if a row, a column, or one of the two diagonals returns true, then the isWinner function will return true, meaning
    //someone has won the game
    boolean isWinner(char playerSymbol) {
        if(checkTopLeftDownDiag(playerSymbol))
            return true;
        else if (checkBottomLeftUpDiag(playerSymbol))
            return true;
        else if (checkRows(playerSymbol))
            return true;
        else if (checkColumns(playerSymbol))
            return true;

        return false;
    }

    //iterates through each row to see if the player's symbol occupies every spot in a row
    private boolean checkRows(char playerSymbol) {
        int count = 0;
        for (int j = 0; j < N; j++) {
            for (int i = 0; i < N; i++) {
                if (grid[i][j].getSymbol() == playerSymbol) {
                    count++;
                } else
                    return false;
            }
            //if count is equal to the size of the row, then the player has filled a row
            if(count == N)
                return true;
            count = 0;
        }
        return false;
    }

    //check columns individually
    private boolean checkColumns(char playerSymbol) {
        int count = 0;
        for (int j = 0; j < N; j++) {
            for (int i = 0; i < N; i++) {
                if (grid[j][i].getSymbol() == playerSymbol) {
                    count++;
                } else
                    return false;
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