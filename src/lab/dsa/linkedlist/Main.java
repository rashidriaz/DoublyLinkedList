package lab.dsa.linkedlist;


public class Main {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> myLinkedList = new DoublyLinkedList<>();
        myLinkedList.insert(5);
        myLinkedList.insert(7);
        myLinkedList.insert(90);
        myLinkedList.insert(80);
        myLinkedList.insert(35);
        printLinkedList(myLinkedList);
        System.out.println("------------------------------------------------------------");
        myLinkedList.insertAtHead(40);
        printLinkedList(myLinkedList);
        System.out.println("------------------------------------------------------------");
        try {
            myLinkedList.insertAt(100, 3);
            printLinkedList(myLinkedList);
            System.out.println("------------------------------------------------------------");
            myLinkedList.update(0, 500);
            myLinkedList.update(6, 40);
            myLinkedList.update(4, 400);
            printLinkedList(myLinkedList);
            System.out.println("------------------------------------------------------------");
            myLinkedList.deleteHead();
            myLinkedList.deleteFromTheTail();
            myLinkedList.deleteAt(3);
            printLinkedList(myLinkedList);
            System.out.println("------------------------------------------------------------");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static void printLinkedList(DoublyLinkedList<Integer> linkedList) {
        for (int i = 0; i < linkedList.getSize(); i++) {
            System.out.println(linkedList.getFrom(i));
        }
    }
}
