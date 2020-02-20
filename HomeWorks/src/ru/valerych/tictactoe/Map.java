package ru.valerych.tictactoe;

public class Map {

    Cell[][] cells;
    int size;

    Map (int size){
        cells = new Cell[size][size];
        this.size=size;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                cells[i][j] = new Cell(i, j);
                cells[i][j].clear();
                cells[i][j].setX(i);
                cells[i][j].setY(j);
            }
        }
    }

    public boolean isFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (cells[i][j].isEmpty()) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isCellValid(int rowNumber, int colNumber) {
        if (rowNumber < 1 || rowNumber > size)
            return false;
        if (colNumber < 1 || colNumber > size)
            return false;

        return cells[rowNumber - 1][colNumber - 1].isEmpty();
    }

}
