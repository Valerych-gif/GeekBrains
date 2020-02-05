package ru.geekbrains.valerych.lesson4;

public class TicTacToe {

    public static final int SIZE = 5;
    public static final int DOTS_FOR_WIN = 4;

    public static void main(String[] args) {

        Map map = new Map(SIZE);
        Game game = new Game(map, DOTS_FOR_WIN);
        Ai ai = new Ai(map, game);
        map.print();

        do{

            game.humanTurn();
            map.print();
            if (game.checkEnd(CellType.CROSS)) break;

            ai.aiTurn();
            map.print();
            if (game.checkEnd(CellType.ZERO)) break;

            if (map.isFull()) break;

        }while (true);

        game.gameOver();
    }










}
