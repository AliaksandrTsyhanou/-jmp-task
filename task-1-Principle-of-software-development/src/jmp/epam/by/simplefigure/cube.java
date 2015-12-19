package jmp.epam.by.simplefigure;

import jmp.epam.by.ISimpleFigure;

/**
 * Created by Alexandr on 29.11.2015.
 */
public class Cube implements ISimpleFigure{

    double side;

    public Cube(double side) {
        this.side = side;
    }

    @Override
    public double getVolume(){
        return Math.pow(side, 3);
    }

    @Override
    public String toString() {
        return "Cube{" +
                "side=" + side +
                ";volume=" + getVolume() +
                '}';
    }
}
