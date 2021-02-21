package assin2;
public class Assignment3 {
    public static void main(String[] args) {
        CPQ p = new CPQ();
        for (int i = 0; i < 10; i++) {
            p.push((int) (Math.random() * 20));
        }
        System.out.println("the whole circular priority queue: ");
        p.print();

        System.out.println("some min values: "+p.popMin()+" "+p.popMin());

        System.out.println("the whole circular priority queue: ");
        p.print();


        System.out.println("some max values: "+p.popMax()+" "+p.popMax());

        System.out.println("the whole circular priority queue: ");
        p.print();

        System.out.println("after some insertions");
        p.push((int) (Math.random() * 20));
        p.push((int) (Math.random() * 20));
        p.push((int) (Math.random() * 20));

        System.out.println("the whole circular priority queue: ");
        p.print();

        System.out.println("some min values: "+p.popMin()+" "+p.popMin());

        System.out.println("the whole circular priority queue: ");
        p.print();

        System.out.println("some max values: "+p.popMax()+" "+p.popMax());

        System.out.println("the whole circular priority queue: ");
        p.print();
    }
}

class CPQ {
    private int mn, mx, sz, fl;
    private int[] arr;

    public CPQ() {
        this(7);
    }

    public CPQ(int size) {
        sz = size;
        arr = new int[sz];
        mn = mx = fl = 0;
    }

    public void push(int data) {
        if (full())
            expand();
        if (isEmpty())
            arr[mx] = data;
        else
            pushDown(data);
        mx = up(mx);
        fl++;
    }

    private void pushDown(int data) {
        int i = down(mx);
        while (arr[i] > data) {
            arr[up(i)] = arr[i];
            i = down(i);
        }
        arr[up(i)] = data;
    }

    public int popMin() {
        if (isEmpty())
            return Integer.MAX_VALUE;
        int ret = arr[mn];
        mn = up(mn);
        fl--;
        return ret;
    }

    public int popMax() {
        if (isEmpty())
            return Integer.MIN_VALUE;
        mx = down(mx);
        fl--;
        return arr[mx];
    }

    public int peekMin() {
        if (isEmpty())
            return Integer.MAX_VALUE;
        return arr[mn];
    }

    public int peekMax() {
        if (isEmpty())
            return Integer.MIN_VALUE;
        return arr[down(mx)];
    }

    private void expand() {
        int[] tmp = new int[sz << 1];
        for (int i = 0, j = mn; i < sz; i++, j = up(j))
            tmp[i] = arr[j];
        arr = tmp;
        mn = 0;
        mx = sz;
        sz <<= 1;
    }

    public void print() {
        System.out.print("{");
        for (int i = mn, j = fl; j > 0; i = up(i), j--) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println("}\n");
    }

    public boolean isEmpty() {
        return fl == 0;
    }

    private boolean full() {
        return fl == sz;
    }

    private int up(int i) {
        return (i + 1) % sz;
    }

    private int down(int i) {
        return (i - 1 + sz) % sz;
    }
}
/* sample output
the whole circular priority queue: 
{1, 2, 5, 9, 11, 11, 15, 16, 18, 19, }

some min values: 1 2

the whole circular priority queue: 
{5, 9, 11, 11, 15, 16, 18, 19, }

some max values: 19 18

the whole circular priority queue: 
{5, 9, 11, 11, 15, 16, }

after some insertions
the whole circular priority queue: 
{3, 5, 9, 10, 11, 11, 13, 15, 16, }

some min values: 3 5

the whole circular priority queue: 
{9, 10, 11, 11, 13, 15, 16, }

some max values: 16 15

the whole circular priority queue: 
{9, 10, 11, 11, 13, }
 */