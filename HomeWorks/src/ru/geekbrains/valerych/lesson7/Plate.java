package ru.geekbrains.valerych.lesson7;

public class Plate {

    private static final int MAX_PLATE_CAPACITY = 100;

    private int food;

    public Plate() {
        this.food=MAX_PLATE_CAPACITY;
    }

    public Plate(int food) {
        this.food = food;
    }

    public void info() {
        System.out.println(this);
    }

    public int getFood() {
        return food;
    }

    public void putFood(int food) {
        int f=this.food + food;
        this.food=f>MAX_PLATE_CAPACITY?MAX_PLATE_CAPACITY:f;
    }

    public int decreaseFood(int n) {
        int plateBallance=this.food-n;
        this.food=plateBallance>0?plateBallance:0;
        return plateBallance;
    }

    @Override
    public String toString() {
        return "Plate{" +
                "food=" + food +
                '}';
    }
}