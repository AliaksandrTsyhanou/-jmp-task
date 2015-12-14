package by.epam.jmp.observer;

/**
 * Created by Alexandr on 14.12.2015.
 */
public class WordCounterObserver implements Observer {

    int wordCount;

    public void update(String word) {
        wordCount++;
    }

    public int getWordCount() {
        return wordCount;
    }
}
