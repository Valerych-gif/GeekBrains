package ru.geekbrains.valerych.lesson4;

import java.util.Random;

public class Ai {

    private Map map;
    private Game game;
    private Random random = new Random();

    Ai (Map map, Game game){
        this.map=map;
        this.game=game;
    }

    public void aiTurn() {
        System.out.println("Ход компьютера");
        int rowNumber, colNumber;

        for (int i = 0; i < map.size; i++) {
            for (int j = 0; j < map.size; j++) {
                rowNumber=i+1;
                colNumber=j+1;
                if (map.isCellValid(rowNumber,colNumber)&&isWinnable (rowNumber, colNumber)){
                    map.cells[rowNumber - 1][colNumber - 1] = map.DOT_O;
                    return;
                }
            }
        }

        for (int i = 0; i < map.size; i++) {
            for (int j = 0; j < map.size; j++) {
                rowNumber=i+1;
                colNumber=j+1;
                if (map.isCellValid(rowNumber,colNumber)&&isLosable (rowNumber, colNumber)){
                    map.cells[rowNumber - 1][colNumber - 1] = map.DOT_O;
                    return;
                }
            }
        }

        do {
            rowNumber = random.nextInt(map.size) + 1;
            colNumber = random.nextInt(map.size) + 1;
        } while (!map.isCellValid(rowNumber, colNumber));

        map.cells[rowNumber - 1][colNumber - 1] = map.DOT_O;
    }

    private boolean isLosable(int rowNumber, int colNumber) {
        map.cells[rowNumber - 1][colNumber - 1] = map.DOT_X;
        if (game.checkWin(map.DOT_X)){
            map.cells[rowNumber - 1][colNumber - 1] = map.DOT_EMPTY;
            return true;
        } else {
            map.cells[rowNumber - 1][colNumber - 1] = map.DOT_EMPTY;
            return false;
        }

    }

    private boolean isWinnable(int rowNumber, int colNumber) {
        map.cells[rowNumber - 1][colNumber - 1] = map.DOT_O;
        if (game.checkWin(map.DOT_O)){
            map.cells[rowNumber - 1][colNumber - 1] = map.DOT_EMPTY;
            return true;
        } else {
            map.cells[rowNumber - 1][colNumber - 1] = map.DOT_EMPTY;
            return false;
        }

    }

}
