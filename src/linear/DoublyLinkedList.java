package linear;
public class DoublyLinkedList<T> {
    DLink<T> first, last;
    private int size;

    int getSize() {
        return size;
    }

    boolean isEmpty() {
        return size == 0;
    }

    void pushFront(T n) {
        DLink<T> nw = new DLink<>(n);
        if (isEmpty()) last = nw;
        else {
            nw.next = first;
            first.prev = nw;
        }
        first = nw;
        size++;
    }

    void pushBack(T n) {
        DLink<T> nw = new DLink<>(n);
        if (isEmpty()) first = nw;
        else {
            nw.prev = last;
            last.next = nw;
        }
        last = nw;
        size++;
    }

    void popFront() {
        if (isEmpty()) return;
        if (size == 1) first = last = null;
        else {
            first = first.next;
            first.prev = null;
        }
        size--;
    }

    void popBack() {
        if (isEmpty()) return;
        if (size == 1) first = last = null;
        else {
            last = last.prev;
            last.next = null;
        }
        size--;
    }

    void insert(int idx,T n) {
        if(idx <0 || idx >size)return;
        if(idx ==0){
            pushFront(n);
            return;
        }
        if(idx == size){
            pushBack(n);
            return;
        }
        DLink<T> cur= first,nw = new DLink<>(n);
        for (int i=0;i<idx;i++,cur = cur.next);
        nw.next = cur;
        cur.prev.next =nw;
        nw.prev = cur.prev;
        cur.prev = nw;
        size++;
    }
    DLink<T> find(T key) {
        DLink<T> cur = first;
        while (cur != null && cur.n != key) {
          cur = cur.next;
        }
        return cur;
    }

    void remove(T key) {
        if (isEmpty()) return;
        DLink<T> cur = first;
        while (cur != null && cur.n != key) cur = cur.next;
        if (cur == null) return;
        if (size == 1) {
            first = last = null;
            size = 0;
        } else if (cur == first) popFront();
        else if (cur == last) popBack();
        else {
            cur.prev.next = cur.next;
            cur.next.prev = cur.prev;
            size--;
        }
    }

    public T front(){
        return first.n;
    }
    public T back(){
        return last.n;
    }
    void print() {
        DLink<T> cur = first;
        while (cur != null) {
            cur.print();
            cur = cur.next;
        }
        System.out.println();
    }

    void printRev() {
        DLink<T> cur = last;
        while (cur != null) {
            cur.print();
            cur = cur.prev;
        }
        System.out.println();
    }
}

