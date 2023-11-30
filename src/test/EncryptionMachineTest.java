package test;

import main.EncryptionMachine;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EncryptionMachineTest {


    @Test
    public void testMain() throws Exception {
    	EncryptionMachine.main(null);
    }
	@Test
    public void oneLetterKey() {
        assertEquals("d", EncryptionMachine.encryptWord("a"));
    }

    @Test
    public void basicKey() {
        assertEquals("khoor", EncryptionMachine.encryptWord("hello"));
    }

    @Test
    public void wraparoundKey() {
        assertEquals("abc", EncryptionMachine.encryptWord("xyz"));
    }

    @Test
    public void oneWordMessage() {
        assertEquals("zruog", EncryptionMachine.encryptWord("world"));
    }

    @Test
    public void multipleWordMessage() {
        assertEquals("wklv", EncryptionMachine.encryptWord("this"));
        assertEquals("lv", EncryptionMachine.encryptWord("is"));
        assertEquals("whvw", EncryptionMachine.encryptWord("test"));
    }

    @Test
    public void messageWithNoWords() {
        assertEquals("", EncryptionMachine.encryptWord(""));
    }

    @Test
    public void entireAlphabet() {
        assertEquals("defghijklmnopqrstuvwxyzabc", EncryptionMachine.encryptWord("abcdefghijklmnopqrstuvwxyz"));
    }

    @Test
    public void duplicateLetters() {
        assertEquals("ddd", EncryptionMachine.encryptWord("aaa"));
    }

    @Test
    public void oneLetterMessage() {
        assertEquals("c", EncryptionMachine.encryptWord("z"));
    }

    @Test
    public void variedWordLength() {
        assertEquals("d", EncryptionMachine.encryptWord("a"));
        assertEquals("ee", EncryptionMachine.encryptWord("bb"));
        assertEquals("fff", EncryptionMachine.encryptWord("ccc"));
    }
}
