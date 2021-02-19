package linear;
public class StackArray {

    private int maxSize;
    private int[] arr;
    private int top;

    StackArray(int mx) {
        top = -1;
        maxSize = mx;
        arr = new int[maxSize];
    }

    boolean isFull() {
        return (maxSize - 1 == top);
    }

    boolean isEmpty() {
        return top == -1;
    }

    void push(int n) {
        if (!isFull()) {
            maxSize = 2 * maxSize;
            int[] tmp = arr.clone();
            arr = new int[maxSize];
            if (top + 1 >= 0) System.arraycopy(tmp, 0, arr, 0, top + 1);
        }
        arr[++top] = n;
    }

    int pop() {
        if (isEmpty()) return -1;
        return arr[top--];
    }

    int top() {
        if (isEmpty()) return -1;
        return arr[top];
    }
    void print(){
        for (int i = 0; i <= top; i++) System.out.print(arr[i]+" ");
        System.out.println();
    }
}
