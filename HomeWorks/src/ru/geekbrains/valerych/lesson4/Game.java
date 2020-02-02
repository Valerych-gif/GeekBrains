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

    public void play(Ai ai) {
            humanTurn();
            map.print();

            if (checkEnd(map.DOT_X)){
                return;
            }

            ai.aiTurn();
            map.print();
            if (checkEnd(map.DOT_O)){
                return;
            }
    }

    public boolean checkEnd(char symbol) {
        if (checkWin(symbol)) {
            return true;
        }
        if (map.isFull()) {
            return true;
        }
        return false;
    }

    public boolean checkWin(char symbol) {
        return checkRows(symbol)||checkCols(symbol)||checkDiagonals(symbol);

    }

    private boolean checkRows(char symbol) {
        int sameSymbolCounter;
        for (int i = 0; i < map.size; i++) {
            sameSymbolCounter = 0;
            for (int j = 0; j < map.size; j++) {
                if (map.cells[i][j]==symbol){
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

    private boolean checkCols(char symbol) {
        int sameSymbolCounter;
        for (int i = 0; i < map.size; i++) {
            sameSymbolCounter = 0;
            for (int j = 0; j < map.size; j++) {
                if (map.cells[j][i]==symbol){
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

    private boolean checkDiagonals(char symbol) {
        return checkMainDiagonals(symbol)||checkReverseDiagonals(symbol);
    }

    private boolean checkMainDiagonals(char symbol) {
        int quantityDotsOnDiagonal;
        int sameSymbolCounter;

        for (int i = 0; i < map.size; i++) {
            quantityDotsOnDiagonal = map.size - i;
            sameSymbolCounter=0;
            for (int j = 0; j < quantityDotsOnDiagonal; j++) {
                if (map.cells[j][j+i]==symbol){
                    sameSymbolCounter += 1;
                    if (sameSymbolCounter>=dotsForWin){
                        return true;
                    }
                } else {
                    sameSymbolCounter=0;
                }
            }
        }

        for (int i = 0; i < map.size; i++) {
            quantityDotsOnDiagonal = map.size - i;
            sameSymbolCounter=0;
            for (int j = 0; j < quantityDotsOnDiagonal; j++) {
                if (map.cells[j+i][j]==symbol){
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

    private boolean checkReverseDiagonals(char symbol) {
        int quantityDotsOnDiagonal;
        int sameSymbolCounter;

        for (int i = 0; i < map.size; i++) {
            quantityDotsOnDiagonal = map.size - i;
            sameSymbolCounter=0;
            for (int j = 0; j < quantityDotsOnDiagonal; j++) {
                if (map.cells[j][map.size-1-(j+i)]==symbol){
                    sameSymbolCounter += 1;
                    if (sameSymbolCounter>=dotsForWin){
                        return true;
                    }
                } else {
                    sameSymbolCounter=0;
                }
            }
        }

        for (int i = 0; i < map.size; i++) {
            quantityDotsOnDiagonal = map.size - i;
            sameSymbolCounter = 0;
            for (int j = 0; j < quantityDotsOnDiagonal; j++) {
                if (map.cells[map.size - 1 - (j + i)][j] == symbol) {
                    sameSymbolCounter += 1;
                    if (sameSymbolCounter >= dotsForWin) {
                        return true;
                    }
                } else {
                    sameSymbolCounter=0;
                }
            }
        }

        return false;
    }

    private void humanTurn() {
        int rowNumber, colNumber;
        do {
            System.out.println("Ход пользователя. Введите номер строки и столбца");
            System.out.print("Строка = ");
            rowNumber = scanner.nextInt();
            System.out.print("Колонка = ");
            colNumber = scanner.nextInt();
        } while (!map.isCellValid(rowNumber, colNumber));

        map.cells[rowNumber - 1][colNumber - 1] = map.DOT_X;
    }

    public void gameOver (){
        if (checkEnd(map.DOT_X)){
            System.out.println("Поздравляю, Вы победили");
        }
        if (checkEnd(map.DOT_O)){
            System.out.println("Вы проиграли");
        }
        if (map.isFull()){
            System.out.println("Ничья");
        }
    }
}
