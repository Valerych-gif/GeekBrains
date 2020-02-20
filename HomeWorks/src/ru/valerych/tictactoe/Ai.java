package ru.valerych.tictactoe;

import java.util.Random;

public class Ai {

    private Map map;
    private Game game;
    private Random random = new Random();
    Cell lastHumanTurn;


    Ai(Map map, Game game) {
        this.map = map;
        this.game = game;
    }

    public void aiTurn(int tries) {
        Cell cell;
        lastHumanTurn = game.getLastHumanTurn();

        if ((cell=tryToWin(1))!=null){
            cell.putZero();
            return;
        } else if ((cell=tryToDoNotLose(1))!=null){
            System.out.println("tryToDoNotLose");
            cell.putZero();
            return;
        }

        for (int i = 0; i < map.size-2; i++) {
            for (int j = 0; j < map.size - 2; j++) {
                if (map.isCellValid(i+1, j+1)&&horizontalDanger(i, j)) {
                    map.cells[i][j].putZero();
                    return;
                }
                if (map.isCellValid(i+1,j+1)&&verticalDanger(i, j)) {
                    map.cells[i][j].putZero();
                    return;
                }
                if (map.isCellValid(i+1,j+1)&&mainDiagonalDanger(i, j)) {
                    map.cells[i][j].putZero();
                    return;
                }
//                if (reverseDiagonalDanger(i, j)) {
//                    map.cells[i][j].putZero();
//                    return;
//                }
            }
        }

        for (int i = tries; i > 1; i--) {
            if ((cell=tryToWin(i))!=null){
                cell.putZero();
                return;
            } else if ((cell=tryToDoNotLose(i))!=null){
                cell.putZero();
                return;
            }

        }
            doRandomTurn();
    }

    private boolean verticalDanger(int x, int y) {
        for (int i = 0; i < game.dotsForWin-2; i++) {
            if (map.cells[x+i+1][y].getType()!=CellType.CROSS){
                return false;
            }
        }
        return true;
    }

    private boolean horizontalDanger(int x, int y) {
        for (int i = 0; i < game.dotsForWin-2; i++) {
            if (map.cells[x][y+i+1].getType()!=CellType.CROSS){
                return false;
            }
        }
        return true;
    }

    private boolean mainDiagonalDanger(int x, int y) {
        for (int i = 0; i < game.dotsForWin-2; i++) {
            if (map.cells[x+i+1][y+i+1].getType()!=CellType.CROSS){
                return false;
            }
        }
        return true;
    }

//    private boolean reverseDiagonalDanger(int x, int y) {
//        for (int i = 0; i < game.dotsForWin-2; i++) {
//            if (map.cells[x+i+1][y+i+1].getType()!=CellType.CROSS){
//                return false;
//            }
//        }
//        return true;
//    }

    private Cell tryToWin (int tries){

        if (tries<=0) return null;
        for (int i = 0; i < map.size; i++) {
            for (int j=0; j < map.size; j++) {
                if (map.isCellValid(i+1, j+1) && isWinnable(i+1, j+1, tries)) {
                     return map.cells[i][j];
                }
            }
        }
        return null;
    }

    private Cell tryToDoNotLose (int tries){
        if (tries<=0) return null;
        for (int i = 0; i < map.size; i++) {
            for (int j=0; j < map.size; j++) {
                if (map.isCellValid(i+1, j+1) && isLosable(i+1, j+1, tries)) {
                    return map.cells[i][j];
                }
            }
        }
        return null;
    }

    private void doRandomTurn(){
        int rowNumber, colNumber;
        do {
            rowNumber = random.nextInt(map.size) + 1;
            colNumber = random.nextInt(map.size) + 1;
        } while (!map.isCellValid(rowNumber, colNumber));

        map.cells[rowNumber - 1][colNumber - 1].putZero();
    }

    private boolean isLosable(int rowNumber, int colNumber, int tries) {

        map.cells[rowNumber - 1][colNumber - 1].putCross();

        if (game.checkWin(CellType.CROSS)) {
            map.cells[rowNumber - 1][colNumber - 1].clear();
            return true;
        } else {
            if (tryToDoNotLose(--tries)!=null) {
                map.cells[rowNumber - 1][colNumber - 1].clear();
                return true;
            }
            map.cells[rowNumber - 1][colNumber - 1].clear();
            return false;
        }

    }

    private boolean isWinnable(int rowNumber, int colNumber, int tries) {

        map.cells[rowNumber - 1][colNumber - 1].putZero();

        if (game.checkWin(CellType.ZERO)) {
            map.cells[rowNumber - 1][colNumber - 1].clear();
            return true;
        } else {
            if (tryToWin(--tries)!=null) {
                map.cells[rowNumber - 1][colNumber - 1].clear();
                return true;
            }
            map.cells[rowNumber - 1][colNumber - 1].clear();
            return false;
        }

    }

}
