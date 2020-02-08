package ru.geekbrains.valerych.lesson7;

public class Cat {

    private final String name;
    private int appetite;
    private boolean satiety=false;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public Cat(String name) {
        this.name=name;
        this.appetite = (int)(Math.random()*20+20);
    }

    public String getName() {
        return name;
    }

    public int getAppetite() {
        return appetite;
    }

    public boolean isSatiety() {
        return satiety;
    }

    public void setAppetite(int appetite) {
        this.appetite = appetite;
    }

    public void eat(Plate plate) {
        this.satiety = plate.decreaseFood(appetite) >= 0;
    }

    public void toFeedCat(Cat cat, Plate plate) {
        int food = plate.getFood();
        eat(plate);
        if (isSatiety()){
            System.out.printf("%s съел %d из тарелки, он сыт и доволен%n", getName(), appetite);
        } else {
            System.out.printf("%s зол. Он хотел съесть %d из тарелки, но там было всего %d. Он все съел, но остался голодным%n", getName(), appetite, food);
        }
    }
}