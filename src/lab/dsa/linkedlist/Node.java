package lab.dsa.linkedlist;

public class Node<T> {
    private T data;
    private Node<T> previous;
    private Node<T> next;

    public Node() {
        this.data = null;
        this.previous = null;
        this.next = null;

    }

    public Node(T data) {
        this.data = data;
        this.previous = null;
        this.next = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNext() {
        return next;
    }

    public Node<T> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public boolean hasNext() {
        return this.next != null;
    }
    public boolean hasPrevious(){
        return this.previous != null;
    }
}
