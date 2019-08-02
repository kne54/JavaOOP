package ru.ngs.kne.java.oop.Main;

import ru.ngs.kne.java.oop.*;

import java.util.ArrayList;
import java.util.List;

import static ru.ngs.kne.java.oop.ShapesMethods.getMaxAreaShape;
import static ru.ngs.kne.java.oop.ShapesMethods.getNextToMaxPerimeterShape;


public class Main {
    public static void main(String[] args) {
        Square shape1 = new Square(12);
        Rectangle shape2 = new Rectangle(7, 11);
        Triangle shape3 = new Triangle(1, 3, 3, 5, 11, 12);
        Circle shape4 = new Circle(9);
        Square shape5 = new Square(10.5);

        List<Shapes> shapes = new ArrayList<>();

        shapes.add(shape1);
        shapes.add(shape2);
        shapes.add(shape3);
        shapes.add(shape4);
        shapes.add(shape5);

        for (Shapes e : shapes) {
            System.out.println(e + " площадь = " + e.getArea() + " периметр = " + e.getPerimeter());
        }

        System.out.println();
        System.out.println("Фигура с максимальной площадью: " + getMaxAreaShape(shapes));

        if (getNextToMaxPerimeterShape(shapes) != null) {
            System.out.println();
            System.out.println("Фигура со вторым по величине периметром: " + getNextToMaxPerimeterShape(shapes));
        } else {
            System.out.println();
            System.out.println("В списке слишком мало фигур");
        }
    }
}