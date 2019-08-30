package ru.ngs.kne.java.oop.singlyLinkedList;

public class ListItem<T> {
    private T data;
    private ListItem<T> next;

    public ListItem(T data) {
        this.data = data;
    }

    public ListItem(T data, ListItem<T> next) {
        this.data = data;
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data){
        this.data = data;
    }

    public ListItem<T> getNext(){
        return next;
    }

    public void setNext(ListItem<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return data + " ";
    }

    @Override
    public int hashCode() {
        final int prime = 23;

        return prime + data.hashCode();
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object o){
        if (o == this) {
            return true;
        }

        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }

        ListItem<T> element = (ListItem<T>) o;
        return data == element.getData();
    }

}
