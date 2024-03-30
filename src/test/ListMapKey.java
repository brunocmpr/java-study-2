package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ListMapKey {
    public static void main(String[] args) {
        //https://stackoverflow.com/questions/9973596/arraylist-as-key-in-hashmap
        //Works, but not recommended as lists are mutable which could affect the hashcode
        //Keys should be immutable
        int[][] inputs = new int[3][2];
        inputs[0] = new int[]{1, 2};
        inputs[1] = new int[]{3, 4};
        inputs[2] = new int[]{5, 6};
        Map<List<Integer>, Integer> map = Map.of(List.of(1, 2), 1, List.of(3, 4), 2, List.of(5, 6), 3);
        ArrayList<Integer> key = new ArrayList<>();
        key.add(1);
        key.add(2);
        if(map.containsKey(key)){
            System.out.println("Key found: " + map.get(key));
        } else {
            System.out.println("Key not found");
        }

    }
}
