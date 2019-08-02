package ru.ngs.kne.java.oop;

public class Square implements Shapes {
    private double sideLength;

    public Square(double sideLength) {
        this.sideLength = sideLength;
    }

    @Override
    public double getWidth() {
        return sideLength;
    }

    @Override
    public double getHeight() {
        return sideLength;
    }

    @Override
    public double getArea() {
        return sideLength * sideLength;
    }

    @Override
    public double getPerimeter() {
        return 4 * sideLength;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " [" + sideLength + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 15;

        return prime + Double.hashCode(sideLength);
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }

        if (object == null || object.getClass() != this.getClass()) {
            return false;
        }

        Square square = (Square) object;

        return sideLength == square.sideLength;
    }
}
