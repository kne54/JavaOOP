package ru.ngs.kne.java.oop;

public class Rectangle extends Square {
    double sideLength2;

    public Rectangle(double sideLength, double sideLength2) {
        super(sideLength);
        this.sideLength2 = sideLength2;
    }

    @Override
    public double getWidth() {
        return sideLength;
    }

    @Override
    public double getHeight() {
        return sideLength2;
    }

    @Override
    public double getArea() {
        return sideLength * sideLength2;
    }

    @Override
    public double getPerimeter() {
        return 2 * sideLength + 2 * sideLength2;
    }
}
