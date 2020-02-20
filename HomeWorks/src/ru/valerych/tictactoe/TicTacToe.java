package ru.valerych.tictactoe;

public class TicTacToe {

    public static final int SIZE = 15;
    public static final int DOTS_FOR_WIN = 5;
    public static final String MODE="GRAPHIC_MODE";
    public static final int EASY = 0;
    public static final int MEDIUM = 1;
    public static final int HARD = 2;

    public static void main(String[] args) {


        Map map = new Map(SIZE);
        Game game = new Game(map, DOTS_FOR_WIN);
        Ai ai = new Ai(map, game);
        int tries = TicTacToe.HARD;

        GameInterface gameInterface;
        if (MODE=="TEXT_MODE"){
            gameInterface = new TextInterface(map);
        } else {
            gameInterface = new JFrameInterface(map, game);
        }

        gameInterface.print();

        do{

            gameInterface.turnInput();
            gameInterface.print();
            if (game.checkEnd(CellType.CROSS)) break;

            ai.aiTurn(tries);
            gameInterface.print();
            if (game.checkEnd(CellType.ZERO)) break;

            if (map.isFull()) break;

        }while (true);

        gameInterface.gameOver(game);
    }

}
