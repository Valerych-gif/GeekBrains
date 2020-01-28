package ru.geekbrains.valerych.lesson5;

public class EmployeesArray {
    public static void main(String[] args) {
        Employee[] employees = new Employee[5];

        employees[0] = new Employee(
                "John Smith",
                "Mega Boss",
                "Jonny@gmail.com",
                "+ 1 (631) 555-55-51",
                27);

        employees[1] = new Employee(
                "Lazy Man",
                "Mega Boss",
                "LM@gmail.com",
                "+ 1 (631) 555-55-52",
                10000,
                29);

        employees[2] = new Employee(
                "Richard the Lionheart",
                "King",
                "mymajesty@gmail.com",
                "+ 1 (631) 555-55-53",
                1_000_000f,
                41);

        employees[3] = new Employee(
                "Vinny The Pooh",
                "Leader",
                "honey@gmail.com",
                "+ 1 (631) 555-55-54",
                100_000f,
                5);

        employees[4] = new Employee(
                "Bruce Wayne",
                "Leader",
                "batman@brucewayne.com",
                "+ 1 (555) 100-00-00",
                5_000_000f,
                45);

        for (Employee employee : employees) {
            if (employee.isVeryOld()){
                employee.info();
            }
        }
    }
}
