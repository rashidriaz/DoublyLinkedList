package lab.dsa.linkedlist;

public class DoublyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void insert(T data) {
        Node<T> node = new Node<>(data);
        if (this.head == null) {
            this.head = this.tail = node;
            size++;
            return;
        }
        node.setPrevious(this.tail);
        this.tail.setNext(node);
        tail = tail.getNext();
        size++;
    }

    public void insertAtHead(T data) {
        if (head == null) {
            insert(data);
            return;
        }
        Node<T> node = new Node<>(data);
        node.setNext(head);
        this.head.setPrevious(node);
        head = node;
        size++;
    }

    public void insertAt(T data, int index) throws Exception {
        if (head == null) {
            throw new Exception("Linked List is empty");
        }
        if (index == 0) {
            insertAtHead(data);
            return;
        }
        Node<T> nodeAtIndex, newNode = new Node<>(data);
        nodeAtIndex = traverseThroughLinkedList(index);
        if (!nodeAtIndex.hasNext()) {
            throw new IndexOutOfBoundsException("Index out of bound");
        }
        newNode.setNext(nodeAtIndex.getNext());
        newNode.setPrevious(nodeAtIndex);
        nodeAtIndex.setNext(newNode);
        size++;
    }


    public void deleteHead() {
        if (head == null) return;
        head = head.hasNext() ? head.getNext() : null;
        if (head != null) {
            head.setPrevious(null);
        }
        size--;
    }

    public void deleteFromTheTail() {
        if (head == null) return;
        if (!head.hasNext()) {
            head = null;
            size--;
            return;
        }
        Node<T> node = tail.getPrevious();
        node.setNext(null);
        size--;
    }

    public void deleteAt(int index) throws Exception {
        if (head == null) {
            throw new Exception("Linked List is empty");
        }
        if (index == 0) {
            deleteHead();
            return;
        }
        Node<T> nodeAtIndex = traverseThroughLinkedList(index);
        if (!nodeAtIndex.hasNext()) {
            throw new IndexOutOfBoundsException("Index out of bound");
        }
        if (nodeAtIndex.getNext().hasNext()) {
            Node<T> node = nodeAtIndex.getNext().getNext();
            node.setPrevious(nodeAtIndex);
            nodeAtIndex.setNext(node);
        } else {
            nodeAtIndex.setNext(null);
        }
        size--;
    }

    public void update(int index, T data) {
        if (head == null) return;
        if (index == 0) {
            head.setData(data);
            return;
        }
        Node<T> nodeAtIndex = traverseThroughLinkedList(index);
        if (!nodeAtIndex.hasNext()) {
            throw new IndexOutOfBoundsException("Index out of bound");
        }
        nodeAtIndex.getNext().setData(data);
    }

    public T getFirst() {
        return head.getData();
    }

    public T getLast() {
        return tail.getData();
    }

    public T getFrom(int index) {
        if (head == null) return null;
        if (index == 0) {
            return getFirst();
        }
        Node<T> nodeAtIndex = traverseThroughLinkedList(index);
        return nodeAtIndex.hasNext() ? nodeAtIndex.getNext().getData() : null;
    }

    public int getSize() {
        return size;
    }

    private Node<T> traverseThroughLinkedList(int index) {
        Node<T> node;
        try {
                node = head;
                for (int i = 0; i < (index - 1); i++) {
                    node = node.getNext();
                }
        } catch (NullPointerException e) {
            throw new IndexOutOfBoundsException("Index out of bound");
        }
        return node;
    }
}
