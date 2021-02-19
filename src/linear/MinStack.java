package linear;
import static java.lang.Integer.MAX_VALUE;
import java.util.Stack;

public class MinStack {
    private Stack<Pair<Integer, Integer>> s;

    public MinStack() {
        s = new Stack<>();
        s.push(new Pair(MAX_VALUE, MAX_VALUE));
    }

    public int size() {
        return s.size() - 1;
    }

    public boolean empty() {
        return size() == 0;
    }

    public int peek() {
        return s.peek().first;
    }

    public int min() {
        return s.peek().second;
    }

    public int pop() {
        if (empty())
            return MAX_VALUE;
        return s.pop().first;
    }

    public void push(int n) {
        s.push(new Pair(n, Integer.min(n, min())));
    }
}

class Pair<T, E> {
    public T first;
    public E second;

    Pair(T first, E second) {
        this.first = first;
        this.second = second;
    }
}