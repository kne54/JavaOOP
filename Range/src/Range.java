import java.util.Scanner;

public class Range {

    private double from;
    private double to;

    private static final double EPSILON = 1.0e-10;

    private Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    private double getFrom() {
        return from;
    }

    private double getTo() {
        return to;
    }

    private void checkOrder() {
        if (from - to > Range.EPSILON) {
            double temp = from;
            from = to;
            to = temp;
        }
    }

    private double getLength() {
        return to - from;
    }

    private boolean isInside(double x) {
        return (x - from > Range.EPSILON && to - x > Range.EPSILON);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите начало диапазона: ");
        double from = scanner.nextDouble();

        System.out.println("Введите конец диапазона: ");
        double to = scanner.nextDouble();

        Range range = new Range(from, to);

        range.checkOrder();
        from = range.getFrom();
        to = range.getTo();

        System.out.printf("Задан диапазон от %.2f до %.2f%n", from, to);

        double length = range.getLength();
        System.out.printf("Длина диапазона: %.2f%n%n", length);

        System.out.println("Введите число: ");
        double x = scanner.nextDouble();

        if (range.isInside(x)) {
            System.out.printf("Число %.2f попадает в диапазон от %.2f до %.2f", x, from, to);
        } else {
            System.out.printf("Число %.2f не попадает в диапазон от %.2f до %.2f", x, from, to);
        }
    }
}