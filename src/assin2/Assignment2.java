package assin2;
public class Assignment2 {
    public static void main(String[] args) {
        LinkList l = new LinkList();

        for(int i=10;i>=0;i--)
            l.pushFront(i);

        System.out.println("original list");
        l.print();

        l.rotateLeft();
        System.out.println("after rotation");
        l.print();

        l.rotateLeft();
        System.out.println("another one");
        l.print();
    }
}

class Linkk {
    public int n;
    public Linkk next;

    public Linkk(int n) {
        this.n = n;
    }

    @Override
    public String toString() {
        return Integer.toString(n);
    }
}

class LinkList {
    private Linkk first, last;

    public void pushFront(int n) {
        Linkk nw = new Linkk(n);
        if (first == null)
            last = nw;
        else 
            nw.next = first;
        first = nw;
    }

    public void rotateLeft() {
        if(first == null)return;
        last.next = first;
        first = first .next;
        last = last.next;
        last.next = null;
    }

    public void print() {
        Linkk cur = first;
        System.out.print("{");
        while (cur != null) {
            System.out.print(cur + ", ");
            cur = cur.next;
        }
        System.out.println("}");
    }
}
/*sample output
original list
{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }

after rotation
{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0 }

another one
{2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 1 }
*/