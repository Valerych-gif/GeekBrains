package ru.valerych.tictactoe;

import java.util.Random;

public class Ai {

    private Map map;
    private Game game;
    private Random random = new Random();

    Ai(Map map, Game game) {
        this.map = map;
        this.game = game;
    }

    public void aiTurn() {

        tryToWin();
        tryToDoNotLose();
        doRandomTurn();

    }

    private void tryToWin (){

        for (int i = 0; i < map.size; i++) {
            for (int j = 0; j < map.size; j++) {

                if (map.isCellValid(i+1, j+1) && isWinnable(i+1, j+1)) {
                    map.cells[i][j].putZero();
                    return;
                }
            }
        }
    }

    private void tryToDoNotLose (){
        for (int i = 0; i < map.size; i++) {
            for (int j = 0; j < map.size; j++) {
                if (map.isCellValid(i+1, j+1) && isLosable(i+1, j+1)) {
                    map.cells[i][j].putZero();
                    return;
                }
            }
        }
    }

    private void doRandomTurn(){
        int rowNumber, colNumber;
        do {
            rowNumber = random.nextInt(map.size) + 1;
            colNumber = random.nextInt(map.size) + 1;
        } while (!map.isCellValid(rowNumber, colNumber));

        map.cells[rowNumber - 1][colNumber - 1].putZero();
    }

    private boolean isLosable(int rowNumber, int colNumber) {

        map.cells[rowNumber - 1][colNumber - 1].putCross();
        if (game.checkWin(CellType.CROSS)) {
            map.cells[rowNumber - 1][colNumber - 1].clear();
            return true;
        }
        map.cells[rowNumber - 1][colNumber - 1].clear();
        return false;
    }

    private boolean isWinnable(int rowNumber, int colNumber) {
        map.cells[rowNumber - 1][colNumber - 1].putZero();
        if (game.checkWin(CellType.ZERO)) {
            map.cells[rowNumber - 1][colNumber - 1].clear();
            return true;
        } else {
            map.cells[rowNumber - 1][colNumber - 1].clear();
            return false;
        }

    }

}
