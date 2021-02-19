package assignments;

import java.util.LinkedList;

public class A2 {
    /*
     * Given two sorted lists L1 and L2, write a procedure to compute L1 ᴜ L2 using
     * only the basic list operations
     */
    public LinkedList<Integer> union(LinkedList<Integer> a, LinkedList<Integer> b) {
        LinkedList<Integer> ret = new LinkedList<Integer>();
        while (!a.isEmpty() && !b.isEmpty()) {
            if (a.getFirst() < b.getFirst()) {
                if (ret.isEmpty() || (ret.getLast() != a.getFirst()))
                    ret.addLast(a.getFirst());
                a.pollFirst();
            } else {
                if (ret.isEmpty() || (ret.getLast() != b.getFirst()))
                    ret.addLast(b.getFirst());
                b.pollFirst();
            }
        }
        while (!a.isEmpty()) {
            if (ret.isEmpty() || (ret.getLast() != a.getFirst()))
                ret.addLast(a.getFirst());
            a.pollFirst();
        }
        while (!b.isEmpty()) {
            if (ret.isEmpty() || (ret.getLast() != b.getFirst()))
                ret.addLast(b.getFirst());
            b.pollFirst();
        }
        return ret;
    }

    /*
     * Given two sorted lists L1 and L2, write a procedure to compute L1 ∩ L2 using
     * only the basic list operations
     */
    public LinkedList<Integer> intersect(LinkedList<Integer> a, LinkedList<Integer> b) {
        LinkedList<Integer> ret = new LinkedList<Integer>();
        while (!a.isEmpty() && !b.isEmpty()) {
            if (a.getFirst() < b.getFirst())
                a.pollFirst();
            else if (a.getFirst() > b.getFirst())
                b.pollFirst();
            else {
                if (ret.isEmpty() || (ret.getLast() != a.getFirst()))
                    ret.addLast(a.getFirst());
                a.pollFirst();
                b.pollFirst();
            }
        }
        return ret;
    }
}