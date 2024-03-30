package sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] numbers = {8,2,4,7,1,3,9,5,6};
        System.out.println("Before sorting: " + Arrays.toString(numbers));
        mergeSort(numbers);
        System.out.println("After sorting: " + Arrays.toString(numbers));
    }

    private static void mergeSort(int[] numbers) {
        int[] result = mergeSortAux(numbers);
        System.arraycopy(result, 0,numbers,0, result.length);
    }

    private static int[] mergeSortAux(int[] numbers) {
        if(numbers.length == 1) return numbers;
        int[] left = Arrays.copyOfRange(numbers, 0, numbers.length/2);
        int[] right = Arrays.copyOfRange(numbers, numbers.length/2, numbers.length);

        int[] result = new int[numbers.length];

        left = mergeSortAux(left);
        right = mergeSortAux(right);

        result = merge(left, right);
        return result;
    }

    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int leftPointer = 0, rightPointer = 0;
        while (leftPointer+rightPointer < result.length){
            if(leftPointer >= left.length){
                result[leftPointer+rightPointer] = right[rightPointer++]; //TODO review
            } else if (rightPointer >= right.length) {
                result[leftPointer+rightPointer] = right[leftPointer++]; //TODO review
            } else if(left[leftPointer] < right[rightPointer]){
                result[leftPointer+rightPointer] = left[leftPointer++]; //TODO review
            } else {
                result[leftPointer+rightPointer] = right[rightPointer++]; //TODO review
            }
        }
        return result;
    }
}
