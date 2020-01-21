package ru.geekbrains.valerych.lesson2;
// Задание 6
public class BalanceArray {
    public static void main(String[] args) {
        int[][] arrays = {
                {2, 2, 2, 1, 2, 2, 10, 1},
                {1, 1, 1, 2, 1},
                {1, 2, 3, 4, 5},
                {8}
        };
        for (int[] array : arrays) {
            System.out.println(isBalanced(array));
        }
    }

    public static boolean isBalanced(int[] arr){
        if (arr.length<2){
            return false;
        }
        int arrSize=arr.length;
        for (int i = 0; i < arrSize; i++) {
            int summLeft = 0, summRight=0;
            for (int j = 0; j <= i; j++) {
                summLeft+=arr[j];
            }
            for (int j = i+1; j < arrSize; j++) {
                summRight+=arr[j];
            }
            if (summLeft==summRight){
                return true;
            }
        }
        return false;
    }
}
