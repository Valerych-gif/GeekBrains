package ru.valerych.tictactoe;

import java.util.Scanner;

public class TextInterface extends GameInterface{

    private static final String EMPTY_COLUMN_TITLE = "  ";

    Map map;

    public TextInterface(Map map) {
        this.map = map;
    }

    @Override
    public void turnInput() {
        Scanner scanner = new Scanner(System.in);
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

    @Override
    public void print() {
        printHeader();
        printRows();
    }

    public void printRows() {
        for (int i = 0; i < map.size; i++) {
            printColumnNumber(i);
            for (int j = 0; j < map.size; j++) {
                System.out.print(map.cells[i][j].toChar() + " ");
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
        for (int i = 0; i < map.size; i++) {
            printColumnNumber(i);
        }
        System.out.println();
    }

    public void printEmptyHeaderForFirstColumn() {
        System.out.print(EMPTY_COLUMN_TITLE);
    }

    @Override
    public void gameOver (Game game){
        if (game.checkEnd(CellType.CROSS)){
            System.out.println("Поздравляю, Вы победили");
        }
        if (game.checkEnd(CellType.ZERO)){
            System.out.println("Вы проиграли");
        }
        if (map.isFull()){
            System.out.println("Ничья");
        }
    }
}
