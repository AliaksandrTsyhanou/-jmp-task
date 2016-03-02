package by.epam.jmp;

import by.epam.jmp.service.HangManService;

/**
 * Created by Aliaksandr_Tsyhanou on 3/2/2016.
 */
public class HangManMain {

    private static HangManService hangManService;

    public static void main(String[] args) {
        hangManService = new HangManService("MARK", 2);
        guessLetter('A');
        guessLetter('H');
        guessLetter('R');
        guessLetter('K');
        guessLetter('F');
        guessLetter('M');
    }

    private static void guessLetter(char letter){
        hangManService.guessLetter(letter);
        System.out.println("word: " + hangManService.getMaskWord() + " - atemps:" +  hangManService.getCountAttemps());
        if (hangManService.isWinner()){
            System.out.println("You win!!!");
        }
    }
}
