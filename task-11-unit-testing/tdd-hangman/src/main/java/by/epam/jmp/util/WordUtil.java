package by.epam.jmp.util;

/**
 * Created by Aliaksandr_Tsyhanou on 3/2/2016.
 */
public class WordUtil {

    public static final String MASK_LETTER = "*";

    public static boolean isExitLetter(String word, char letter) {
        letter = Character.toUpperCase(letter);
        word = word.toUpperCase();
        return word.contains(String.valueOf(letter));
    }

    public static String maskWord(String testWord) {
       return testWord.replaceAll(".", MASK_LETTER);
    }

    public static boolean isContainMask(String testWord) {
        return testWord.contains(MASK_LETTER);
    }

    public static String remarkLetter(String maskWord, String gameWord, char letter) {
        int index = -1;
        letter = Character.toUpperCase(letter);
        gameWord = gameWord.toUpperCase();
        StringBuilder sb =  new StringBuilder(maskWord);
        while((index = gameWord.indexOf(letter, index+1)) != -1){
            sb.setCharAt(index, letter);
        }
        return sb.toString();
    }
}
