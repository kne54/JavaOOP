package ru.ngs.kne.java.oop.singlyLinkedList;

public class SinglyLinkedList<T> {
    private ListItem<T> head;
    private int count;

    public SinglyLinkedList() {
    }

    public int getCount() {
        return count;
    }

    public T getFirstElementData() {
        if (head == null) {
            return null;
        }
        return head.getData();
    }

    public T getOrSetData(int index, T newData) {
        int i = -1;
        for (ListItem<T> p = head; p != null; p = p.getNext()) {
            i++;
            if (i == index) {
                if (newData != null) {
                    T oldData = p.getData();
                    p.setData(newData);
                    return oldData;
                }

                return p.getData();
            }
        }
        return null;
    }

    public T removeElement(int index) {
        if (index == 0 && head != null) {
            T oldData = head.getData();
            head = head.getNext();
            count--;
            return oldData;
        }

        int i = -1;
        for (ListItem<T> p = head, prev = null; p != null; prev = p, p = p.getNext()) {
            i++;
            if (i == index && prev != null) {
                T oldData = p.getData();
                prev.setNext(p.getNext());
                count--;
                return oldData;
            }
        }
        return null;
    }

    public void addFirstElement(T data) {
        head = new ListItem<>(data, head);
        count++;
    }

    public void addByIndex(ListItem<T> element, int index) {
        if (index == 0 && head != null) {
            ListItem<T> oldHead = head;
            head = element;
            head.setNext(oldHead);
            count++;
        }

        int i = -1;
        for (ListItem<T> p = head, prev = null; p != null; prev = p, p = p.getNext()) {
            i++;
            if (i == index && prev != null) {
                prev.setNext(element);
                element.setNext(p);
                count++;
            }
        }
    }


    public boolean removeByData(T data) {
        if (data != null) {
            if (head.getData().equals(data)) {
                head = head.getNext();
                count--;
                return true;
            }

            for (ListItem<T> p = head, prev = null; p != null; prev = p, p = p.getNext()) {
                if (p.getData().equals(data) && prev != null) {
                    prev.setNext(p.getNext());
                    count--;
                    return true;
                }
            }
        }
        return false;
    }

    public T removeFirst() {
        if (head == null) {
            return null;
        }
        T data = head.getData();
        head = head.getNext();

        count--;
        return data;
    }

    public void returnList() {
        if (head == null || head.getNext() == null) {
            return;
        }
        ListItem<T> newHead = null;

        while (head != null) {
            ListItem<T> p = head.getNext();
            head.setNext(newHead);
            newHead = head;
            head = p;
        }
        head = newHead;
    }


    public SinglyLinkedList<T> copySLList() {
        if (head == null) {
            return new SinglyLinkedList<>();
        }

        SinglyLinkedList<T> copyList = new SinglyLinkedList<>();
        copyList.head = new ListItem<>(head.getData(), head);

        for (ListItem<T> p = head.getNext(), q = copyList.head; p != null; p = p.getNext(), q = q.getNext()) {
            ListItem<T> buffer = new ListItem<>(p.getData(), p.getNext());
            q.setNext(buffer);
        }
        copyList.count = count;
        return copyList;
    }

    public void printSLList() {
        System.out.print("Список: ");

        for (ListItem<T> p = head; p != null; p = p.getNext()) {
            System.out.print(p);
        }
        System.out.println();
    }
}