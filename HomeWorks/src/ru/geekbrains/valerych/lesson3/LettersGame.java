package ru.geekbrains.valerych.lesson3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class LettersGame {

    public static void main(String[] args) {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        String rightAnswer = words[new Random().nextInt(words.length)];
        String userAnswer;
        System.out.println("Hello and welcome to the Letter's Game!");
        System.out.println("Now the computer will choice one of the words below:");
        System.out.println(Arrays.toString(words));
        System.out.println("You need to type your guess. If you guess the word exactly you win, else the computer show you letters, which stand right and repeat the question.");

        Scanner scanner = new Scanner(System.in);
        boolean isAnswerRight;
        do{
            System.out.println("What is your guess?");
            userAnswer = scanner.next();
            userAnswer = userAnswer.toLowerCase();
            isAnswerRight = isAnswerRight(userAnswer, rightAnswer);
            if (isAnswerRight){
                System.out.println("You're right!");
            } else {
                showLetters(userAnswer, rightAnswer);
            }
        }while (!isAnswerRight);
    }

    private static void showLetters(String userAnswer, String rightAnswer) {

        int rightAnswerLength = rightAnswer.length();
        int userAnswerLength = userAnswer.length();
        StringBuilder answerToShow= new StringBuilder();
        for (int i = 0; (i < rightAnswerLength)&&(i<userAnswerLength); i++) {
            char userAnswerChar = userAnswer.charAt(i);
            char rightAnswerChar = rightAnswer.charAt(i);
            if (userAnswerChar==rightAnswerChar){
                answerToShow.append(rightAnswerChar);
            } else {
                answerToShow = new StringBuilder(answerToShow.toString().concat("#"));
            }
        }
        int answerToShowLength = answerToShow.length();
        for (int i = 0; i < (15 - answerToShowLength); i++) {
            answerToShow = new StringBuilder(answerToShow.toString().concat("#"));
        }
        System.out.println(answerToShow);
    }

    private static boolean isAnswerRight(String userAnswer, String rightAnswer) {
        if (userAnswer.compareTo(rightAnswer)==0){
            return true;
        }
        return false;
    }
}
