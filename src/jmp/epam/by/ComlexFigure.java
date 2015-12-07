package jmp.epam.by;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexandr on 29.11.2015.
 */
public class ComlexFigure {
    private List<ISimpleFigure> figures;

    public ComlexFigure() {
        figures = new ArrayList<>();
    }

    public double getVolume(){
        double volume = 0.0;
        for(ISimpleFigure simpleFigure : figures){
            volume += simpleFigure.getVolume();
        }
        return volume;
    }

    public void addSimpleFigure(ISimpleFigure simpleFigure){
        figures.add(simpleFigure);
    }

    public void setFigures(List<ISimpleFigure> figures) {
        this.figures = figures;
    }

    public List<ISimpleFigure> getFigures() {
        return figures;
    }

    @Override
    public String toString() {
        return "ComlexFigure{" +
                "figures=" + figures +
                ";volume=" + getVolume() +
                '}';
    }
}
