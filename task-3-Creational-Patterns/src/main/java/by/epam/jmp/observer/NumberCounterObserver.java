package by.epam.jmp.observer;

/**
 * Created by Alexandr on 14.12.2015.
 */
public class NumberCounterObserver implements Observer {

    int numberCount;

    public void update(String word) {
        try {
            Integer.parseInt(word);
            numberCount++;
        }catch (NumberFormatException nfe){
            //no number
        }
    }

    public int getNumberCount() {
        return numberCount;
    }
}
