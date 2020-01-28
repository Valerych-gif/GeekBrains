package ru.geekbrains.valerych.lesson5;

public class TestEmployee {
    public static void main(String[] args) {
        Employee employee1 = new Employee(
                "Ivanov Ivan Ivanovich",
                "Just Engineer",
                "IvanovII@yandex.ru",
                "8 (800) 800-80-80",
                25000.00f,
                23);

        employee1.info();

        Employee employee2 = new Employee(
                "Petrov Petr Petrovich",
                "Mega Engineer",
                "PetrovPP@yandex.ru",
                "8 (800) 800-80-81",
                employee1.getSalary() + 10000.00f,
                27);

        employee2.info();

        Employee employee3 = new Employee(
                "Sidorov Sidor Sidorovich",
                "Mega Boss",
                "SidorovSS@yandex.ru",
                "8 (800) 800-80-82",
                27);

        employee3.info();

        employee3.setSalary(employee3.getSalary()*5);

        employee3.info();

    }
}
