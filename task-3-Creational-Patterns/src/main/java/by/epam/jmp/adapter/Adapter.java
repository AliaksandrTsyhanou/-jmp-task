package by.epam.jmp.adapter;

/**
 * Created by Alexandr on 12.12.2015.
 */
public interface Adapter<T> {

    public void push(T obj);

    public T pop();
}
