package com.example.pa5try2;

/**
 * TicTacToeBoard is the mechanical parts of our game. It is the logic behind what is going on and
 * how we determine
 */
public class TicTacToeBoard {
    /**
     * N is the size of the board, which is always 3 in this specific interpretation of Tic Tac Toe.
     * It is final because we do not want the size of the board to be changed at any point.
     */
    static final private int N = 3;
    /**
     * grid is a 2D array of Cell objects that represents the game board behind the scenes.
     * Note: This is is not the same object that is seen by the user. I use the model-view-controller
     * architecture to keep the view separate from the model etc.
     */
    private Cell[][] grid;
    /**
     * whoTurn is the boolean that flips back and forth depending on whose turn it is.
     * true corresponds to player1 and false corresponds to player2
     */
    protected boolean whoTurn;
    /**
     * playerSymbol is the 'X' or 'O' that is used in the mechanics of the game and is determined by
     * a simple if() statement when it is used.
     */
    private char playerSymbol;

    /**
     * Constructor that is called when we create a new object of TicTacToeBoard. It populates a new
     * 2D array of Cell objects that represents a TicTacToe board. Each index of the board is a Cell,
     * which is made up of a Coordinates object, which is nothing more than an x and a y coordinate
     * represented by two integers. 'new Cell(i, j, '-')' is the constructor of the Cell class, instantiating
     * objects of Cells and setting the x-coordinate of that object to i, the y-coordinate to j, and the symbol
     * to '-'.
     */
    public TicTacToeBoard() {
        grid = new Cell[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                grid[i][j] = new Cell(i, j, '-');
        }
    }

    /**
     * Determines if the coordinates that are passed in are valid or invalid.
     *
     * @param coordinates is the object of Coordinate class that are passed in and
     *                    represent the location of the button that is clicked.
     * @return returns true if location passed in does not already equal a 'X' or an 'O'. False otherwise.
     */
    public boolean isValidMove(Coordinates coordinates) {
        if (grid[coordinates.getRow()][coordinates.getColumn()].getSymbol() != 'X' &&
                grid[coordinates.getRow()][coordinates.getColumn()].getSymbol() != 'O') {
            return true;
        }

        return false;
    }

    /**
     * As long as isValidMove() returns true, then go ahead and put their symbol in the cell location that
     * was passed in as a parameter.
     * @param coordinates is the object of Coordinate class that are passed in and
     *                    represent the location of the button that is clicked.
     * @return returns true if the move was made successfully, false otherwise.
     */
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


    /**
     * Determines if the game has been won by calling the helper functions designed to find a winner
     *
     * @return true if the game has ended.(i.e if any of the helper functions return true, signifying
     * a winner has been found)
     */
    boolean isWinner() {
        if(checkTopLeftDownDiag('X') || checkTopLeftDownDiag('O')) {
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

    /**
     * iterates through each row to determine if a user has gotten three of their symbols in a row
     *
     * @param playerSymbol the symbol that is passed in. either 'X' or 'O'
     * @return true if a user has three of their symbol in a row, false otherwise.
     */
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

    /**
     * Similar to checking rows, we want to check each column to see if someone has filled a column
     * with their sumbol
     *
     * @param playerSymbol is the symbol that is passed in. either 'X' or 'O'
     * @return true if either person has won.
     */
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

    /**
     * Checking the diagonal starting at the top left and ending at the bottom right. '\' <- that angle.
     *
     * @param playerSymbol the symbol that is passed in. either 'X' or 'O'
     * @return true if all three of these cells are populated with the same symbol.
     */
    private boolean checkTopLeftDownDiag(char playerSymbol) {
        //checking the top left-bottom right diagonal
        for (int i = 0; i < N; i++) {
            if (grid[i][i].getSymbol() != playerSymbol) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checking the diagonal starting from the bottom left and ending at the top right. '/' <- that angle.
     *
     * @param playerSymbol the symbol that is passed in. either 'X' or 'O'
     * @return true if all three of these cells are populated with the same symbol
     */
    private boolean checkBottomLeftUpDiag(char playerSymbol) {
        int i = 0;
        for (int j = N - 1; j >= 0; j--) {
                if (grid[j][i].getSymbol() != playerSymbol)
                    return false;
                i++;
        }
        return true;
    }

    /**
     * the final scenario that the game ends - if the board is entirely full and neither person has won.
     *
     * @return true if the entire board is iterated through and none of the cells == '-' which means
     * the board is full and there are no spots left to play
     */
    public boolean checkBoardFull() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j].getSymbol() == '-')
                    return false;
            }
        }
        return true;
    }

}