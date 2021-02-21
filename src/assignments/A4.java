package assignments;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class A4 {
    public String decimalToBinary(int n) {
        StringBuilder s = new StringBuilder();
        while (n > 0) {
            s.append(n & 1);
            n >>= 1;
        }
        return s.reverse().toString();
    }

    public String decimalToBase(int n, int b) {
        StringBuilder s = new StringBuilder();
        while (n > 0) {
            int x = n % b;
            if (x > 9)
                s.append((char) ('A' + x - 10));
            else
                s.append(x);
            n /= b;
        }
        return s.reverse().toString();
    }

    public static class TwoStacks {
        private int arr[], l, r;

        public TwoStacks() {
            arr = new int[10];
            l = 0;
            r = 9;
        }

        public void push1(int x) {
            if (l > r)
                return;
            arr[l++] = x;
        }

        public void push2(int x) {
            if (l > r)
                return;
            arr[r--] = x;
        }

        public int pop1() {
            if (l == 0)
                return -1;
            return arr[--l];
        }

        public int pop2() {
            if (r == 9)
                return -1;
            return arr[++r];
        }

        @Override
        public String toString() {
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < arr.length; i++)
                s.append(arr[i] + " ");
            return s.toString();
        }
    }

    /*
     * Write a method Queue reverse (Queue q) for reversing the order of a queue.
     */
    public Queue reverse(Queue q) {
        reverse1(q);
        return q;
    }

    private void reverse1(Queue q) {
        if (q.isEmpty())
            return;
        Object n = q.poll();
        reverse1(q);
        q.add(n);
    }

    /*
     * Implement stack data structure using two Queues, use Dequeue() and Enqueue()
     * methods to implement Push() and POP() methods.
     */
    public class QStack {
        private Queue<Integer> l, r;

        public QStack() {
            l = new LinkedList<>();
            r = new LinkedList<>();
        }

        public void push(int k) {
            l.add(k);
        }

        public int pop() {
            if(r.isEmpty())flip();
            if(r.isEmpty())return (Integer) null;
            return r.poll();
        }
        private void flip(){
            if(l.isEmpty())return;
            int n = l.poll();
            flip();
            r.add(n);
        }
    }
    /*
     * Implement Queue data structure using two Stacks, use Push() and POP() methods
     * to implement Dequeue() and Enqueue() methods
     */
    public class SQueue{
        private Stack<Integer> l,r;
        public SQueue(){
            l = new Stack<>();
            r = new Stack<>();
        }
        public void push(int k){
            l.push(k);
        }
        public int pop(){
            if(r.isEmpty())flip();
            if(r.isEmpty())return (Integer)null;
            return r.pop();
        }
        private void flip(){
            while(!l.isEmpty())r.push(l.poll());
        }
    }
}