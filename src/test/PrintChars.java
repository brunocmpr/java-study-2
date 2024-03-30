package test;

public class PrintChars {
    public static void main(String[] args) {
        for(int i = 'a'; i < 'a'+26; i++){
            System.out.print(i + " : " + (char)i + ", ");
        }
        System.out.println();
        for(int i = 0; i < 26; i++){
            System.out.print(i+'a' + " : " + (char)('a'+i) + ", ");
        }
        System.out.println();
        for(int i = '0'; i < 256; i++){
            System.out.print(i + " : " + (char)(i) + ", ");
        }
    }
}
