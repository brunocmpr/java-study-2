package sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] numbers = {64, 25, 12, 22, 11};
        System.out.println("Before sorting: " + Arrays.toString(numbers));
        insertionSortIterative(numbers);
        System.out.println("After sorting: " + Arrays.toString(numbers));
    }

    private static void insertionSortIterative(int[] numbers) {
        for(int i = 1; i < numbers.length; i++){
            for(int j = i; j>0; j--){
                if(numbers[j -1] > numbers[j]) swapIndices(numbers, j, j-1);
            }
        }
    }

    private static void swapIndices(int[] numbers, int first, int second){
        int swapBuffer = numbers[first];
        numbers[first] = numbers[second];
        numbers[second] = swapBuffer;
    }
}
