package ru.geekbrains.valerych.lesson4;

public class TicTacToe {

    public static final int SIZE = 5;
    public static final int DOTS_FOR_WIN = 4;

    public static void main(String[] args) {

        Map map = new Map(SIZE);
        Game game = new Game(map, DOTS_FOR_WIN);
        Ai ai = new Ai(map, game);
        boolean gameOver;

        map.print();

        do{
            game.play(ai);
            gameOver = game.checkEnd(map.DOT_X)||game.checkEnd(map.DOT_O)||map.isFull();
        }while (!gameOver);

        game.gameOver();
    }










}
