package ru.geekbrains.valerych.lesson2;
// Задание 5
public class MinMax {
    public static void main(String[] args) {
        double[] arr = {1.2, 4.2, 56.21, -23.874, 754.44, 54.0, -98.99, 343.545};
        System.out.println("Минимальное значение в массиве " + getMin(arr));
        System.out.println("Максимальное значение в массиве " + getMax(arr));
    }
    public static double getMin(double[] arr){
        double min = arr[0];
        for (double v : arr) {
            if (v<min){
                min=v;
            }
        }
        return min;
    }

    public static double getMax(double[] arr){
        double max = arr[0];
        for (double v : arr) {
            if (v>max){
                max=v;
            }
        }
        return max;
    }
}
