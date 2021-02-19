package linear;
public class SortedList<T extends Comparable<? super T>>{
    private Link<T> first;

    Link<T> find(T key) {
        Link<T> cur = first;
        while (cur != null && (int) cur.data < (int) key) {
            cur = cur.next;
        }
        if (cur == null || cur.data != key) return null;
        return cur;
    }

    boolean isEmpty() {
        return first == null;
    }

    void delete(T key) {
        Link<T> prev = first, cur = prev;
        if (isEmpty()) return;
        while (cur != null && (int) cur.data < (int) key) {
            prev = cur;
            cur = cur.next;
        }
        if (cur == null || cur.data != key) return;
        if (cur == first) popFront();
        else prev.next = cur.next;
    }

    void push(T n) {
        Link<T> nw = new Link<>(n);
        if (isEmpty()) {
           first= nw;
            return;
        }
        Link<T> cur = first, prev = first;
        while (cur != null && (int) cur.data < (int) n) {
            prev = cur;
            cur = cur.next;
        }
        if(cur == first)first = nw;
        else prev.next = nw;
        nw.next = cur;
    }

    void popFront() {
        if (isEmpty()) return;
        first = first.next;
    }

    void print() {
        Link<T> cur = first;
        while (cur != null) {
            cur.print();
            cur = cur.next;
        }
        System.out.println();
    }
}
