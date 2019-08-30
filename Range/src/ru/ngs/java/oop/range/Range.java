package ru.ngs.java.oop.range;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
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

        double maxFrom = Math.max(from, range.from);
        double minTo = Math.min(to, range.to);

        if (maxFrom < minTo) {
            return new Range(maxFrom, minTo);
        }

        return null;
    }

    public Range[] getCombine(Range range) {
        double maxFrom = Math.max(from, range.from);
        double minTo = Math.min(to, range.to);

        if (maxFrom < minTo) {
            double minFrom = Math.min(from, range.from);
            double maxTo = Math.max(to, range.to);

            return new Range[]{new Range(minFrom, maxTo)};
        }

        if (from == range.to) {
            return new Range[]{new Range(range.from, to)};
        }

        if (range.from == to) {
            return new Range[]{new Range(from, range.to)};
        }

        if (to < range.to) {
            return new Range[]{this, range};
        }

        return new Range[]{range, this};
    }

    public Range[] getDifference(Range range) {
        double maxFrom = Math.max(from, range.from);
        double minTo = Math.min(to, range.to);

        if (maxFrom >= minTo) {
            return new Range[]{this};
        }

        if (from >= range.from && to <= range.to) {
            return new Range[0];
        }

        if (from < range.from && to > range.to) {
            return new Range[]{(new Range(from, range.from)), new Range(range.to, to)};
        }

        if (to < range.to) {
            return new Range[]{new Range(range.from, from)};
        }

        return new Range[]{new Range(to, range.to)};
    }
}