package sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] numbers = {64, 25, 12, 22, 11};
        System.out.println("Before sorting: " + Arrays.toString(numbers));
        bubbleSortIterative_optimized(numbers);
        System.out.println("After sorting: " + Arrays.toString(numbers));
    }

    private static void bubbleSortIterative_basic(int[] numbers) {
        //i is not used as array index! It is just used to track max "j" iteration in nested for
        for(int i = 0; i < numbers.length - 1; i++){
            for(int j = 0; j < (numbers.length -i - 1); j++){
                if(numbers[j] > numbers[j+1]){
                    int swapBuffer = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = swapBuffer;
                }
            }
        }
    }

    private static void bubbleSortIterative_optimized(int[] numbers) {
        //i is not used as array index! It is just used to track max "j" iteration in nested for
        for(int i = 0; i < numbers.length - 1; i++){
            boolean swapped = false;
            for(int j = 0; j < (numbers.length -i - 1); j++){
                if(numbers[j] > numbers[j+1]){
                    int swapBuffer = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = swapBuffer;
                    swapped = true;
                }
            }
            if(!swapped) break; //If a complete j loop did not achieve a single swap, then the array must be sorted!
        }
    }
}
