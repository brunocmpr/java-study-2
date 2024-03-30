package sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] numbers = {64, 25, 12, 22, 11};
        System.out.println("Before sorting: " + Arrays.toString(numbers));
        selectionSortIterative(numbers);
        System.out.println("After sorting: " + Arrays.toString(numbers));
    }

    private static void selectionSortIterative(int[] numbers){
        for(int i = 0; i < numbers.length; i++){
            int lowestItemIndex = i;
            for(int j = i; j < numbers.length; j++){
                if(numbers[j] < numbers[lowestItemIndex] ){
                    lowestItemIndex = j;
                }
            }
            int swapBuffer = numbers[i];
            numbers[i] = numbers[lowestItemIndex];
            numbers[lowestItemIndex] = swapBuffer;
        }
    }
}
