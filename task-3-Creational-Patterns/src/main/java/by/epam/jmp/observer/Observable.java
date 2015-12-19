package by.epam.jmp.observer;

/**
 * Created by Alexandr on 14.12.2015.
 */
public interface Observable {

    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();

}
