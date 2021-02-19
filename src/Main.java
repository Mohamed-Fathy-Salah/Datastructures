import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;

import assignments.A8;
import hash.Double;

public class Main {
    private static Random r = new Random();
    private static A8 A = new A8();

    public static void main(String[] args) {
        A8.Node root = A.new Node(0);
        root.left = n(1);
        root.right = n(2);
        root.left.left = n(3);
        root.left.right = n(4);
        root.left.right.right = n(5);

        A8.Node subTree = null;



        p(A.findSubTree(root, subTree));
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