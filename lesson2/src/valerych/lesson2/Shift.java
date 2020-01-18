package valerych.lesson2;
// Задание 7
public class Shift {
    public static void main(String[] args) {
        int[] arr = {0,1,2,3,4,5,6,7,8,9};
        System.out.println("Исходный массив");
        printArray(arr);
        arr = shiftArray (arr, 5);
        System.out.println("\nСдвиг вправо на 5");
        printArray(arr);
        arr = shiftArray (arr, -3);
        System.out.println("\nСдвиг влево на 3");
        printArray(arr);
        arr = shiftArray (arr, 0);
        System.out.println("\nНикуда не сдвигаем");
        printArray(arr);
    }

    private static int[] shiftArray(int[] arr, int n) {
        int size = arr.length;
        int tmp1, tmp2;

        if (n>0) {
            for (int i = 0; i < n; i++) {
                tmp1=arr[0];
                arr[0]=arr[size-1];
                arr[size-1]=tmp1;
                for (int j = 0; j < size - 1; j++) {
                    tmp2=arr[j+1];
                    arr[j+1]=tmp1;
                    tmp1=tmp2;
                }
            }

        }

        if (n<0) {
            for (int i = 0; i < -n; i++) {
                tmp1=arr[size-1];
                arr[size-1]=arr[0];
                arr[0]=tmp1;
                for (int j = 1; j < size; j++) {
                    tmp2=arr[size-1-j];
                    arr[size-1-j]=tmp1;
                    tmp1=tmp2;
                }
            }

        }
        return arr;
    }

    public static void printArray(int[] arr){

        for (int value : arr) {
            System.out.print(value + " ");
        }
    }
}
