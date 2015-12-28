package by.epam.jmp.classloader;

/**
 * Created by Alexandr on 28.12.2015.
 */
public class MainFunctionality {
    public void execute() {
        System.out.println("Main functionality.");
        System.out.println("Classloader: " + this.getClass().getClassLoader());
    }
}
