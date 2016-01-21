package by.epam.jmp.memory;

public class OutOfMemoryHeapMain {

    public static void main(String[] args) {
        Long maxMemory = Runtime.getRuntime().maxMemory();
        System.out.println(maxMemory);
        int[] matrix = new int[(int) (maxMemory + 1)];
    }
}
