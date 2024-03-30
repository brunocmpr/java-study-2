package sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] numbers = {8,2,4,7,1,3,9,5,6};
        System.out.println("Before sorting: " + Arrays.toString(numbers));
        quickSortRecursive(numbers);
        System.out.println("After sorting: " + Arrays.toString(numbers));
    }

    private static void quickSortRecursive(int[] numbers) {
        quickSortAux(numbers, 0, numbers.length-1);
    }

    private static void quickSortAux(int[] numbers, int start, int end) {
        if(start >= end) return;
        if(start < 0 || end >= numbers.length) return;
        int i = start-1, j = start, pivot = end;
        //Put stop condition here
        for(; j < pivot; j++){
            if(numbers[j] >= numbers[pivot]) continue;
            if(numbers[j] < numbers[pivot]){
                swapIndices(numbers, ++i, j);
            }
        }
        //now we put pivot in place: (i+1) according to algorithm, so we swap
        ++i;
        swapIndices(numbers, i, pivot);
        quickSortAux(numbers, start, (i-1));
        quickSortAux(numbers, i+1, (end));
    }

    private static void swapIndices(int[] numbers, int first, int second){
        int swapBuffer = numbers[first];
        numbers[first] = numbers[second];
        numbers[second] = swapBuffer;
    }
}
