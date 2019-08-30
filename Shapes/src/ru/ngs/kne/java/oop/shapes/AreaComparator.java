package ru.ngs.kne.java.oop.shapes;

import java.util.Comparator;

public class AreaComparator implements Comparator<Shapes> {
    public int compare(Shapes a, Shapes b) {
        return Double.compare(a.getArea(), b.getArea());
    }
}