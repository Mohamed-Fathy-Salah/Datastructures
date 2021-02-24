import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;
import java.util.stream.Stream;

import assignments.A9;
import assignments.A8;
import assignments.A4;
import hash.Chain;
import hash.Double;
import nonlinear.Heap;

public class Main {
    private static Random r = new Random();
    private static A8 A = new A8();

    public static void main(String[] args) {
        long o = System.nanoTime();
        int x = 100;
        while (x-- > 0) {
            int arr[] = new int[100000];
            for (int i = 0; i < arr.length; i++)
                arr[i] = r.nextInt();
            Sort.MergeSort(arr, 0, arr.length - 1);
            if(!isSorted(arr))p("shit");
        }
        p(System.nanoTime()-o);
    }

    public static A8.Node n(int key) {
        return A.new Node(key);
    }

    public static void preorder(A8.Node root) {
        if (root == null)
            return;
        System.out.print(root + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void p(Object s) {
        System.out.println(s);
    }

    public static void pa(int arr[]) {
        for (int i : arr)
            System.out.print(i + " ");
        System.out.println();
    }

    public static boolean isSorted(ArrayList<Integer> arr) {
        for (int i = 1; i < arr.size(); i++)
            if (arr.get(i) > arr.get(i - 1))
                return false;
        return true;
    }
    public static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++)
            if (arr[i] < arr[i - 1])
                return false;
        return true;
    }
}