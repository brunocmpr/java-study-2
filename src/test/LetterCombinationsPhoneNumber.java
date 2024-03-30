package test;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsPhoneNumber {
    public List<String> letterCombinations(String digits) {
        //2^length strings
        List<String> returnList = new ArrayList<>();
        List<List<Character>> letterMap = buildLetterMap();
        letterCombinationsRecursive(digits, letterMap, 0, "", returnList);
        return returnList;
    }

    private void letterCombinationsRecursive(String digits, List<List<Character>> letterMap, int start, String current, List<String> results){
        System.out.println("{State} digits: " + digits + " , start: " + start + " , current: " + current);
        if(start >= digits.length()) return;
        if(current.length() == digits.length() && !current.isEmpty()){
            results.add(current);
        }
        int digit = digits.charAt(start) - '0';
        List<Character> letters = letterMap.get(digit-2);
        for(int j = 0; j < letters.size(); j++){
            Character letter = letters.get(j);
            letterCombinationsRecursive(digits, letterMap, start+1, current+letter, results);
        }

    }

    private List<List<Character>> buildLetterMap(){
        List<List<Character>> letterMap = new ArrayList<>();
        letterMap.add(List.of('a', 'b', 'c'));
        letterMap.add(List.of('d', 'e', 'f'));
        letterMap.add(List.of('g', 'h', 'i'));
        letterMap.add(List.of('j', 'k', 'l'));
        letterMap.add(List.of('m', 'n', 'o'));
        letterMap.add(List.of('p', 'q', 'r', 's'));
        letterMap.add(List.of('t', 'u', 'v'));
        letterMap.add(List.of('w', 'x', 'y', 'z'));
        return letterMap;
    }

    public static void main(String[] args) {
        LetterCombinationsPhoneNumber letterCombinationsPhoneNumber = new LetterCombinationsPhoneNumber();
        List<String> result = letterCombinationsPhoneNumber.letterCombinations("23");
        System.out.println(result);
    }
}
