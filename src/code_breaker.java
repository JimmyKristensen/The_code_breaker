import java.util.Locale;
import java.util.Scanner;

public class code_breaker {
    public static String alphabet = "abcdefghijklmnopqrstuvwxyz";
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Input a text to encode: ");
        String encodeText = scanner.nextLine();
        int[] encodeString = numberCypherEncoder(encodeText.toLowerCase(Locale.ROOT));
        System.out.print("Your code have been encoded to numbers: ");
        for (int i = 0; i < encodeString.length; i++){
            System.out.print(encodeString[i] + " ");
        }
        System.out.print("\n");

        // Number cypher print
        printScannerForEncodedToNumber(encodeString);
        System.out.print("\n");

        // Caesar cypher print
        int caesarShift = 3;
        String caesarEndcodeText = caesarEncoder(encodeText.toLowerCase(Locale.ROOT),caesarShift);
        System.out.println("Your text have been Caesar encoded:  "+caesarEndcodeText);
        String caesarDecodeText = caesarDecoder(caesarEndcodeText,caesarShift);
        System.out.println("Your code have been decode : " + caesarDecodeText);


    }

    // Number cypher start
    public static int[] numberCypherEncoder(String encodeText){
        int[] encodedCeasarTextCypher = new int[encodeText.length()];
        for (int i = 0; i < encodedCeasarTextCypher.length; i++){
            encodedCeasarTextCypher[i] = alphabet.indexOf(encodeText.charAt(i));
        }
        return encodedCeasarTextCypher;
    }

    public static void printScannerForEncodedToNumber(int[] codeIntArray){
        System.out.print("Number encode back to text: ");
        for (int i = 0; i < codeIntArray.length; i++){
            System.out.print(alphabet.charAt((codeIntArray[i])));
        }
    }
    // Number cypher end


    // Caesar cypher start
    public static String caesarEncoder(String encodeText, int shift){
        String decodeText = "";
        for (int i = 0; i < encodeText.length(); i++){
            // Get's the index number of char in the string
            int charIndex = alphabet.indexOf(encodeText.charAt(i));
            // take the charIndex number + shift % 26. It takes the remainder and use i as index
            int indexValue = (charIndex + shift) % 26;
            // In case the value is under 0 which would give an error
            if (indexValue < 0){
                // Takes minus value and makes it positive.
                indexValue = alphabet.length() + indexValue;
            }
            // The shift index for char in the string
            char offset = alphabet.charAt(indexValue);
            decodeText += offset;
        }
        return decodeText;
    }

    public static String caesarDecoder(String encodeText, int shift){
        String decodeText = "";
        for (int i = 0; i < encodeText.length(); i++){
            int charIndex = alphabet.indexOf(encodeText.charAt(i));
            int indexValue = (charIndex - shift) % 26;
            if (indexValue < 0){
                indexValue = alphabet.length() + indexValue;
            }
            char offset = alphabet.charAt(indexValue);
            decodeText += offset;
        }
        return decodeText;
    }
    // Caesar cypher end
}
