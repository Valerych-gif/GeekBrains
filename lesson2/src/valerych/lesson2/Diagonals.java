package valerych.lesson2;
// Задание 4
public class Diagonals {
    public static void main(String[] args) {
        int size = 5;
        int[][] arr = new int[size][size];
        arr = loadArray(size);
        arr = makeDiagonals(arr);
        printArray(arr);
    }

    public static int[][] loadArray(int size){
        int[][] arr = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                arr[i][j] = 0;
            }
        }
        return arr;
    }

    public static void printArray(int[][] arr){
        int size = arr.length;
        for (int[] row : arr) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    public static int[][] makeDiagonals(int[][] arr){
        int size = arr[0].length;
        for (int i = 0; i < size; i++) {
            arr[i][i] = 1;
            arr[i][size-1-i] = 1;
        }
        return arr;
    }
}
