package by.epam.jmp.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexandr on 14.12.2015.
 */
public class WordReader implements Observable {

    private List<Observer> observers;
    private List<String> words = new ArrayList<>();

    public List<String> getWords() {
        return words;
    }

    public void addWord(String word) {
        this.words.add(word);
        notifyObservers();
    }


    public WordReader() {
        this. observers = new ArrayList<Observer>();
    }

    public void registerObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    public void notifyObservers() {
        for (Observer observer : observers)
        {
            observer.update(words.get(words.size()-1));
        }
    }


}
