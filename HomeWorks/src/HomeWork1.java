// Домашнее задание к уроку 1
public class HomeWork1 {

    // Задание 1
    public static void main(String[] args) {

        // Задание 2
        byte a = 7;
        short b = 459;
        int c = 377;
        long d = 799302L;
        float e = 56.93f;
        double f = 487.732;
        char g = 'g';
        boolean h = false;
        String str = "Hello";
        HomeWork1 homeWork1 = new HomeWork1();

        // Выполнение методов
        System.out.println(expression(123.45f, e, c, 234.56f));
        System.out.println(range(5, 7));
        System.out.println(range(15, 17));
        positiveOrNegative(67);
        positiveOrNegative(-85);
        System.out.println(isNegotive(0));
        System.out.println(isNegotive(-76));
        helloName("Geek");
        longerYear(2020);
        longerYear(2019);
        longerYear(2000);
        longerYear(1900);

    }

    // Задание 3
    public static float expression (float a, float b, float c, float d){
        return a * (b + (c / d));
    }

    // Задание 4
    public static boolean range (int a, int b){
        int sum = a + b;
        if (sum>=10&&sum<=20){
            return true;
        } else {
            return false;
        }
    }

    // Задание 5
    public static void positiveOrNegative(int a){
        if (a>=0){
            System.out.println("Переданное число положительное");
        } else {
            System.out.println("Переданное число отрицательное");
        }
    }

    // Задание 6
    public static boolean isNegotive(int a){
        return a<0;
    }

    // Задание 7
    public static void helloName (String name){
        System.out.println("Привет, " + name + "!");
    }

    // Задание 8
    public static void longerYear(int year){
        if (year%400==0){
            System.out.println(year + " год високосный");
            return;
        }
        if (year%100==0){
            System.out.println(year + " год не високосный");
            return;
        }
        if (year%4==0){
            System.out.println(year + " год високосный");
        } else{
            System.out.println(year + " год не високосный");
        }
    }

}
