package ru.geekbrains.valerych.lesson6;

public abstract class Animal {

    protected String name;
    private String color;
    private int age;
    protected float maxHeightOfJump;
    protected float maxDistanceOfRun;
    protected float maxDistanceOfSwim;

    public Animal(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getAge() {
        return age;
    }

    public void printInfo() {
        System.out.printf(" Кличка = %s%n Цвет = %s%n Возраст = %d%n Максимальная дистанция бега = %f%n Максимальная высота прыжка = %f%n Максимальная дистанция плавания = %f%n%n",
                name,
                color,
                age,
                maxDistanceOfRun,
                maxHeightOfJump,
                maxDistanceOfSwim);
    }


    public boolean jump(int height) {
        return height<=maxHeightOfJump;
    }

    public boolean run(int distance) {
        return distance<=maxDistanceOfRun;
    }

    public boolean swim(int distance) {
        return distance<=maxDistanceOfSwim;
    }

}