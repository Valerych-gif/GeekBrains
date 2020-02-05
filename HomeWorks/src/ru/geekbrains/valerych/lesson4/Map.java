package ru.geekbrains.valerych.lesson4;

public class Map {

    private static final String EMPTY_COLUMN_TITLE = "  ";
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

    public void print() {
        printHeader();
        printRows();
    }

    public void printRows() {
        for (int i = 0; i < size; i++) {
            printColumnNumber(i);
            for (int j = 0; j < size; j++) {
                System.out.print(cells[i][j].toChar() + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void printColumnNumber(int i) {
        int columnNumber = i + 1;
        System.out.print(columnNumber + " ");
    }

    public void printHeader() {
        printEmptyHeaderForFirstColumn();
        for (int i = 0; i < size; i++) {
            printColumnNumber(i);
        }
        System.out.println();
    }

    public void printEmptyHeaderForFirstColumn() {
        System.out.print(EMPTY_COLUMN_TITLE);
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
