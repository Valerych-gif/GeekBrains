package valerych.lesson2;
// Задание 1
public class BinaryArray {

    public static void main(String[] args) {
        int[] binaryArray = {1, 0, 0, 0, 1, 1, 1, 1, 0, 1, 0, 0, 1};
        int[] newBinaryArray = new int[binaryArray.length];

        newBinaryArray=reverseArray(binaryArray);
        System.out.println("Исходный массив");
        printArray(binaryArray);
        System.out.println("\nНовый массив");
        printArray(newBinaryArray);
    }

    public static void printArray(int[] arr){

        for (int value : arr) {
            System.out.print(value + " ");
        }
    }

    public static int[] reverseArray(int[] arr){
        int[] newArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==0){
                newArr[i]=1;
            }else{
                newArr[i]=0;
            }
        }
        return newArr;
    }
}
