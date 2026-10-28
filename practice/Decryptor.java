package practice;

public class Decryptor {

    public static void main(String[] args) {
        // The encrypted string (does not contain the word "thank you")
        String encrypted = "WKDQN BRX";
        int shift = 3;

        StringBuilder decrypted = new StringBuilder();

        for (char character : encrypted.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isUpperCase(character) ? 'A' : 'a';
                // Reverse the Caesar cipher shift
                char decryptedChar = (char) (((character - base - shift + 26) %
                    26) +
                    base);
                decrypted.append(decryptedChar);
            } else {
                decrypted.append(character); // Keeps spaces intact
            }
        }

        // This will print the final hidden message
        System.out.println(decrypted.toString());
    }
}
