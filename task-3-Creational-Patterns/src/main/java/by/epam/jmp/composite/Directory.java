package by.epam.jmp.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexandr on 14.12.2015.
 */
public class Directory implements FSEntity {

    private String name;
    private long size;
    private List<File> files = new ArrayList<>();
    private List<Directory> directories = new ArrayList<>();

    public Directory(String name) {
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
        return files.stream().mapToLong(File::getSize).sum();
    }

    public void add(File file){
        files.add(file);
    }

    public void remove(File file){
        files.remove(file);
    }

    public void add(Directory directory){
        directories.add(directory);
    }

    public void remove(Directory directory){
        directories.remove(directory);
    }

    public List<File> getFiles(){
        return files;
    }

    @Override
    public String toString() {
        return "Directory{" +
                "name='" + name + '\'' +
                ", size=" + size +
                ", files=" + files +
                ", directories=" + directories +
                '}';
    }
}
