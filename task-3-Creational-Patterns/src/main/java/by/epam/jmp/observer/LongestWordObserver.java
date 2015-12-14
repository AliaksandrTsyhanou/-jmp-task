package by.epam.jmp.observer;

/**
 * Created by Alexandr on 14.12.2015.
 */
public class LongestWordObserver implements Observer {

    String longestWord;

    public void update(String word) {
        if (longestWord == null){
            this.longestWord = word;
        } else if (word != null && longestWord.length() <= word.length()){
            this.longestWord = word;
        }
    }

    public String getLongestWord() {
        return longestWord;
    }
}

