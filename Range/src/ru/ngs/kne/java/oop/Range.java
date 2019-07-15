package ru.ngs.kne.java.oop;

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
        double maxFrom;
        double minTo;

        if (this.from >= range.from) {
            maxFrom = this.from;
        } else {
            maxFrom = range.from;
        }

        if (this.to <= range.to) {
            minTo = this.to;
        } else {
            minTo = range.to;
        }

        if (maxFrom < minTo) {
            return new Range(maxFrom, minTo);
        }

        return null;
    }

    public Range[] getCombine(Range range) {
        if (this.getIntersection(range) == null) {
            if (this.from == range.to) {
                return new Range[]{new Range(range.from, this.to)};
            }

            if (range.from == this.to) {
                return new Range[]{new Range(this.from, range.to)};
            }

            if (this.to < range.to) {
                return new Range[]{this, range};
            }

            return new Range[]{range, this};
        }

        double minFrom;
        double maxTo;

        if (this.from <= range.from) {
            minFrom = this.from;
        } else {
            minFrom = range.from;
        }

        if (this.to >= range.to) {
            maxTo = this.to;
        } else {
            maxTo = range.to;
        }

        return new Range[]{new Range(minFrom, maxTo)};
    }

    public Range[] getDifference(Range range) {
        if (this.getIntersection(range) == null) {
            return new Range[]{this};
        }

        if (this.from >= range.from && this.to <= range.to) {
            return new Range[0];
        }

        if (this.from < range.from && this.to > range.to) {
            return new Range[]{(new Range(this.from, range.from)), new Range(range.to, this.to)};
        }

        if (this.to < range.to) {
            return new Range[]{new Range(range.from, this.from)};
        }

        return new Range[]{new Range(this.to, range.to)};
    }
}