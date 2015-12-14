package by.epam.jmp.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexandr on 14.12.2015.
 */
public class ReverseWordObserver implements Observer {

    List<String> ReversedWords = new ArrayList<>();

    public void update(String word) {
        String reversedWord = new StringBuilder(word).reverse().toString();
        ReversedWords.add(reversedWord);
    }

    public List<String> getReversedWords() {
        return ReversedWords;
    }
}

