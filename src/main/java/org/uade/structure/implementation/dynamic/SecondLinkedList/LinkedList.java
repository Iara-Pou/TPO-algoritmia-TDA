package org.uade.structure.implementation.dynamic.SecondLinkedList;

public class LinkedList {
    private LinkedListElement first;
    private int size;

    public LinkedList() {
        this.first = null;
        this.size = 0;
    }

    public void add(int value) {
        if (isEmpty()) {
            first = new LinkedListElement(value);
        } else {
            LinkedListElement current = first;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(new LinkedListElement(value));
        }
        size++;
    }

    public void insert(int index, int value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        if (index == 0) {
            first = new LinkedListElement(value, first);
        } else {
            LinkedListElement current = first;
            int i = 0;
            while (i < index - 1) {
                current = current.getNext();
                i++;
            }
            LinkedListElement newElement = new LinkedListElement(value, current.getNext());
            current.setNext(newElement);
        }
        size++;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        if (index == 0) {
            first = first.getNext();
        } else {
            LinkedListElement current = first;
            int i = 0;
            while (i < index - 1) {
                current = current.getNext();
                i++;
            }
            current.setNext(current.getNext().getNext());
        }
        size--;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        LinkedListElement current = first;
        int i = 0;
        while (i < index) {
            current = current.getNext();
            i++;
        }
        return current.getValue();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        LinkedListElement current = first;
        while (current != null) {
            result.append(current.getValue());
            if (current.getNext() != null) {
                result.append(", ");
            }
            current = current.getNext();
        }
        result.append("]");
        return result.toString();
    }
}