package assignments;

import java.util.ArrayList;
import java.util.Stack;

public class A8 {
    public class Node {
        public int key;
        public Node left, right;

        public Node(int key) {
            this.key = key;
        }

        @Override
        public String toString() {
            return Integer.toString(key);
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null)
                return false;
            return key == ((Node) obj).key;
        }
    }

    // Count the number of nodes in a binary tree.
    public int countNodes(Node root) {
        if (root == null)
            return 0;
        Stack<Node> s = new Stack<>();
        s.add(root);
        int cnt = 0;
        while (!s.isEmpty()) {
            Node t = s.pop();
            cnt++;
            if (t.left != null)
                s.add(t.left);
            if (t.right != null)
                s.add(t.right);
        }
        return cnt;
    }

    // Count the number of leaves in a binary tree.
    public int countLeaves(Node root) {
        if (root == null)
            return 0;
        Stack<Node> s = new Stack<>();
        s.add(root);
        int cnt = 0;
        while (!s.isEmpty()) {
            Node t = s.pop();
            int ss = s.size();
            if (t.left != null)
                s.add(t.left);
            if (t.right != null)
                s.add(t.right);
            if (ss == s.size())
                cnt++;
        }
        return cnt;
    }

    // Count the number of right children.
    public int countRight(Node root) {
        if (root == null)
            return 0;
        Stack<Node> s = new Stack<>();
        s.add(root);
        int cnt = 0;
        while (!s.isEmpty()) {
            Node t = s.pop();
            if (t.left != null)
                s.add(t.left);
            if (t.right != null) {
                s.add(t.right);
                cnt++;
            }
        }
        return cnt;
    }

    // Search a node in a binary tree.
    public Node findNode(int key, Node root) {
        if (root == null)
            return null;
        Stack<Node> s = new Stack<>();
        s.add(root);
        while (!s.isEmpty()) {
            Node t = s.pop();
            if (t.key == key)
                return t;
            if (t.left != null)
                s.add(t.left);
            if (t.right != null)
                s.add(t.right);
        }
        return null;
    }

    // Find a sub-tree in a binary tree.
    public Node findSubTree(Node root, Node subTreeRoot) {
        if (root == null || subTreeRoot == null)
            return null;
        Stack<Node> s = new Stack<>();
        s.add(root);
        while (!s.isEmpty()) {
            Node t = s.pop();
            if (matches1(t, subTreeRoot))
                return t;
            if (t.left != null)
                s.add(t.left);
            if (t.right != null)
                s.add(t.right);
        }
        return null;
    }

    private boolean matches1(Node a, Node b) {
        if (a == null || b == null)
            return (a == null) == (b == null);
        if (!a.equals(b))
            return false;
        if (b.left != null)
            if (!matches1(a.left, b.left))
                return false;
        if (b.right != null)
            if (!matches1(a.right, b.right))
                return false;
        return true;
    }

    private boolean matches2(Node a, Node b) {
        if ((a == null) || (b == null))
            return (a == null) == (b == null);
        Stack<Node> aa = new Stack<>();
        Stack<Node> bb = new Stack<>();
        aa.add(a);
        bb.add(b);
        while (!bb.isEmpty()) {
            Node ta = aa.pop();
            Node tb = bb.pop();
            if (!ta.equals(tb))
                return false;
            if (tb.left != null) {
                if (ta.left == null)
                    return false;
                aa.add(ta.left);
                bb.add(tb.left);
            }
            if (tb.right != null) {
                if (ta.right == null)
                    return false;
                aa.add(ta.right);
                bb.add(tb.right);
            }
        }
        return true;
    }

    // Find the height of the tree.
    public int hight(Node root) {
        if (root == null)
            return -1;
        return Math.max(hight(root.left), hight(root.right)) + 1;
    }

    // Delete all leaves from a binary tree.
    public void removeLeaves(Node root) {
        if (root == null)
            return;
        Stack<Node> s = new Stack<>();
        s.add(root);
        while (!s.isEmpty()) {
            Node t = s.pop();
            if (isLeaf(t.left))
                t.left = null;
            else
                s.push(t.left);
            if (isLeaf(t.right))
                t.right = null;
            else
                s.push(t.right);
        }
    }

    public boolean isLeaf(Node root) {
        if (root == null)
            return false;
        return root.left == null && root.right == null;
    }
}
