package by.epam.jmp.util;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Aliaksandr_Tsyhanou on 3/2/2016.
 */
public class WordUtilTest {

    private static final String TEST_WORD = "HangMan";

    @Test
    public void testExitLetter_UpperCase() throws Exception {
        assertTrue(WordUtil.isExitLetter(TEST_WORD, 'H'));
    }

    @Test
    public void testExitLetter_LowerCase() throws Exception {
        assertTrue(WordUtil.isExitLetter(TEST_WORD, 'h'));
    }

    @Test
    public void testNoExitLetter_UpperCase() throws Exception {
        assertFalse(WordUtil.isExitLetter(TEST_WORD, 'F'));
    }

    @Test
    public void testNoExitLetter_LowerCase() throws Exception {
        assertFalse(WordUtil.isExitLetter(TEST_WORD, 'f'));
    }

    @Test
    public void testMaskWord() throws Exception {
        String maskedWord = WordUtil.maskWord(TEST_WORD);
        assertEquals("*******", maskedWord);
    }

    @Test
    public void testContainMask_True() throws Exception {
        assertTrue(WordUtil.isContainMask("MA*K"));
    }

    @Test
    public void testContainMask_False() throws Exception {
        assertFalse(WordUtil.isContainMask(TEST_WORD));
    }

    @Test
    public void testRemarkLetter_UpperCaseLetterAndWord() throws Exception {
        String maskedWord = WordUtil.remarkLetter("****", "MASK", 'A');
        assertEquals("*A**", maskedWord);
    }

    @Test
    public void testRemarkLetter_UpperCaseLetterLowerCaseWord() throws Exception {
        String maskedWord = WordUtil.remarkLetter("****", "mask", 'A');
        assertEquals("*A**", maskedWord);
    }

    @Test
    public void testRemarkLetter_LowerCaseLetterUpperCaseWord() throws Exception {
        String maskedWord = WordUtil.remarkLetter("****", "MASK", 'a');
        assertEquals("*A**", maskedWord);
    }

    @Test
    public void testRemarkLetter_LowerCaseLetterAndWord() throws Exception {
        String maskedWord = WordUtil.remarkLetter("****", "mask", 'a');
        assertEquals("*A**", maskedWord);
    }
}