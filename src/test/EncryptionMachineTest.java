package test;

import main.EncryptionMachine;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EncryptionMachineTest {

    @Test 
    public void testMain() {
    	EncryptionMachine.runMachine();
    }
	@Test
    public void oneLetterKey() {
        assertEquals("d", EncryptionMachine.encryptWord("a"));
    }

    @Test
    public void standardKey() {
        assertEquals("khoor", EncryptionMachine.encryptWord("hello"));
    }

    @Test
    public void wrappedKey() {
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
    public void zeroWordMessage() {
        assertEquals("", EncryptionMachine.encryptWord(""));
    }

    @Test
    public void fullAlphabet() {
        assertEquals("defghijklmnopqrstuvwxyzabc", EncryptionMachine.encryptWord("abcdefghijklmnopqrstuvwxyz"));
    }

    @Test
    public void duplicateCharcters() {
        assertEquals("ddd", EncryptionMachine.encryptWord("aaa"));
    }

    @Test
    public void oneLetterMessage() {
        assertEquals("c", EncryptionMachine.encryptWord("z"));
    }

    @Test
    public void variedWordLengths() {
        assertEquals("d", EncryptionMachine.encryptWord("a"));
        assertEquals("ee", EncryptionMachine.encryptWord("bb"));
        assertEquals("fff", EncryptionMachine.encryptWord("ccc"));
    }

    @Test
    public void encryptionCheck() {
        assertEquals('d', EncryptionMachine.encryptLetter('a'));
        assertEquals('a', EncryptionMachine.encryptLetter('x'));
    }

}
