package jmp.epam.by.simplefigure;

import jmp.epam.by.ISimpleFigure;

/**
 * Created by Alexandr on 29.11.2015.
 */
public class Parallelepiped implements ISimpleFigure{

    double width;
    double length;
    double height;

    public Parallelepiped(double width, double length, double height) {
        this.width = width;
        this.length = length;
        this.height = height;
    }

    @Override
    public double getVolume(){
        return width * length * height;
    }

    @Override
    public String toString() {
        return "Parallelepiped{" +
                "width=" + width +
                ", length=" + length +
                ", height=" + height +
                ";volume=" + getVolume() +
                '}';
    }
}
