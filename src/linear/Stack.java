package linear;
public class Stack <T extends Comparable<? super T>>{
    private final LinkedList<T> l;

    Stack() {
        l = new LinkedList<T>();
    }

    void push(T n) {
        l.pushFront(n);
    }

    void pop() {
        if (isEmpty()) return;
        l.popFront();
    }

    T top() {
        if (isEmpty()) return null;
        return l.getFirst().data;
    }

    int getSize() {
        return l.getSize();
    }

    boolean isEmpty() {
        return l.isEmpty();
    }
    void print(){l.print();}
}
