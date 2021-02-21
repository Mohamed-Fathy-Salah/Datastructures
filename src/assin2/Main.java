// Java program to illustrate merge sorted 
// of linkedList 

public class Main {
    public static void main(String[] args) {

        List l = new List();
        l.push(100);
        l.push(-1);
        l.push(23);
        l.push(4);
        l.printList();
        System.out.println("");
        l.sort();
        l.printList();
    }
}

class List {
    private node head = null;
    private static class node {
        int val;
        node next;
        public node(int val) {
            this.val = val;
        }
    }
    public void sort(){
        head = mergeSort(head);
    }

    private node sortedMerge(node a, node b) {
        if (a == null)return b;
        if (b == null)return a;
        node result ;
        if (a.val <= b.val) {
            result = a;
            result.next = sortedMerge(a.next, b);
        } else {
            result = b;
            result.next = sortedMerge(a, b.next);
        }
        return result;
    }

    private node mergeSort(node h) {
        if (h == null || h.next == null) {
            return h;
        }
        node middle = getMiddle(h);
        node nextofmiddle = middle.next;
        middle.next = null;
        node left = mergeSort(h);
        node right = mergeSort(nextofmiddle);
        node sortedlist = sortedMerge(left, right);
        return sortedlist;
    }

    private static node getMiddle(node head) {
        if (head == null)return head;
        node slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public void push(int new_data) {
        node new_node = new node(new_data);
        new_node.next = head;
        head = new_node;
    }
    public void printList() {
        node headref = head;
        while (headref != null) {
            System.out.print(headref.val + " ");
            headref = headref.next;
        }
    }
}