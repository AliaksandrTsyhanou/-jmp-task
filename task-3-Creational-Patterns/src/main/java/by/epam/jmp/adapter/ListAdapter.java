package by.epam.jmp.adapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexandr on 12.12.2015.
 */
public class ListAdapter<T> implements Adapter<T>{

    private List<T> list = new ArrayList<T>();

    public void push(T obj){
        list.add(obj);
    }

    public T pop(){
        return list.get(list.size()-1);
    }

    @Override
    public String toString() {
        return "ListAdapter{" +
                "list=" + list +
                '}';
    }
}
