package ru.geekbrains.valerych.lesson3;

import java.util.Random;
import java.util.Scanner;

public class DigitsGame {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int rightAnswer;
        int userAnswer;
        int tries=3;
        System.out.println("Приветствую Вас в игре угадай число!\n" +
                        "Сейчас я загадаю число от 0 до 9. Вам предстоит отгадать его за три попытки");

        do {
            rightAnswer = random.nextInt(10);
            int userTry;
            for (userTry = 0; userTry < tries; userTry++) {
                System.out.println("Ваша " + (userTry+1) + "-я попытка. Введите число от 0 до 9");
                userAnswer = scanner.nextInt();
                System.out.println();
                if (userAnswer < rightAnswer) {
                    if (userTry<tries-1){
                        System.out.println("Неверно. Ваше число меньше загаданного");
                    }
                } else if (userAnswer > rightAnswer) {
                    if (userTry<tries-1){
                        System.out.println("Неверно. Ваше число больше загаданного");
                    }
                } else {
                    System.out.println("Верно! Поздравляю с победой!");
                    break;
                }
                if (userTry==tries-1){
                    System.out.println("Попытки закончились. Вы проиграли. А правильным ответом было число " + rightAnswer);
                }
            }
            do {
                System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
                userAnswer = scanner.nextInt();
            } while (userAnswer!=0&&userAnswer!=1);

        } while (userAnswer!=0);


    }
}
