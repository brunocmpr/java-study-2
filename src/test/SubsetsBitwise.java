package test;

import java.util.ArrayList;
import java.util.List;

public class SubsetsBitwise {
    public static List<List<Integer>> subsets(int[] nums) {
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
        int[] input = {1,2,3};
        List<List<Integer>> subsets = subsets(input);
    }
}
