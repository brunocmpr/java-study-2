package test;

public class SubtractDigitInteger {
    private static int subtractIntWithMath(int number, int digit){
        int length = String.valueOf(number).length();
        int result = 0;
        for(int i = length-1; i >= 0; i--){ //563 100 5
            int oneAtMagnitude = (int)Math.pow(10,i);
            result += (int)(number/oneAtMagnitude - 1) * oneAtMagnitude;
            number -= number/oneAtMagnitude * oneAtMagnitude;
        }
        return result;
    }
    private static int subtractIntWithString(int number, int digit) {
        int result = 0;
        String numberString = String.valueOf(number);
        char[] characters = numberString.toCharArray();
        for(int i = 0; i < characters.length; i++){
            result +=  (characters[i] - '0' - digit) * Math.pow(10, characters.length - i - 1);
        }
        return result;
    }
    public static void main(String[] args) {
        int number = 54;
        int digit = 1;
        int subtracted1 = subtractIntWithMath(number, digit);
        int subtracted2 = subtractIntWithString(number, digit);
        System.out.println(subtracted1);
        System.out.println(subtracted2);
    }

}
