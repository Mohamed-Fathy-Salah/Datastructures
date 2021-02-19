package linear;

public class DoublyEndedList<T extends Comparable <? super T>> {
    private Link<T> first, last;
    private int size;

    DoublyEndedList() {
        size = 0;
    }

    public void rotateLeft(){
        if(getSize()<2)return ;
        last.next = first;
        first = first .next;
        last = last.next;
        last.next = null;
    }
    T front(){
        return first.data;
    }
    Link<T> find(T key) {
        Link<T> cur = first;
        while (cur != null && cur.data != key) {
            cur = cur.next;
        }
        return cur;
    }

    Link<T> getFirst(){return first;}
    boolean isEmpty() {
        return size == 0;
    }

    void delete(T key) {
        Link<T> prev = first, cur = first;
        if (isEmpty()) return;
        while (cur != null && cur.data != key) {
            prev = cur;
            cur = cur.next;
        }
        if (cur == null) return;
        if(size ==1 )first = last = null;
        else if (cur == first) popFront();
        else if (cur == last ) last = prev;
        prev.next = cur.next;
        size--;
    }

    void pushFront(T n) {
        Link<T> nw = new Link<T>(n);
        if (isEmpty())
            last = nw;
        nw.next = first;
        first = nw;
        size++;
    }

    void pushBack(T n) {
        Link<T> nw = new Link<>(n);
        if (isEmpty())
            first = nw;
        else
            last.next = nw;
        last = nw;
        size++;
    }

    void popFront() {
        if (isEmpty()) return;
        if (size == 1) last = null;
        first = first.next;
        size--;
    }

    void print() {
        Link<T> cur = first;
        while (cur != null) {
            cur.print();
            cur = cur.next;
        }
        System.out.println();
    }

    int getSize() {
        return size;
    }
}
