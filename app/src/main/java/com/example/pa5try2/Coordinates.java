package com.example.pa5try2;
public class Coordinates {
    private int row;
    private int column;


    @Override
    public String toString() {
        return "Coordinates: " +
                "(" + row + ", " + column + ')';
    }

    //Default value constructor
    public Coordinates() {
        row = 0;
        column = 0;
    }

    //Explicit value constructor
    Coordinates(int row, int column) {
        setRow(row);
        setColumn(column);
    }


    //getters and setters
    public int getRow() { return row; }

    public void setRow(int row) { this.row = row; }

    public int getColumn() { return column; }

    public void setColumn(int column) { this.column = column; }
}
