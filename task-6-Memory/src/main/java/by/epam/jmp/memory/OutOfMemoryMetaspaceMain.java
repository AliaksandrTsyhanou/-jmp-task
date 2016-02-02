package by.epam.jmp.memory;

public class OutOfMemoryMetaspaceMain {

    static javassist.ClassPool cp = javassist.ClassPool.getDefault();

    public static void main(String[] args) throws Exception{
        for (int i = 0; ; i++) {
            Class c = cp.makeClass("by.epam.jmp.memory.Class" + i).toClass();
            System.out.println("New class: " + c);
        }
    }
}
