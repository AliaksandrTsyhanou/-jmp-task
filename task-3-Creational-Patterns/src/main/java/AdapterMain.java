import by.epam.jmp.adapter.Adapter;
import by.epam.jmp.adapter.ListAdapter;

/**
 * Created by Alexandr on 12.12.2015.
 */
public class AdapterMain {

    public static void main(String[] args) {
        Adapter<String> adapter = new ListAdapter<String>();
        adapter.push("Hello");
        adapter.push(",");
        adapter.push("World.");
        System.out.println("adapter = " + adapter);
        System.out.println("adapter.pop()=" + adapter.pop());
    }
}
