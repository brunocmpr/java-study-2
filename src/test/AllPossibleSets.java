package test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AllPossibleSets {

    public static List<List<Integer>> getAllSubsetsBackTrack(int[] nums) {
        List<List<Integer>> result = new CustomPrintableList<>();
        backtrack(nums, 0, new CustomPrintableList<>(), result);
        return result;
    }
    private static void backtrack(int[] nums, int start, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current));
        for (int i = start; i < nums.length; i++) {
            int _a_indexToAdd = i; //for debug
            Integer _a_numberToAdd = nums[_a_indexToAdd]; //for debug

            current.add(nums[i]);
            backtrack(nums, i + 1, current, result);

            int _z_indexToRemove = current.size() - 1; //for debug
            Integer _z_numberToRemove = current.get(_z_indexToRemove); //for debug

            current.remove(current.size() - 1);
        }
    }

    //Backtracking from neetcode https://www.youtube.com/watch?v=REOH22Xwdkk
    public static List<List<Integer>> getAllSubsetsDfs(int[] nums){
        List<List<Integer>> returnList = new CustomPrintableList<>();
        List<Integer> current = new CustomPrintableList<>();
        dfs(nums, 0, current, returnList);
        return returnList;
    }
    private static void dfs(int[] nums, int start, List<Integer> current, List<List<Integer>> result) {
        if(start >= nums.length){
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i = start; i < nums.length; i++){
            current.add(nums[i]);
            dfs(nums, i+1, current, result);
            current.remove(current.size()-1);
        }
    }

    //Another solution with bitwise operations on the (2^input length) possible subsets. I coded this one
    public static List<List<Integer>> getSubsetsBitwise(int[] nums) {
        int masks = 1 << nums.length; // same as Math.pow(2, nums.length)
        List<List<Integer>> returnList = new ArrayList<>();
        for(int mask = 0; mask<masks; mask++){
            List<Integer> subset = new ArrayList<>();
            for(int j = 0; j < nums.length; j++){
                int bit = mask >> j;
                if(bit == 1) subset.add(nums[j]);
            }
            returnList.add(subset);
        }
        if(returnList.isEmpty()) returnList.add(new ArrayList<>());
        return returnList;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        List<List<Integer>> allSubsets = getAllSubsetsBackTrack(nums);
        for (List<Integer> subset : allSubsets) {
            System.out.println(subset);
        }

        List<List<Integer>> allSubsetsDfs = getAllSubsetsDfs(nums);
        System.out.println(allSubsetsDfs);
    }

    private static class CustomPrintableList<T> extends ArrayList<T>{
        @Override
        public String toString() {
            return "[" + super.stream()
                    .map(Object::toString)
                    .collect(Collectors.joining(", ")) +
                    "]";
        }
    }
}