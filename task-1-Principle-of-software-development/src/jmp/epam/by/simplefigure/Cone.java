package jmp.epam.by.simplefigure;

import jmp.epam.by.ISimpleFigure;

/**
 * Created by Alexandr on 29.11.2015.
 */
public class Cone implements ISimpleFigure{

    double radius;
    double height;

    public Cone(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    @Override
    public double getVolume(){
        return Math.PI * radius * radius * height / 3;
    }

    @Override
    public String toString() {
        return "Cone{" +
                "radius=" + radius +
                ", height=" + height +
                ";volume=" + getVolume() +
                '}';
    }
}
