package nonlinear;

public class BST<T extends Comparable<? super T>> {
    private class Node {
        T data;
        Node left, right;

        Node(T newData) {
            data = newData;
        }
        @Override
        public String toString() {
            return data.toString();
        }
    }

    private Node root;

    public void insert(T data) {
        Node newNode = new Node(data);
        Node cur = root, prev=  root;
        while (cur != null) {
            prev = cur;
            if (data.compareTo(cur.data)<0)cur = cur.left;
            else cur = cur.right;
        }
        if(prev ==null) root  = newNode;
        else if(data.compareTo(prev.data)<0)prev.left = newNode;
        else prev.right = newNode;
    }
    public boolean search(T data){
        Node cur = root;
        while(cur != null){
            int cmp = data.compareTo(cur.data);
            if(cmp==0)return true;
            if(cmp >0)cur = cur.right ;
            else cur  = cur.left;
        }
        return false;
    } 
    private void inorder(Node root){
        if(root == null)return;
        inorder(root.left);
        System.out.println(root);
        inorder(root.right);
    }
    public void inorder(){
        inorder(root);
    }
    public T max(){
        if(root == null)return null;
        Node cur = root ;
        while(cur.right!=null)cur = cur.right;
        return cur.data;
    }
    public T min(){
        if(root == null)return null;
        Node cur = root ;
        while(cur.left!=null)cur = cur.left;
        return cur.data;
    }
    public int maxDepth(){
        return maxDepthHelper(root);
    }

    private int maxDepthHelper(Node rt) {
        if(rt == null)return -1;
        return 1+Math.max(maxDepthHelper(rt.left),maxDepthHelper(rt.right));
    }
}
