package valerych.lesson2;
// Задание 2
public class ArrayX3 {
    public static void main(String[] args) {
        int[] arrX3 = new int[8];

        for (int i = 0; i < 8; i++) {
            arrX3[i]=i*3;
        }
        System.out.println("Массив, заполненный с помощью цикла");
        printArray(arrX3);
    }

    public static void printArray(int[] arr){

        for (int value : arr) {
            System.out.print(value + " ");
        }

    }
}
