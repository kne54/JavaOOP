package ru.ngs.kne.java.oop.shapes;

import java.util.Comparator;

public class PerimeterComparator implements Comparator<Shapes> {
    public int compare(Shapes a, Shapes b) {
        return Double.compare(a.getPerimeter(), b.getPerimeter());
    }
}