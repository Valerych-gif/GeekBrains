package ru.geekbrains.valerych.lesson4;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    private static final int SIZE = 5;
    private static final char DOT_EMPTY = '•';
    private static final char DOT_X = 'X';
    private static final char DOT_O = 'O';
    private static final String EMPTY_COLUMN_TITLE = "  ";
    private static final int DOTS_FOR_WIN = 4;

    private static char[][] map;
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    public static void main(String[] args) {
        initMap();
        printMap();
        playGame();
        System.out.println("Игра окончена!");
    }

    private static void playGame() {
        while (true) {
            humanTurn();
            printMap();

            if (checkEnd(DOT_X, "Пользователь победил!"))
                break;

            aiTurn();
            printMap();
            if (checkEnd(DOT_O, "Компьютер победил!"))
                break;
        }
    }

    private static boolean checkEnd(char symbol, String winMessage) {
        if (checkWin(symbol)) {
            System.out.println(winMessage);
            return true;
        }
        if (isMapFull()) {
            System.out.println("Ничья!");
            return true;
        }
        return false;
    }

    private static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean checkWin(char symbol) {
        return checkRows(symbol)||checkCols(symbol)||checkDiagonals(symbol);

    }

    private static boolean checkRows(char symbol) {
        int sameSymbolCounter;
        for (int i = 0; i < SIZE; i++) {
            sameSymbolCounter = 0;
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j]==symbol){
                    sameSymbolCounter += 1;
                    if (sameSymbolCounter>=DOTS_FOR_WIN){
                        return true;
                    }
                } else {
                    sameSymbolCounter=0;
                }
            }
        }
        return false;
    }

    private static boolean checkCols(char symbol) {
        int sameSymbolCounter;
        for (int i = 0; i < SIZE; i++) {
            sameSymbolCounter = 0;
            for (int j = 0; j < SIZE; j++) {
                if (map[j][i]==symbol){
                    sameSymbolCounter += 1;
                    if (sameSymbolCounter>=DOTS_FOR_WIN){
                        return true;
                    }
                } else {
                    sameSymbolCounter = 0;
                }
            }
        }
        return false;
    }

    private static boolean checkDiagonals(char symbol) {
        return checkMainDiagonals(symbol)||checkReverseDiagonals(symbol);
    }

    private static boolean checkMainDiagonals(char symbol) {
        int quantityDotsOnDiagonal;
        int sameSymbolCounter;

        for (int i = 0; i < SIZE; i++) {
            quantityDotsOnDiagonal = SIZE - i;
            sameSymbolCounter=0;
            for (int j = 0; j < quantityDotsOnDiagonal; j++) {
                if (map[j][j+i]==symbol){
                    sameSymbolCounter += 1;
                    if (sameSymbolCounter>=DOTS_FOR_WIN){
                        return true;
                    }
                } else {
                    sameSymbolCounter=0;
                }
            }
        }

        for (int i = 0; i < SIZE; i++) {
            quantityDotsOnDiagonal = SIZE - i;
            sameSymbolCounter=0;
            for (int j = 0; j < quantityDotsOnDiagonal; j++) {
                if (map[j+i][j]==symbol){
                    sameSymbolCounter += 1;
                    if (sameSymbolCounter>=DOTS_FOR_WIN){
                        return true;
                    }
                } else {
                    sameSymbolCounter=0;
                }
            }
        }

        return false;
    }

    private static boolean checkReverseDiagonals(char symbol) {
        int quantityDotsOnDiagonal;
        int sameSymbolCounter;

        for (int i = 0; i < SIZE; i++) {
            quantityDotsOnDiagonal = SIZE - i;
            sameSymbolCounter=0;
            for (int j = 0; j < quantityDotsOnDiagonal; j++) {
                if (map[j][SIZE-1-(j+i)]==symbol){
                    sameSymbolCounter += 1;
                    if (sameSymbolCounter>=DOTS_FOR_WIN){
                        return true;
                    }
                } else {
                    sameSymbolCounter=0;
                }
            }
        }

        for (int i = 0; i < SIZE; i++) {
            quantityDotsOnDiagonal = SIZE - i;
            sameSymbolCounter = 0;
            for (int j = 0; j < quantityDotsOnDiagonal; j++) {
                if (map[SIZE - 1 - (j + i)][j] == symbol) {
                    sameSymbolCounter += 1;
                    if (sameSymbolCounter >= DOTS_FOR_WIN) {
                        return true;
                    }
                } else {
                    sameSymbolCounter=0;
                }
            }
        }

        return false;
    }

    private static void humanTurn() {
        int rowNumber, colNumber;
        do {
            System.out.println("Ход пользователя. Введите номер строки и столбца");
            System.out.print("Строка = ");
            rowNumber = scanner.nextInt();
            System.out.print("Колонка = ");
            colNumber = scanner.nextInt();
        } while (!isCellValid(rowNumber, colNumber));

        map[rowNumber - 1][colNumber - 1] = DOT_X;
    }

    private static void aiTurn() {
        System.out.println("Ход компьютера");
        int rowNumber, colNumber;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                rowNumber=i+1;
                colNumber=j+1;
                if (isCellValid(rowNumber,colNumber)&&isWinnable (rowNumber, colNumber)){
                    map[rowNumber - 1][colNumber - 1] = DOT_O;
                    return;
                }
            }
        }

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                rowNumber=i+1;
                colNumber=j+1;
                if (isCellValid(rowNumber,colNumber)&&isLosable (rowNumber, colNumber)){
                    map[rowNumber - 1][colNumber - 1] = DOT_O;
                    return;
                }
            }
        }

        do {
            rowNumber = random.nextInt(SIZE) + 1;
            colNumber = random.nextInt(SIZE) + 1;
        } while (!isCellValid(rowNumber, colNumber));

        map[rowNumber - 1][colNumber - 1] = DOT_O;
    }

    private static boolean isLosable(int rowNumber, int colNumber) {
        map[rowNumber - 1][colNumber - 1] = DOT_X;
        if (checkWin(DOT_X)){
            map[rowNumber - 1][colNumber - 1] = DOT_EMPTY;
            return true;
        } else {
            map[rowNumber - 1][colNumber - 1] = DOT_EMPTY;
            return false;
        }

    }

    private static boolean isWinnable(int rowNumber, int colNumber) {
        map[rowNumber - 1][colNumber - 1] = DOT_O;
        if (checkWin(DOT_O)){
            map[rowNumber - 1][colNumber - 1] = DOT_EMPTY;
            return true;
        } else {
            map[rowNumber - 1][colNumber - 1] = DOT_EMPTY;
            return false;
        }

    }


    private static boolean isCellValid(int rowNumber, int colNumber) {
        if (rowNumber < 1 || rowNumber > SIZE)
            return false;
        if (colNumber < 1 || colNumber > SIZE)
            return false;

        return map[rowNumber - 1][colNumber - 1] == DOT_EMPTY;
    }

    private static void printMap() {
        printMapHeader();
        printMapRows();
    }

    private static void printMapRows() {
        for (int i = 0; i < SIZE; i++) {
            printColumnNumber(i);
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void printColumnNumber(int i) {
        int columnNumber = i + 1;
        System.out.print(columnNumber + " ");
    }

    private static void printMapHeader() {
        printEmptyHeaderForFirstColumn();
        for (int i = 0; i < SIZE; i++) {
            printColumnNumber(i);
        }
        System.out.println();
    }

    private static void printEmptyHeaderForFirstColumn() {
        System.out.print(EMPTY_COLUMN_TITLE);
    }

    private static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }
}
