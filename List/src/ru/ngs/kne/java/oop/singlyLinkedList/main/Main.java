package ru.ngs.kne.java.oop.singlyLinkedList.main;

import ru.ngs.kne.java.oop.singlyLinkedList.ListItem;
import ru.ngs.kne.java.oop.singlyLinkedList.SinglyLinkedList;

public class Main {
    public static void main(String[] args) {
        try {
            SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
            String separatorLine = "**************************************";

            System.out.println("Тест на пустом списке: ");

            list.printSLList();
            System.out.println("Длина списка: " + list.getCount());

            System.out.println("Удалим первый элемент: " + list.removeFirst());

            System.out.println("Первый элемент: " + list.getFirstElementData());

            System.out.println("Изменим первый элемент: " + list.getOrSetData(0, 11));

            System.out.println("Удалим первый элемент по индексу: " + list.removeElement(0));

            System.out.println("Вставим элемент по индексу 0");
            list.addByIndex(new ListItem<>(11), 0);

            System.out.println("Удалим элемент по значению null: " + list.removeByData(null));

            list.printSLList();
            System.out.println("Длина списка: " + list.getCount());
            System.out.println(separatorLine);

            list.addFirstElement(9);
            list.addFirstElement(7);
            list.addFirstElement(5);
            list.addFirstElement(3);
            list.addFirstElement(1);

            list.printSLList();
            System.out.println("Длина списка: " + list.getCount());

            System.out.println("Первый элемент: " + list.getFirstElementData());
            System.out.println("Элемент по индексу 2: " + list.getOrSetData(2, null));
            System.out.println("Элемент по индексу 5: " + list.getOrSetData(5, null));
            System.out.println(separatorLine);

            System.out.println("Изменим значение по индексу 2: " + list.getOrSetData(2, -5));
            list.printSLList();
            System.out.println(separatorLine);

            System.out.println("Удалим элемент по индексу 2: " + list.removeElement(2));
            list.printSLList();
            System.out.println(separatorLine);

            System.out.println("Удалим элемент по индексу 0: " + list.removeElement(0));
            list.printSLList();
            System.out.println(separatorLine);

            System.out.println("Удалим элемент по индексу 2: " + list.removeElement(2));
            list.printSLList();
            System.out.println("Длина списка: " + list.getCount());
            System.out.println(separatorLine);

            System.out.println("Вставим элемент по индексу 1");
            list.addByIndex(new ListItem<>(2), 1);
            list.printSLList();
            System.out.println(separatorLine);

            System.out.println("Вставим элемент по индексу 0");
            list.addByIndex(new ListItem<>(11), 0);
            list.printSLList();
            System.out.println("Длина списка: " + list.getCount());
            System.out.println(separatorLine);

            System.out.println("Удалим элемент по значению 11: " + list.removeByData(11));
            list.printSLList();
            System.out.println("Удалим элемент по значению 7: " + list.removeByData(7));
            list.printSLList();
            System.out.println("Длина списка: " + list.getCount());
            System.out.println(separatorLine);

            System.out.println("Тест на разворот: ");

            list.addFirstElement(9);
            list.addFirstElement(7);
            list.addFirstElement(5);
            list.addFirstElement(3);
            list.addFirstElement(1);

            list.printSLList();
            System.out.println("Разворот: ");

            list.returnList();
            list.printSLList();
            System.out.println(separatorLine);

            System.out.println("Тест на копирование: ");

            SinglyLinkedList<Integer> copyList = list.copySLList();

            list.printSLList();
            System.out.print("Копия ");
            copyList.printSLList();

            System.out.println("Удалим из копии элемент по индексу 2: " + copyList.removeElement(2));
            System.out.print("Копия ");
            copyList.printSLList();
            System.out.print("Оригинал ");
            list.printSLList();
            System.out.println(separatorLine);
        } catch (NullPointerException e) {
            System.out.println("Обращение к несуществующему элементу");
        }
    }
}