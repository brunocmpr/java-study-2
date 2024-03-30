package test;

import java.util.ArrayList;
import java.util.List;

public class PowersOf2_IR {
    public static List<Integer> powersOf2_Iterative(int num){
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= num; i*=2){
            list.add(i);
        }
        return list;
    }

    private static List<Integer> powersOf2_Recursive(int input) {
        List<Integer> list = new ArrayList<>();
        powersOf2_aux(input, list);
        return list;
    }

    private static void powersOf2_aux(int input, List<Integer> list) {
        if(input == 0) return;
        if(input == 1) {
            list.add(input);
            return;
        }
        powersOf2_aux(input/2, list);
        Integer lastItem = list.get(list.size() - 1);
        list.add(lastItem*2);
    }

    public static void main(String[] args) {
        int input = 50;
        List<Integer> listIterative = powersOf2_Iterative(input);
        List<Integer> listRecursive = powersOf2_Recursive(input);
    }
}
