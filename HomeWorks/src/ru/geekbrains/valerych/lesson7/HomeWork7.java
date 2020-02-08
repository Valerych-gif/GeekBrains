package ru.geekbrains.valerych.lesson7;

public class HomeWork7 {

    public static final int CATS_QUANTITY=8;
    public static void main(String[] args) {
        Cat[] cat = new Cat[CATS_QUANTITY];
        for (int i = 0; i < CATS_QUANTITY; i++) {
            cat[i] = new Cat("Котяра №" + (i+1));
        }
        Plate plate = new Plate(100);

        for (int i = 0; i<CATS_QUANTITY&&cat[i]!=null; i++) {
            cat[i].toFeedCat(cat[i], plate);
            plate.info();
            if (i%5==0){
                System.out.println("Кладем в тареку еды");
                plate.putFood(25);
                plate.info();
            }

        }
    }
}