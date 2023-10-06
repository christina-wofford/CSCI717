//Christina Wofford
//CSCI 717
//Assignment 1
//October 6, 2023  

import java.util.Scanner;

public class EncryptionMachine {
    //Variable to hold the alphabet to find the index of the character.
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    //Variable to hold the shift amount
    public static final int SHIFT = 3;

    //Main method to run the program and call the other methods.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        displayWelcomeMessage();
        String key = promptForKey(scanner);
        
        displayEncryptedKey(key);
        int numWords = promptForWordCount(scanner);

        processAndDisplayWords(scanner, numWords);
        displayCompletionMessage();
    }

    //Display a welcome message to the user.
    private static void displayWelcomeMessage() {
        System.out.println("Welcome to the CSCI717 Encryption Machine Construction");
        System.out.println("The program lets you encrypt a message");
        System.out.println("with a key for your recipient to decrypt!");
    }

    //Ask the user for a key to encrypt the message.
    //Display the key to the user.
    private static String promptForKey(Scanner scanner) {
        System.out.println("Enter key:");
        return scanner.next();
    }

    //Pass the key to the encryptWord method to encrypt the key.
    //Display the encrypted key to the user.
    private static void displayEncryptedKey(String key) {
        String encryptedKey = encryptWord(key);
        System.out.println("\"" + key + "\" has been encrypted to: " + encryptedKey);
    }

    //Ask the user for the number of words in the message.
    //Return the number of words as an int.
    private static int promptForWordCount(Scanner scanner) {
        System.out.println("How many words is your message?:");
        return scanner.nextInt();
    }

    //Ask the user for the next word in the message.
    //Encrypt the word and display the encrypted word to the user.
    //Repeat for the number of words in the message based on the user's input.
    private static void processAndDisplayWords(Scanner scanner, int numWords) {
        for (int i = 0; i < numWords; i++) {
            System.out.println("Next word:");
            String word = scanner.next();
            String encryptedWord = encryptWord(word);
            System.out.println("\"" + word + "\" has been encrypted to: " + encryptedWord);
        }
    }

    //Pass the word to the encryptChar method to encrypt each character in the word.
    //Add the encrypted character to the encrypted word.
    //Return the encrypted word as a String.
    private static String encryptWord(String word) {
        StringBuilder encrypted = new StringBuilder();
        for (char c : word.toCharArray()) {
            encrypted.append(encryptChar(c));
        }
        return encrypted.toString();
    }

    //Encrypt the character by shifting it by the shift amount.
    //Wrap around to the beginning of the alphabet if the shift amount > 26.
    //Return the encrypted character to the encryptWord method as a char.
    private static char encryptChar(char c) {
        int index = ALPHABET.indexOf(c);
        int shiftedIndex = (index + SHIFT) % ALPHABET.length();
        return ALPHABET.charAt(shiftedIndex);
    }

     //Let the user know the message has been fully encrypted and thank them for using the program.
    private static void displayCompletionMessage() {
        System.out.println("Message fully encrypted. Happy secret messaging!");
    }
}
