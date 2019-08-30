package ru.ngs.kne.java.oop.shapes;

public class Rectangle implements Shapes {
    private double sideLength;
    private double sideLength2;

    public Rectangle(double sideLength, double sideLength2) {
        this.sideLength = sideLength;
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

    @Override
    public String toString() {
        return getClass().getSimpleName() + " [" + sideLength + ", " + sideLength2 + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 17;
        int hash = 1;

        hash = prime * hash + Double.hashCode(sideLength);
        hash = prime * hash + Double.hashCode(sideLength2);

        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }

        if (object == null || object.getClass() != this.getClass()) {
            return false;
        }

        Rectangle rectangle = (Rectangle) object;

        return sideLength == rectangle.sideLength && sideLength2 == rectangle.sideLength2;
    }
}
