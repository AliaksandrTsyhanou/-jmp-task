package by.epam.jmp.composite;

/**
 * Created by Alexandr on 14.12.2015.
 */
public class File implements FSEntity {

    private String name;
    private long size;

    public File(String name) {
        setName(name);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
        this.size = name.length();
    }

    @Override
    public long getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "File{" +
                "name='" + name + '\'' +
                ", size=" + size +
                '}';
    }
}
