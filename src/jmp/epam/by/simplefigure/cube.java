package jmp.epam.by.simplefigure;

import jmp.epam.by.ISimpleFigure;

/**
 * Created by Alexandr on 29.11.2015.
 */
public class cube implements ISimpleFigure{

    double side;

    public cube(double side) {
        this.side = side;
    }

    @Override
    public double getVolume(){
        return Math.pow(side, 3);
    }

    @Override
    public String toString() {
        return "cube{" +
                "side=" + side +
                ";volume=" + getVolume() +
                '}';
    }
}
