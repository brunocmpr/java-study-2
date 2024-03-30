package test;

import java.util.ArrayList;
import java.util.List;

public class PermutationCrackingCode {

    public static List<String> permutationCrackingCode(String str){
        List<String> permutations = new ArrayList<>();
        permutationCrackingCode(str, "", permutations);
        return permutations;
    }

    public static void permutationCrackingCode(String remaining, String accumulator, List<String> permutations){
        if (remaining.length() == 0){
            permutations.add(accumulator);
        } else {
            for(int i = 0; i < remaining.length(); i++){
                char pickedChar = remaining.charAt(i);
                String newAccumulator = accumulator + pickedChar;
                String newRemaining = remaining.substring(0, i) + remaining.substring(i+1);
                permutationCrackingCode(newRemaining, newAccumulator, permutations);
            }
        }
    }

    private static List<String> permutationBruno(String original) {
        List<String> permutations = new ArrayList<>();
//        permutationBruno(original, , permutations);
        return permutations;
    }

    private static void permutationBruno(String str, String s, List<String> permutations) {

    }

    public static void main(String[] args) {
        List<String> permutationsCracking = permutationCrackingCode("abacate");
//        List<String> permutationsBruno = permutationBruno("abacate");
        List<String> permutationsGpt = StringPermutations.getPermutations("abacate");
        permutationsGpt.forEach(System.out::println);
    }
}

class StringPermutations {

    public static List<String> getPermutations(String input) {
        List<String> permutations = new ArrayList<>();
        if (input == null || input.isEmpty()) {
            permutations.add("");
            return permutations;
        }

        char firstChar = input.charAt(0);
        String remainingString = input.substring(1);
        List<String> words = getPermutations(remainingString);
        for (String word : words) {
            for (int i = 0; i <= word.length(); i++) {
                String permutation = insertCharAt(word, firstChar, i);
                permutations.add(permutation);
            }
        }
        return permutations;
    }

    private static String insertCharAt(String word, char c, int index) {
        String start = word.substring(0, index);
        String end = word.substring(index);
        return start + c + end;
    }

    public static void main(String[] args) {
        String input = "abc";
        List<String> permutations = getPermutations(input);
        System.out.println("Permutations of " + input + ":");
        for (String permutation : permutations) {
            System.out.println(permutation);
        }
    }
}