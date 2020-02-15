package ru.valerych.tictactoe;

public class Game {

    private Map map;
    int dotsForWin;

    Game(Map map, int dotsForWin) {
        this.map = map;
        this.dotsForWin = dotsForWin;
    }

    public boolean checkEnd(CellType type) {
        if (checkWin(type)) {
            return true;
        }
        return map.isFull();
    }

    public boolean checkWin(CellType type) {
        return checkRows(type) || checkCols(type) || checkDiagonals(type);

    }

    private boolean checkRows(CellType type) {
        int sameSymbolCounter;
        for (int i = 0; i < map.size; i++) {
            sameSymbolCounter = 0;
            for (int j = 0; j < map.size; j++) {
                if ((map.cells[i][j].getType()).equals(type)) {
                    sameSymbolCounter += 1;
                    if (sameSymbolCounter >= dotsForWin) {
                        return true;
                    }
                } else {
                    sameSymbolCounter = 0;
                }
            }
        }
        return false;
    }

    private boolean checkCols(CellType type) {
        int sameSymbolCounter;
        for (int i = 0; i < map.size; i++) {
            sameSymbolCounter = 0;
            for (int j = 0; j < map.size; j++) {
                if ((map.cells[j][i].getType()).equals(type)) {
                    sameSymbolCounter += 1;
                    if (sameSymbolCounter >= dotsForWin) {
                        return true;
                    }
                } else {
                    sameSymbolCounter = 0;
                }
            }
        }
        return false;
    }

    private boolean checkDiagonals(CellType type) {
        for (int i = 0; i < map.size; i++) {
            if (
                    checkMainDiagonals(i, 0, type) ||
                            checkMainDiagonals(0, i, type) ||
                            checkReverseDiagonals(i, 0, type) ||
                            checkReverseDiagonals(0, i, type)
            ) return true;
        }
        return false;
    }

    private boolean checkMainDiagonals(int startRow, int startCol, CellType type) {
        int quantityDotsOnDiagonal = map.size;
        int sameSymbolCounter;

        if (startRow >= 0) {

            quantityDotsOnDiagonal -= startRow;
            if (quantityDotsOnDiagonal < dotsForWin) return false;

            sameSymbolCounter = 0;
            for (int i = startCol; i < quantityDotsOnDiagonal; i++) {
                if ((map.cells[i + startRow][i].getType()).equals(type)) {
                    sameSymbolCounter += 1;
                    if (sameSymbolCounter >= dotsForWin) {
                        return true;
                    }
                } else {
                    sameSymbolCounter = 0;
                }
            }
        }

        if (startCol > 0) {

            quantityDotsOnDiagonal -= startCol;
            if (quantityDotsOnDiagonal < dotsForWin) return false;

            sameSymbolCounter = 0;
            for (int i = startRow; i < quantityDotsOnDiagonal; i++) {
                if ((map.cells[i][i + startCol].getType()).equals(type)) {
                    sameSymbolCounter += 1;
                    if (sameSymbolCounter >= dotsForWin) {
                        return true;
                    }
                } else {
                    sameSymbolCounter = 0;
                }
            }
        }
        return false;
    }

    private boolean checkReverseDiagonals(int startRow, int startCol, CellType type) {
        int quantityDotsOnDiagonal = map.size;
        int sameSymbolCounter;
        if (startRow >= 0) {

            quantityDotsOnDiagonal = map.size - startRow;
            sameSymbolCounter = 0;

            for (int i = startCol; i < quantityDotsOnDiagonal; i++) {
                if ((map.cells[i + startRow][map.size - 1 - i].getType()).equals(type)) {
                    sameSymbolCounter += 1;
                    if (sameSymbolCounter >= dotsForWin) {
                        return true;
                    }
                } else {
                    sameSymbolCounter = 0;
                }
            }
        }

        if (startCol < (map.size - 1)) {

            quantityDotsOnDiagonal = startCol + 1;
            sameSymbolCounter = 0;

            for (int i = startRow; i < quantityDotsOnDiagonal; i++) {
                if ((map.cells[i][startCol - i].getType()).equals(type)) {
                    sameSymbolCounter += 1;
                    if (sameSymbolCounter >= dotsForWin) {
                        return true;
                    }
                } else {
                    sameSymbolCounter = 0;
                }
            }
        }

        return false;
    }

}
