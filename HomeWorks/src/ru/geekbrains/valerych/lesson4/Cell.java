package ru.geekbrains.valerych.lesson4;

public class Cell {


    private int x, y;
    private CellType type;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
        this.type = CellType.EMPTY;
    }

    public void putCross(){
        this.type=CellType.CROSS;
    }

    public void putZero(){
        this.type=CellType.ZERO;
    }

    public void clear(){
        this.type=CellType.EMPTY;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public CellType getType() {
        return type;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public char toChar(){
        if (this.type==CellType.EMPTY) return '•';
        if (this.type==CellType.CROSS) return 'X';
        if (this.type==CellType.ZERO) return 'O';
        return '•';
    }

    public boolean isEmpty(){
        return this.type==CellType.EMPTY;
    }
}
