package linear;
public class Link<T extends Comparable <? super T>> {
    public T data;
    public Link<T> next;

    public Link(T n) {
        this.data = n;
    }
    public void print(){
        System.out.print(data+" ");
    }
    @Override
    public String toString() {
        return "{" + "n=" + data + "}";
    }
}
