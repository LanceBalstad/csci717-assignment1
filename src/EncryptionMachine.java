import java.util.Scanner;
public class EncryptionMachine {
	public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
	public static final int SHIFT = 3;	

	public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
	    greetUser();
	    String key = getKey(scanner);
	    String encryptedKey = encryptWord(key);
	    showEncryptedKey(key,encryptedKey);
	    int numWords=getNumWords(scanner);
	    encryptMessage(numWords, scanner);
	    scanner.close();
	}
	
	// Encrypt a single word using the Caesar cipher
	public static String encryptWord(String word) {
	    StringBuilder result = new StringBuilder();
	    for (char character : word.toCharArray()) {
	        result.append(encryptCharacter(character));
	    }
	    return result.toString();
	}
	
	// Encrypt a single character
	public static char encryptCharacter(char ch) {
	    int index = ALPHABET.indexOf(ch);
	    if (index != -1) {
	        int newIndex = (index + SHIFT) % ALPHABET.length();
	        return ALPHABET.charAt(newIndex);
	    }
	    return ch; // return character unchanged if it's not in ALPHABET
	}
    private static void greetUser() {
	    System.out.println("Welcome to the CSCI717 Encryption Machine Construction");
	    System.out.println("The program lets you encrypt a message with a key for your recipient to decrypt!");
    }

    private static String getKey(Scanner scanner) {
    	// Get the encryption key from the user
	    System.out.println("Enter key:");
        return scanner.nextLine();
    }

    private static String encryptKey(String key) {
        // Placeholder for encryption logic
        return key; // This should be replaced with actual encryption logic
    }

    private static void showEncryptedKey(String key,String encryptedKey) {
    	System.out.println("\"" + key + "\" has been encrypted to: " + encryptedKey);
    }
    private static int getNumWords(Scanner scanner) {
        // Get the number of words in the message
        System.out.println("How many words is your message?:");
        return scanner.nextInt();
    }
    // Encrypt the message
    public static void encryptMessage(int numWords, Scanner scanner) {
        for (int i = 0; i < numWords; i++) {
            System.out.println("Next word:");
            String word = scanner.next();
            String encryptedWord = encryptWord(word);
            System.out.println("\"" + word + "\" has been encrypted to: " + encryptedWord);
        }
        System.out.println("Message fully encrypted. Happy secret messaging!");
    }

}
