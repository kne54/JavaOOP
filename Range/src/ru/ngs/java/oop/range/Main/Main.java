package ru.ngs.java.oop.range.Main;

import ru.ngs.java.oop.range.Range;

public class Main {
    public static void main(String[] args) {
        Range firstRange = new Range(1, 10);
        Range secondRange = new Range(3, 6);

        double x = 4.9;

        firstRange.checkOrder();
        secondRange.checkOrder();

        System.out.printf("Первый диапазон от %.2f до %.2f%n", firstRange.getFrom(), firstRange.getTo());
        System.out.printf("Длина первого диапазона: %.2f%n", firstRange.getLength());

        System.out.printf("Второй диапазон от %.2f до %.2f%n", secondRange.getFrom(), secondRange.getTo());
        System.out.printf("Длина второго диапазона: %.2f%n%n", secondRange.getLength());

        if (firstRange.isInside(x)) {
            System.out.printf("Число %.2f попадает в диапазон от %.2f до %.2f%n", x, firstRange.getFrom(), firstRange.getTo());
        } else {
            System.out.printf("Число %.2f не попадает в диапазон от %.2f до %.2f%n", x, firstRange.getFrom(), firstRange.getTo());
        }

        if (secondRange.isInside(x)) {
            System.out.printf("Число %.2f попадает в диапазон от %.2f до %.2f%n", x, secondRange.getFrom(), secondRange.getTo());
        } else {
            System.out.printf("Число %.2f не попадает в диапазон от %.2f до %.2f%n", x, secondRange.getFrom(), secondRange.getTo());
        }

        System.out.println();
        System.out.println("Пересечение заданных диапазонов:");

        if (firstRange.getIntersection(secondRange) == null) {
            System.out.println("Отсутствует");
        } else {
            firstRange.getIntersection(secondRange).print();
        }

        System.out.println("Объединение заданных диапазонов:");

        Range[] combineRange = firstRange.getCombine(secondRange);

        for (Range e : combineRange) {
            e.print();
        }

        System.out.println("Разница заданных диапазонов:");

        Range[] differenceRange = firstRange.getDifference(secondRange);

        if (differenceRange.length == 0) {
            System.out.println("Отсутствует");
        } else {
            for (Range e : differenceRange) {
                e.checkOrder();
                e.print();
            }
        }
    }
}