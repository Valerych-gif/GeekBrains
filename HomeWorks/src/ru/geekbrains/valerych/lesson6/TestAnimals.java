package ru.geekbrains.valerych.lesson6;

public class TestAnimals {
    public static void main(String[] args) {
        Dog sharik = new Dog("Шарик", "Белый", 4);
        Dog bobik = new Dog("Бобик", "Черный", 7);
        Cat murzik = new Cat("Мурзик", "Рыжий", 2);
        Cat leopold = new Cat("Леопольд", "Цветной", 6);

        sharik.printInfo();
        bobik.printInfo();
        murzik.printInfo();
        leopold.printInfo();

        if (bobik.swim(50)){
            System.out.printf("%s доплыл%n", bobik.getName());
        } else {
            System.out.printf("%s не доплыл%n", bobik.getName());
        }

        if (sharik.swim(5)){
            System.out.printf("%s доплыл%n", sharik.getName());
        } else {
            System.out.printf("%s не доплыл%n", sharik.getName());
        }
    }
}
