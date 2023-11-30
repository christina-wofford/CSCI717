//**********************************************************************************************************//
// Name: Ronni Kurtzhals                                                                                    //
// Class: CSci 717                                                                                          //
// Description: This program implements a Caesar Cipher, allowing the encryption of a user-inputted message.//
//**********************************************************************************************************//


//**********************************************************************************************************
//Code Revier: Christina Wofford 
//Comments:
// Your program is very well-structured and well-documented! The variable names are all clear and descriptive.
// I don't think it was part of our original assignment, but adding input validation to verify that the user
// is entering an integer would be an nice addition. Error validation could be useful as well.
// 
// Overall, I think that your program is a very well-designed and well-implemented Caesar Cipher. 
// You did an excellent job! 
//**********************************************************************************************************

package main;
import java.util.Scanner;

public class EncryptionMachine {
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    public static final int SHIFT = 3;

    public static void main(String[] args) throws Exception {
        runMachine();
    }

    /* 
    Description: This method explains the program to the user and gets user input, 
    calling all necessary functions to run the program.
    */
     public static void runMachine() {
        System.out.println("Welcome to the CSCI717 Encryption Machine Construction");
        System.out.println("The program lets you encrypt a message");
        System.out.println("with a key for your recipient to decrypt!");

        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter key:");
        String key = userInput.next();
        encryptWord(key);

        System.out.println("How many words is your message?");
        int messageLength = userInput.nextInt();
        for (int i = 0; i < messageLength; i++) {
            System.out.println("Next word:");
            String word = userInput.next();
            encryptWord(word);
        }
        userInput.close();

        System.out.println("Message fully encrypted. Happy secret messaging!");
    }

    /*
    Description: This method encrypts the given word by encrypting each letter and outputting
    the resulting word.
    */
    public static String encryptWord(String word) {
        String encryptedWord = "";
        for (int i = 0; i < word.length(); i++) {
            char encryptedLetter = encryptLetter(word.charAt(i));
            encryptedWord += encryptedLetter;
        }
        System.out.println('"' + word + '"' + " has been encrypted to: " + '"' + encryptedWord + '"' + '\n');
        return encryptedWord; //CW - I set this return encryptedWord for the sake of unit tests
    }

    /*
    Description: This method encrypts one letter using the Caesar Cipher approach and returns it
    to be used elsewhere.
    */
    public static char encryptLetter(char letter) {
        int loc = ALPHABET.indexOf(letter);
        int newLoc;
        if (loc + SHIFT >= ALPHABET.length()) {
            newLoc = loc + SHIFT - ALPHABET.length();
        } else {
            newLoc = loc + SHIFT;
        }
        char encryptedChar = ALPHABET.charAt(newLoc);
        return encryptedChar;
    }
}
