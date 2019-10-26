package com.example.pa5try2;

/**
 * Cell objects are made up of a Coordinates object and a symbol, either an 'X', an 'O', or a '-'.
 */
public class Cell {
    /**
     * coord is a Coordinates object that is used to represent the location of the Cell object.
     */
    private Coordinates coord = new Coordinates();
    /**
     * symbol is the character representation of every location on the game board. ('X', an 'O', or a '-'.)
     */
    private char symbol;


    /**
     * Default value constructor is
     * @param coord is the coordinates object that might be passed into this object.
     *              This constructor should not ever be called, but it is helpful in debugging and
     *              as a backup if something goes terribly wrong.
     *
     * @param symbol is the character symbol that is used to represent the Cell. ('X', an 'O', or '-')
     */
    public Cell(Coordinates coord, char symbol) {
        this.coord = coord;
        this.symbol = symbol;
    }

    /**
     *  The constructor that is called by every location on the 2D array game board.
     *
     * @param x is the integer x-coordinate
     * @param y is the integer y-coordinate
     * @param symbol is the symbol that occupies every location on the 2D array 'board'
     */
    public Cell(int x, int y, char symbol) {
        this.coord.setRow(x);
        this.coord.setColumn(y);
        this.symbol = symbol;
    }

    /**
     * Overriding the toString method that represents what symbol is in each cell location.
     * This should not be called in the game logic, but is helpful in debugging and troubleshooting
     * @return
     */
    @Override
    public String toString() {
        return "Symbol = " + symbol;
    }

    /**
     * Getter function that returns the character symbol that occupies the location of the invoking object
     * @return a character to represent the symbol at any given location
     */
    protected char getSymbol() { return symbol; }

    /**
     * Setter function that sets the symbol of the invoking Cell object.
     *
     * @param symbol is the 'X', an 'O', or '-' that occupies every location on the 2D array game board.
     */
    protected void setSymbol(char symbol) { this.symbol = symbol; }
}