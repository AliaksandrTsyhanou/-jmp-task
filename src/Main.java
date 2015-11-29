import jmp.epam.by.ComlexFigure;
import jmp.epam.by.simplefigure.Cone;
import jmp.epam.by.simplefigure.Cube;
import jmp.epam.by.simplefigure.Parallelepiped;

public class Main {

    public static void main(String[] args) {
        ComlexFigure comlexFigure = new ComlexFigure();
        comlexFigure.addSimpleFigure(new Cube(3.0));
        comlexFigure.addSimpleFigure(new Parallelepiped(2.0, 3.0, 1.0));
        comlexFigure.addSimpleFigure(new Cone(2.0, 2.0));
        System.out.println(comlexFigure);
    }
}
