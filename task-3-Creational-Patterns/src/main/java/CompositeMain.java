import by.epam.jmp.composite.Directory;
import by.epam.jmp.composite.File;

/**
 * Created by Alexandr on 14.12.2015.
 */
public class CompositeMain {

    public static void main(String[] args) {
        Directory root = new Directory("root");
        Directory directory2 = new Directory("directory2");
        Directory directory3 = new Directory("directory3");
        root.add(directory2);
        root.add(directory3);
        root.add(new File("file1"));
        directory2.add(new File("file654"));
        directory3.add(new File("kill_me"));
        directory3.add(new File("hidden_file"));

        System.out.println("root = " + root);

    }
}
