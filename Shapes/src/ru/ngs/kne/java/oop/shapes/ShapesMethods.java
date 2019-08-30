package ru.ngs.kne.java.oop.shapes;

import java.util.List;

public class ShapesMethods {
    public static Shapes getMaxAreaShape(List<Shapes> shapes) {
        AreaComparator areaComparator = new AreaComparator();
        shapes.sort(areaComparator);

        return shapes.get(shapes.size() - 1);
    }

    public static Shapes getNextToMaxPerimeterShape(List<Shapes> shapes) {
        if (shapes.size() < 2) {
            return null;
        }

        PerimeterComparator perimeterComparator = new PerimeterComparator();
        shapes.sort(perimeterComparator);

        return shapes.get(shapes.size() - 2);
    }
}
