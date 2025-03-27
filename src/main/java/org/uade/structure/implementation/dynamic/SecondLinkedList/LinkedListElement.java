package org.uade.structure.implementation.dynamic.SecondLinkedList;

public class LinkedListElement {

    private int value;
    private LinkedListElement next;

    public LinkedListElement(int value) {
        this.value = value;
        this.next = null;
    }

    public LinkedListElement(int value, LinkedListElement next) {
        this.value = value;
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public void setNext(LinkedListElement next) {
        this.next = next;
    }

    public LinkedListElement getNext() {
        return next;
    }
}