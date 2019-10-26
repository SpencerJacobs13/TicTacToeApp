package com.example.pa5try2;

/**
 * Coordinates class is the x and y integers that represent the coordinate of each cell.
 */
public class Coordinates {
    private int row;
    private int column;

    /**
     * Mostly used in debugging and troubleshooting, I want to override the toString method so that
     * each pair of coordinates is represented in a clean and clear manner.
     *
     * @return As with all toString() methods, return a string representation of the invoking object
     */
    @Override
    public String toString() {
        return "Coordinates: " +
                "(" + row + ", " + column + ')';
    }

    /**
     * Default value constructor automatically sets the column and row to be 0.
     */
    Coordinates(){
        this.row = 0;
        this.column = 0;
    }

    /**
     * Explicit value constructor that accepts two integer values and sets the row and column with said values
     * @param row the integer value representing the row of this coordinate object
     * @param column the integer value of representing the column of this coordinate object
     */
    Coordinates(int row, int column) {
        setRow(row);
        setColumn(column);
    }


    /**
     * Getter function that returns the row of the invoking object.
     * @return returns an integer value representing the row of the invoking object
     */
    protected int getRow() { return row; }

    /**
     * Setter function that sets the row the of the invoking object w/ an integer that is passed in.
     *
     * @param row is the integer value that is set to the row of invoking object.
     */
    protected void setRow(int row) { this.row = row; }

    /**
     * Getter function that returns the column of the invoking object
     *
     * @return and integer that represents the column of the invoking object
     */
    protected int getColumn() { return column; }

    /**
     * Setter function that sets the column the of the invoking object w/ an integer that is passed in.
     *
     * @param column is the integer value that is set to the column of invoking object.
     */
    protected void setColumn(int column) { this.column = column; }
}
