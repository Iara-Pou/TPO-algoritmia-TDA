package main.java.org.uade.structure.implementation.dynamic;

import main.java.org.uade.structure.definition.LinkedListADT;

import java.util.Arrays;

public class DynamicLinkedList implements LinkedListADT {

    private int[] linkedList;

    public DynamicLinkedList(int value) {
        linkedList = new int[]{value};
    }

    @Override
    public void add(int value) {
        //cantidad de elementos en lista +1, por el valor nuevo
        int newSize = this.size() + 1;

        //creo y relleno nueva lista
        int[] newList = new int[newSize];
        for (int i = 0; i <= this.size(); i++) {
            if (i == this.size()) {
                newList[i] = value;
            } else {
                newList[i] = this.get(i);
            }
        }
        // inserto el nuevo valor
        newList[this.size()] = value;

        //retorno nueva lista
        linkedList = newList;
    }

    @Override
    public void insert(int index, int value) {
        int previousSize = this.size();
        int newSize = previousSize + 1;
        int[] newList = new int[newSize];

        if (index < 0 || index > previousSize) {
            throw new IndexOutOfBoundsException("El índice excede la longitud de la lista");
        }

        // Copiar elementos hasta índice, insertar valor en indice, copiar los que siguen
        for (int i = 0; i < index; i++) {
            newList[i] = this.get(i);
        }
        newList[index] = value;
        for (int i = index; i < previousSize; i++) {
            newList[i + 1] = this.get(i);
        }

        linkedList = newList;
    }

    @Override
    public void remove(int index) {

        int previousSize = this.size();
        int newSize = previousSize - 1;
        int[] newList = new int[newSize];

        if (index < 0 || index > previousSize) {
            throw new IndexOutOfBoundsException("El índice excede la longitud de la lista");
        }

        // Copiar elementos, sin índice a eliminar
        for (int i = 0, j = 0; i < previousSize; i++) {
            if (i != index) {
                newList[j++] = this.get(i);
            }
        }

        this.linkedList = newList;

    }

    @Override
    public int get(int index) {
        if (index < 0 || index >= this.size()) {
            throw new IndexOutOfBoundsException("Índice fuera de los límites");
        }
        return linkedList[index];
    }

    @Override
    public int size() {
        return linkedList.length;
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public String toString() {
        return "DynamicLinkedList{" +
                "linkedList=" + Arrays.toString(linkedList) +
                '}';
    }
}
