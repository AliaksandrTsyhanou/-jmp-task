package by.epam.jmp.service;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Aliaksandr_Tsyhanou on 3/2/2016.
 */
public class HangManServiceTest {

    private static final String TEST_WORD = "HangMan";
    private static final int COUNT_ATTEMPS = 5;
    private static final char NON_EXIST_LETTER = 'F';
    private static final char EXIST_LETTER = 'H';

    private HangManService hangManService;

    @Before
    public void setUp() throws Exception {
        hangManService = new HangManService(TEST_WORD, COUNT_ATTEMPS);
    }

    @Test
    public void showMaskedWord() throws Exception {
        assertEquals("*******", hangManService.getMaskWord());
    }

    @Test
    public void youGuessLetter() throws Exception {
        assertTrue(hangManService.guessLetter(EXIST_LETTER));
    }

    @Test
    public void youDontGuessLetter() throws Exception {
        assertFalse(hangManService.guessLetter(NON_EXIST_LETTER));
    }

    @Test
    public void youLoseWhenUsedAllAttemps() throws Exception {
        for (int numberAttemp = COUNT_ATTEMPS; numberAttemp > 0; numberAttemp--){
            assertNotGameOver(numberAttemp);
        }
        assertEquals(0, hangManService.getCountAttemps());
        assertTrue(hangManService.isGameOver());
        assertFalse(hangManService.isWinner());

    }

    private void assertNotGameOver(int countAttemps) {
        assertEquals(countAttemps, hangManService.getCountAttemps());
        assertFalse(hangManService.isGameOver());
        assertFalse(hangManService.isWinner());
        assertFalse(hangManService.guessLetter(NON_EXIST_LETTER));
    }

    @Test
    public void youWinnerIfGuessedAllLetter() throws Exception {
        HangManService hangManService = new HangManService("K", 1);
        assertTrue(hangManService.guessLetter('K'));
        assertTrue(hangManService.isWinner());
        assertTrue(hangManService.isGameOver());
    }

    @Test
    public void showGuessedLetterInMaskedWord() throws Exception{
        assertGuessLetter('c', "*******", false);
        assertGuessLetter('h', "H******", false);
        assertGuessLetter('H', "H******", false);
        assertGuessLetter('a', "HA***A*", false);
        assertGuessLetter('N', "HAN**AN", false);
        assertGuessLetter('G', "HANG*AN", false);
        assertGuessLetter('m', "HANGMAN", true);
    }

    private void assertGuessLetter(char letter, String expectedWord, boolean expectedWinner) {
        hangManService.guessLetter(letter);
        String msg = "Word shoud be " + expectedWord + ", but was " + hangManService.getMaskWord();
        assertEquals(msg, expectedWord, hangManService.getMaskWord());
        assertEquals(expectedWinner, hangManService.isWinner());
    }

    @Test
    public void canRestartGame() throws Exception {
        hangManService.restartGame();
        assertFalse(hangManService.isGameOver());
        assertFalse(hangManService.isWinner());
        assertEquals(COUNT_ATTEMPS, hangManService.getCountAttemps());
        assertEquals("*******", hangManService.getMaskWord());
    }
}