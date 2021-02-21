package assin2;
import java.util.Stack;

public class Assignment5 {
    public static void main(String[] args) {
/*  
       50
     /     \
   40       70
  /   \    /  \
30     45 60   75 
*/
        int pre[] = { 50, 40, 30, 45, 70, 60, 75 };
        System.out.println("preorder array");
        for(int i:pre)
            System.out.print(i+", ");

        Node root = constructBST(pre);
        System.out.println("\n\nafter construction");

        System.out.println("\ninorder");
        inorder(root);

        System.out.println("\npreorder");
        preorder(root);

        System.out.println("\npostorder");
        postorder(root);
    }

    public static Node constructBST(int[] pre) {
        if(pre.length==0)return null;
        Stack<Node> s = new Stack<>();
        Node root = new Node(pre[0]);
        s.push(root);
        for (int i = 1; i < pre.length; i++) {
            Node nn = new Node(pre[i]);
            if (s.peek().val > nn.val)
                s.peek().left = nn;
            else {
                Node l= s.peek();
                while(!s.isEmpty()&&s.peek().val<nn.val)l = s.pop();
                l.right= nn;
            }
            s.push(nn);
        }
        return root;
    }

    public static void inorder(Node root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root + ", ");
        inorder(root.right);
    }

    public static void preorder(Node root) {
        if (root == null)
            return;
        System.out.print(root + ", ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void postorder(Node root) {
        if (root == null)
            return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root + ", ");
    }

    //the root here is alwayes not null
    public static void insert(Node root, int val) {
        if (root.val > val) {
            if (root.left == null)
                root.left = new Node(val);
            else
                insert(root.left, val);
        } else {
            if (root.right == null)
                root.right = new Node(val);
            else
                insert(root.right, val);
        }
    }
}

class Node {
    public int val;
    public Node left, right;

    public Node(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return Integer.toString(val);
    }
}
/*
        50
     /     \
   40       70
  /   \    /  \
30     45 60   75
-------sample output for the above bst:

preorder array
50, 40, 30, 45, 70, 60, 75, 

after construction

inorder
30, 40, 45, 50, 60, 70, 75, 
preorder
50, 40, 30, 45, 70, 60, 75, 
postorder
30, 45, 40, 60, 75, 70, 50,
*/