package com.example.pa5try2;

public class Cell {
    private Coordinates coord = new Coordinates();
    private char symbol;

    //default constructor
    public Cell() {
        this.coord.setRow(0);
        this.coord.setColumn(0);
    }

    //explicit value constructor
    public Cell(Coordinates coord, char symbol) {
        this.coord = coord;
        this.symbol = symbol;
    }

    //explicit value constructor with integers x and y passed in
    public Cell(int x, int y, char symbol) {
        this.coord.setRow(x);
        this.coord.setColumn(y);
        this.symbol = symbol;
    }

    //the symbol of the cell
    @Override
    public String toString() {
        return "Symbol = " + symbol;
    }

    public Coordinates getCoord() { return coord; }

    public void setCoord(Coordinates coord) { this.coord = coord; }

    public char getSymbol() { return symbol; }

    public void setSymbol(char symbol) { this.symbol = symbol; }
}