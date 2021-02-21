package assignments;

public class A3 {
    /*
     * For example, if list is {22, 33, 44, 55, 66, 77, 88, 99}, then put (list, 3,
     * 50) will change list to {22, 33, 44, 50, 55, 66, 44, 88, 99}. Hint: if i = 0,
     * replace the value of the first node with x, and insert a new node immediately
     * after it that contains the previous first value.
     */
    public void put(LinkList l,int i,int x){
        if(i<0 || i>l.size())return ;
        Linkk b = new Linkk(x);
        if(l.isEmpty()){
            l.first = l.last = b;
            return;
        }
        if(i == 0){
            b.next= l.first;
            l.first = b;
            return;
        }
        if(i == l.size()){
            l.last.next = b;
            l.last = b;
            return;
        }
        Linkk a = get(l,i-1);
        b.next = a.next;
        a.next = b;
    }
    /*
     * swaps the ith element with the jth element in the doubly linked list L; For
     * example, if list is {22, 33, 44, 55, 66, 77, 88, 99}, then swap (list, 2, 5)
     * will change list to {22, 33, 77, 55, 66, 44, 88, 99}.
     */
    // given class named LinkList && Link
    public void swap(LinkList l, int i, int j) {
        if (i > j) {
            int t = i;
            i = j;
            j = t;
        }
        Linkk a = get(l, i);
        Linkk b = get(l, j);
        if (a == null || b == null || a == b)
            return;
        Linkk n = a.next;
        a.next = b.next;
        b.next = n;
        n.prev = b;
        if (a.next != null)
            a.next.prev = a;
        if (b.prev != null)
            b.prev.next = a;
        if (a.prev != null)
            a.prev.next = b;
        n = a.prev;
        a.prev = b.prev;
        b.prev = n;
        if (i == 0)
            l.first = b;
        if (j == l.size() - 1)
            l.last = a;
    }

    private Linkk get(LinkList l, int i) {
        if (i < 0 || i >= l.size())
            return null;
        Linkk ret = l.getFirst();
        while (i-- > 0)
            ret = ret.next;
        return ret;
    }
}
