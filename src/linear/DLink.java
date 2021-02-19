package linear;
class DLink<T> {
    T n;
    DLink<T> next, prev;

    DLink(T n) {
        this.n = n;
    }

    void print() {
        System.out.print(n + " ");
    }
}
