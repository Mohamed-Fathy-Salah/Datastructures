import java.util.ArrayList;
import java.util.Random;

import linear.Link;
import linear.LinkedList;

public class Main {
    private static Random r = new Random();
    public static void main(String[] args) {
        long o = System.nanoTime();
        int x = 1000;
        while(x-->0){
            LinkedList<Integer>  l = new LinkedList<>();
            for (int i = 0; i < 10000; i++) l.pushFront(r.nextInt());
            Sort.mergeSort(l);
            if(!isSorted(l))p("shit");
        }
        p(System.nanoTime()-o);
    }

    public static void p(Object s) {
        System.out.println(s);
    }

    public static void pa(int arr[]) {
        for (int i : arr)
            System.out.print(i + " ");
        System.out.println();
    }

    public static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++)
            if (arr[i] < arr[i - 1])
                return false;
        return true;
    }
    public static boolean isSorted(LinkedList<Integer> l){
        Link prev = l.getFirst() , cur = l.getFirst();
        while(cur!=null){
            if(cur.data.compareTo(prev.data)<0)return false;
            prev = cur;
            cur = cur.next;
        }
        return true;
    }
}