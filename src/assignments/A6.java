package assignments;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class A6 {
    /*
     * Write and test this method: PriorityQ merge (PriorityQ q1, PriorityQ q2) the
     * method merges two priority queues into a single one and returns this new one.
     */
    public PriorityQueue<Integer> merge(PriorityQueue<Integer> a, PriorityQueue<Integer> b) {
        PriorityQueue<Integer> ret = new PriorityQueue<>();
        while(!a.isEmpty())ret.add(a.poll());
        while(!b.isEmpty())ret.add(b.poll());
        return ret;
    }
    /*
     * Write a method Queue reverse (Queue q) for reversing the order of a queue.
     * Hint: You are freely to use another data structure (if you need) to do your
     * task.
     */
    public Queue<Integer> reverse(Queue<Integer> q){
        Stack<Integer> s = new Stack<>();
        while(!q.isEmpty())s.add(q.poll());
        while(!s.isEmpty())q.add(s.pop());
        return q;
    }
    public Queue<Integer> reverse1(Queue<Integer> q){
        reverse2(q);
        return q;
    }
    private void reverse2(Queue<Integer> q){
        if(q.isEmpty())return;
        int x = q.poll();
        reverse1(q);
        q.add(x);
    }
}
