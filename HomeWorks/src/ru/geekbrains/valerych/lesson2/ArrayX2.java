package ru.geekbrains.valerych.lesson2;
// Задание 3
public class ArrayX2 {
    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int[] newArr = new int[arr.length];
        newArr = arrayX2(arr);
        System.out.println("Исходный массив");
        printArray(arr);
        System.out.println("\nНовый массив");
        printArray(newArr);
    }

    public static int[] arrayX2(int[] arr){
        int[] newArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]<6){
                newArr[i]=arr[i]*2;
            }else{
                newArr[i]=arr[i];
            }
        }
        return newArr;
    }

    public static void printArray(int[] arr){

        for (int value : arr) {
            System.out.print(value + " ");
        }
    }
}
