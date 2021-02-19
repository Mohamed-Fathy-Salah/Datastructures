package linear;
public class LinkedList<T extends Comparable <? super T>> {
    private Link<T> first;
    private int size;

    public LinkedList() {
        size = 0;
    }

    public Link<T> getFirst() {
        return first;
    }

    public Link<T> find(T key) {
        Link<T> cur = first;
        while (cur != null && cur.data!= key) {
            cur = cur.next;
        }
        return cur;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void delete(T key) {
        Link<T> prev = first, cur = first;
        if (isEmpty())
            return;
        while (cur != null && cur.data != key) {
            prev = cur;
            cur = cur.next;
        }
        if (cur == null)
            return;
        if (cur == first)
            popFront();
        else
            prev.next = cur.next;
        size--;
    }

    public void pushFront(T n) {
        Link<T> nw = new Link<>(n);
        nw.next = first;
        first = nw;
        size++;
    }

    public void popFront() {
        if (isEmpty())
            return;
        first = first.next;
        size--;
    }

    public void print() {
        Link<T> cur = first;
        while (cur != null) {
            cur.print();
            cur = cur.next;
        }
        System.out.println();
    }

    public int getSize() {
        return size;
    }

    public void reverseI() {
        Link<T> prev = null, cur = first, next;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        first = prev;
    }

    private void revR(Link<T> n) {
        if (n.next == null) {
            first = n;
            return;
        }
        revR(n.next);
        n.next.next = n;
        n.next = null;
    }

    public void reverseR() {
        if (size <= 1)
            return;
        revR(first);
    }
    public void sort(){first = mergesort(first);}
    private Link<T> mergesort(Link <T>head){
        if(head == null || head.next == null)return head;
        Link<T> middle = getMiddle(head);
        Link<T> middleNext = middle.next;
        middle.next = null;
        Link<T> left =  mergesort(head);
        Link<T> right =  mergesort(middleNext);
        head = merge(left, right);
        return head;
    }
    private Link<T> merge (Link<T> a,Link<T> b){
        if(a==null)return b;
        if(b==null)return a;
        Link<T> ret;
        if(a.data.compareTo(b.data)<1){
            ret = a;
            ret.next = merge(a.next,b);
        }else {
            ret = b;
            ret.next = merge(a,b.next);
        }
        return ret;
    }
    private Link<T> getMiddle(Link<T> head){
        Link<T> fast= head, slow= head; 
        while(fast.next != null && fast.next.next != null){
            slow = slow .next;
            fast = fast.next.next;
        }
        return slow;
    }
}