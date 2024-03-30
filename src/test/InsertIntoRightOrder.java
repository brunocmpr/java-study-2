package test;

import java.util.*;

public class InsertIntoRightOrder {
    private static void insertWithCollectionsBinarySearch(int item, List<Integer> ascendingSortedList){
        System.out.println("List before insert: " + ascendingSortedList + " , size: " + ascendingSortedList.size());
//        int newIndex = Collections.binarySearch(ascendingSortedList, item);
        int newIndex = Collections.binarySearch(ascendingSortedList, item, (item1, item2) -> item1.compareTo(item2));
        if (newIndex < 0) newIndex = -(newIndex +1);
        System.out.println("newIndex: " + newIndex);
        ascendingSortedList.add(newIndex, item);
        System.out.println("List after insert: " + ascendingSortedList );
    }
    private static void insertWithCustomBinarySearch(int item, List<Integer> ascendingSortedList){
        System.out.println("List before insert: " + ascendingSortedList + " , size: " + ascendingSortedList.size());
        int newIndex = customBinarySearch(item,ascendingSortedList);
        if (newIndex < 0) newIndex = -(newIndex +1);
        System.out.println("newIndex: " + newIndex);
        ascendingSortedList.add(newIndex, item);
        System.out.println("List after insert: " + ascendingSortedList );
    }

    private static int customBinarySearch(int target, List<Integer> sortedArray) {
        int low = 0;
        int high = sortedArray.size() - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            int midVal = sortedArray.get(mid);
            if(midVal < target){
                low = mid + 1;
            }else if(midVal > target){
                high = mid - 1;
            } else{
                return mid;
            }
        }
        return -low - 1;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(10, 20, 30, 40, 50, 60, 70, 80, 90, 100));
//        Collections.sort(list, Collections.reverseOrder());
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite um numero para adicionar à lista, ou -99 para finalizar");
        int input;
        for(input = scanner.nextInt(); input != -99;){
            insertWithCustomBinarySearch(input, list);
            System.out.println("Digite um numero para adicionar à lista, ou -99 para finalizar");
            input = scanner.nextInt();
        }
    }
}
