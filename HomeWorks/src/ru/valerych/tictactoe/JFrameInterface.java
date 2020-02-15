package ru.valerych.tictactoe;

import javax.swing.*;
import java.awt.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Scanner;

public class JFrameInterface extends GameInterface {
    private final int X_POSITION = 200;
    private final int Y_POSITION = 200;
    Map map;
    JFrame gameWindow;
    public Pole[][] areas;
    JPanel[] row;
    int colNumber, rowNumber;

    class Pole extends JTextArea {
        int colN, rowN;
    }

    public JFrameInterface(Map map) {
        this.map = map;
        gameWindow = new JFrame("TicTacToe");
        gameWindow.setAlwaysOnTop(true);
        gameWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        gameWindow.setBounds(X_POSITION, Y_POSITION, 50*map.size, 50*map.size+50);
        gameWindow.setResizable(false);
        gameWindow.setLayout(new BoxLayout(gameWindow.getContentPane(), BoxLayout.Y_AXIS));
        areas = new Pole[map.size + 1][map.size + 1];
        row = new JPanel[map.size];

        for (int i = 0; i < map.size; i++) {
            row[i] = new JPanel();
            for (int j = 0; j < map.size; j++) {

                areas[i][j] = new Pole();
                areas[i][j].colN = j;
                areas[i][j].rowN = i;
                areas[i][j].setEditable(false);
                areas[i][j].setFont(new Font("Dialog", Font.PLAIN, 42));
                areas[i][j].setPreferredSize(new Dimension(40, 40));
                int finalI = i;
                int finalJ = j;
                areas[i][j].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        setInputCoord(areas[finalI][finalJ].rowN+1, areas[finalI][finalJ].colN+1);
                    }
                });

                row[i].add(areas[i][j]);
            }
            gameWindow.add(row[i]);
            gameWindow.setVisible(true);
        }
    }

    private void setInputCoord(int rowNumber, int colNumber) {
        this.colNumber = colNumber;
        this.rowNumber = rowNumber;
    }

    @Override
    public void turnInput() {

        while (!map.isCellValid(rowNumber, colNumber)){
            System.out.print(""); // С пустым телом цикла не работает
        }

        map.cells[rowNumber - 1][colNumber - 1].putCross();

    }

    @Override
    public void print() {

        for (int i = 0; i < map.size; i++) {
            for (int j = 0; j < map.size; j++) {
                char symbol = map.cells[i][j].toChar()=='•'?' ':map.cells[i][j].toChar();
                areas[i][j].setMargin(new Insets(-5,4,5,5));
                areas[i][j].setText(String.valueOf(symbol));
            }
        }
    }

    @Override
    public void gameOver(Game game) {
        if (game.checkEnd(CellType.CROSS)) {
            JOptionPane.showMessageDialog(gameWindow, "Поздравляю, Вы победили!");
        }
        if (game.checkEnd(CellType.ZERO)) {
            JOptionPane.showMessageDialog(gameWindow, "Вы проиграли");
        }
        if (map.isFull()) {
            JOptionPane.showMessageDialog(gameWindow, "Ничья");
        }
    }
}