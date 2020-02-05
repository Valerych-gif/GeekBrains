package ru.geekbrains.valerych.lesson4;

import java.util.Scanner;

public class Game {

    private Map map;
    int dotsForWin;
    private Scanner scanner = new Scanner(System.in);

    Game (Map map, int dotsForWin){
        this.map=map;
        this.dotsForWin=dotsForWin;
    }

    public boolean checkEnd(CellType type) {
        if (checkWin(type)) {
            return true;
        }
        return map.isFull();
    }

    public boolean checkWin(CellType type) {
        return checkRows(type)||checkCols(type)||checkDiagonals(type);

    }

    private boolean checkRows(CellType type) {
        int sameSymbolCounter;
        for (int i = 0; i < map.size; i++) {
            sameSymbolCounter = 0;
            for (int j = 0; j < map.size; j++) {
                if ((map.cells[i][j].getType()).equals(type)){
                    sameSymbolCounter += 1;
                    if (sameSymbolCounter>=dotsForWin){
                        return true;
                    }
                } else {
                    sameSymbolCounter=0;
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
                if ((map.cells[i][j].getType()).equals(type)){
                    sameSymbolCounter += 1;
                    if (sameSymbolCounter>=dotsForWin){
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
                    checkDiagonal(i, 0, type, "main")||
                    checkDiagonal(0, i, type,"main")||
                    checkDiagonal(i, 0, type, "reverse")||
                    checkDiagonal(0, i, type,"reverse")
            ) return true;
        }
        return false;
    }

    private boolean checkDiagonal (int startRow, int startCol, CellType type, String direction){
        int quantityDotsOnDiagonal=map.size;
        int sameSymbolCounter;

        if (startRow>=0&&direction.equals("main")) {

            quantityDotsOnDiagonal -= startRow;
            if (quantityDotsOnDiagonal < dotsForWin) return false;

            sameSymbolCounter = 0;
            for (int i = startCol; i < quantityDotsOnDiagonal; i++) {
                if ((map.cells[i+startRow][i].getType()).equals(type)) {
                    sameSymbolCounter += 1;
                    if (sameSymbolCounter >= dotsForWin) {
                        return true;
                    }
                } else {
                    sameSymbolCounter = 0;
                }
            }
        }

        if (startCol>=0&&direction.equals("main")) {

            quantityDotsOnDiagonal -= startCol;
            if (quantityDotsOnDiagonal < dotsForWin) return false;

            sameSymbolCounter = 0;
            for (int i = startRow; i < quantityDotsOnDiagonal; i++) {
                if ((map.cells[i][+startCol].getType()).equals(type)) {
                    sameSymbolCounter += 1;
                    if (sameSymbolCounter >= dotsForWin) {
                        return true;
                    }
                } else {
                    sameSymbolCounter = 0;
                }
            }
        }

        if (startRow>=0&&direction.equals("reverse")){

            quantityDotsOnDiagonal = map.size - startRow;
            sameSymbolCounter=0;

            for (int i = startCol; i < quantityDotsOnDiagonal; i++) {
                if ((map.cells[i+startRow][map.size-1-i].getType()).equals(type)){
                    sameSymbolCounter += 1;
                    if (sameSymbolCounter>=dotsForWin){
                        return true;
                    }
                } else {
                    sameSymbolCounter=0;
                }
            }
        }

        if (startCol<(map.size-1)&&direction.equals("reverse")){

            quantityDotsOnDiagonal = startCol+1;
            sameSymbolCounter=0;

            for (int i = startRow; i < quantityDotsOnDiagonal; i++) {
                if ((map.cells[i][startCol-i].getType()).equals(type)){
                    sameSymbolCounter += 1;
                    if (sameSymbolCounter>=dotsForWin){
                        return true;
                    }
                } else {
                    sameSymbolCounter=0;
                }
            }
        }

        return false;
    }

    public void humanTurn() {
        int rowNumber, colNumber;
        do {
            System.out.println("Ход пользователя. Введите номер строки и столбца");
            System.out.print("Строка = ");
            rowNumber = scanner.nextInt();
            System.out.print("Колонка = ");
            colNumber = scanner.nextInt();
        } while (!map.isCellValid(rowNumber, colNumber));

        map.cells[rowNumber - 1][colNumber - 1].putCross();
    }

    public void gameOver (){
        if (checkEnd(CellType.CROSS)){
            System.out.println("Поздравляю, Вы победили");
        }
        if (checkEnd(CellType.ZERO)){
            System.out.println("Вы проиграли");
        }
        if (map.isFull()){
            System.out.println("Ничья");
        }
    }
}
