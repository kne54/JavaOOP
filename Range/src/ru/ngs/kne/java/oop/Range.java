package ru.ngs.kne.java.oop;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public Range() {
    }

    public double getFrom() {
        return from;
    }

    public double getTo() {
        return to;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public void print() {
        System.out.println(this.from + " " + this.to);
    }

    public void checkOrder() {
        if (to < from) {
            double temp = from;
            from = to;
            to = temp;
        }
    }

    public double getLength() {
        return to - from;
    }

    public boolean isInside(double x) {
        return (x >= from && x <= to);
    }

    public Range getIntersection(Range range) {
        double from = range.getFrom();
        double to = range.getTo();
        double maxFrom;
        double minTo;

        if (this.from >= from) {
            maxFrom = this.from;
        } else {
            maxFrom = from;
        }

        if (this.to <= to) {
            minTo = this.to;
        } else {
            minTo = to;
        }

        if (maxFrom <= minTo) {
            return new Range(maxFrom, minTo);
        }

        return null;
    }

    public Range[] getCombine(Range range) {
        if (this.getIntersection(range) == null) {
            return new Range[]{this, range};
        }

        double from = range.getFrom();
        double to = range.getTo();
        double minFrom;
        double maxTo;

        if (this.from <= from) {
            minFrom = this.from;
        } else {
            minFrom = from;
        }

        if (this.to >= to) {
            maxTo = this.to;
        } else {
            maxTo = to;
        }

        return new Range[]{new Range(minFrom, maxTo)};
    }

    public Range[] getDifference(Range range) { //todo: работает не правильно. Тест 5 10 и 1 5
        if (this.getIntersection(range) == null) {
            return new Range[]{this};
        }

        double from = range.getFrom();
        double to = range.getTo();

        if (this.from >= from && this.to <= to) {
            return null;
        }

        if (this.to < to) {
            return new Range[]{new Range(this.from, from)};
        }

        return new Range[]{(new Range(this.from, from)), new Range(to, this.to)};
    }
}