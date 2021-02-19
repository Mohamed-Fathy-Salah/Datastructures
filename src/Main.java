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
import hash.Double;
import nonlinear.Heap;

public class Main {
    private static Random r = new Random();
    private static A9 A = new A9();

    public static void main(String[] args) {
        int arr[] = {5,4,2,3,1};
        int brr[] = {5,5,9,0,7};
        Heap a = new Heap(arr);
        Heap b = new Heap(brr);
        Heap ret = A.merge(a, b);
        while(!ret.empty())p(ret.poll());
    }
    public static A8.Node n(int key){
        return A.new Node(key);
    }

    public static void preorder(A8.Node root) {
        if (root == null)
            return;
        System.out.print(root+" ");
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
}