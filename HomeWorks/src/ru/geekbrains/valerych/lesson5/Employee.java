package ru.geekbrains.valerych.lesson5;

public class Employee {

    private static final float MIN_SALARY_IN_RUSSIA = 11280f;

    private static int counter;

    private int id;

    private String name;
    private String position;
    private String email;
    private String phoneNumber;
    private float salary;
    private int age;


    public Employee(String name, String position, String email, String phoneNumber, float salary, int age) {
        id = counter;
        counter+=1;
        this.name = name;
        setPosition(position);
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;

    }

    public Employee(String name, String position, String email, String phoneNumber, int age) {
        this (name, position, email, phoneNumber, MIN_SALARY_IN_RUSSIA, age);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public float getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public void setPosition(String position) {
        this.position = checkPosition(position);
    }

    private String checkPosition(String position) {

        String[] positions = new String[]{"Unknown", "Just Engineer", "Leader", "Mega Boss"};
        for (String s : positions) {
            if (s.equals(position)){
                return position;
            }
        }
        return "Unknown";

    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public void info(){
        System.out.println(this.toString());
        System.out.println("-----------");
    }

    public boolean isVeryOld(){
        if (this.age>40){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return  "id=" + id +
                "\nname: " + name +
                "\nposition: " + position +
                "\nemail: " + email +
                "\nphoneNumber: " + phoneNumber +
                "\nsalary: " + salary +
                "\nage: " + age;
    }
}
