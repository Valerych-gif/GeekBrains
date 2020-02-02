package ru.geekbrains.valerych.lesson4;

public class Map {

    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    private static final String EMPTY_COLUMN_TITLE = "  ";
    char[][] cells;
    int size;

    Map (int size){
        cells = new char[size][size];
        this.size=size;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                cells[i][j] = DOT_EMPTY;
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
                System.out.print(cells[i][j] + " ");
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
                if (cells[i][j] == DOT_EMPTY) {
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

        return cells[rowNumber - 1][colNumber - 1] == DOT_EMPTY;
    }

}
