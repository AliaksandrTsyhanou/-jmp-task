package by.epam.jmp.service;

import by.epam.jmp.bean.HangManBean;
import by.epam.jmp.util.WordUtil;

/**
 * Created by Aliaksandr_Tsyhanou on 3/2/2016.
 */
public class HangManService {

    private HangManBean hangManBean;

    public HangManService(String gameWord, int countAttemps) {
        this.hangManBean = new HangManBean(gameWord, countAttemps);
    }

    public boolean guessLetter(char letter) {
        boolean isGuessedLetter = WordUtil.isExitLetter(hangManBean.getGameWord(), letter);
        if (isGuessedLetter){
            hangManBean.setMaskWord(WordUtil.remarkLetter(hangManBean.getMaskWord(), hangManBean.getGameWord(), letter));
            if (!WordUtil.isContainMask(hangManBean.getMaskWord())){
                hangManBean.setGameOver(true);
                hangManBean.setWinner(true);
            }
        }else{
            int countAttemps = hangManBean.getCountAttemps();
            if (countAttemps <= 1){
                hangManBean.setGameOver(true);
                hangManBean.setCountAttemps(0);
            }else{
                hangManBean.setCountAttemps(countAttemps-1);
            }
        }
        return isGuessedLetter;
    }

    public void restartGame(){
        hangManBean.setCountAttemps(hangManBean.getInitCountAttemps());
        hangManBean.setMaskWord(WordUtil.maskWord(hangManBean.getMaskWord()));
        hangManBean.setWinner(false);
        hangManBean.setGameOver(false);
    };

    public String getGameWord() {
        return hangManBean.getGameWord();
    }

    public int getCountAttemps() {
        return hangManBean.getCountAttemps();
    }

    public String getMaskWord() {
        return hangManBean.getMaskWord();
    }

    public boolean isWinner() {
        return hangManBean.isWinner();
    }

    public boolean isGameOver() {
        return hangManBean.isGameOver();
    }

}
