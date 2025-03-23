import main.java.org.uade.structure.implementation.dynamic.DynamicLinkedList;

public class Main {
    public static void main(String[] args) {
        DynamicLinkedList dynamicLinkedList = new DynamicLinkedList(1);
        dynamicLinkedList.add(2);
        dynamicLinkedList.add(3);

        System.out.println(dynamicLinkedList);
    }
}