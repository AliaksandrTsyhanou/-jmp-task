package by.epam.jmp.bean;

import by.epam.jmp.util.WordUtil;

/**
 * Created by Aliaksandr_Tsyhanou on 3/2/2016.
 */
public class HangManBean {

    private final String gameWord;
    private final int initCountAttemps;
    private int countAttemps;
    private String maskWord;
    private boolean isWinner;
    private boolean isGameOver;

    public HangManBean(String gameWord, int countAttemps) {
        this.gameWord = gameWord;
        this.initCountAttemps = countAttemps;
        this.countAttemps = countAttemps;
        this.maskWord = WordUtil.maskWord(gameWord);
        this.isWinner = false;
        this.isGameOver = false;
    }

    public int getInitCountAttemps() {
        return initCountAttemps;
    }

    public String getGameWord() {
        return gameWord;
    }

    public int getCountAttemps() {
        return countAttemps;
    }

    public void setCountAttemps(int countAttemps) {
        this.countAttemps = countAttemps;
    }

    public String getMaskWord() {
        return maskWord;
    }

    public void setMaskWord(String maskWord) {
        this.maskWord = maskWord;
    }

    public boolean isWinner() {
        return isWinner;
    }

    public void setWinner(boolean winner) {
        isWinner = winner;
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public void setGameOver(boolean gameOver) {
        isGameOver = gameOver;
    }
}
