import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GarbageCollectorMain {
    
    private static int bytesSize = 1*1024*1024;

    public static void main(String[] args) {

        List<byte[]> list  = new ArrayList<>();
        int cycleNumber = 0;
        while (true){
            System.out.println("cycle = " + cycleNumber++);
            addListElement(bytesSize, list);
            addListElement(bytesSize, list);

            list.removeIf(x->true);
        }

    }

    private static void addListElement(int sizeBytes, List list){
        byte[] bytes = new byte[sizeBytes];
        new Random().nextBytes(bytes);
        list.add(bytes);
    }
}
