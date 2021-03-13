import java.util.Random;
import java.util.stream.Collectors;

import java.util.Arrays;
import java.util.LinkedList;

public class Main {
    private static Random r = new Random();
    public static void main(String[] args) {
        testSearchTreeNode();
    }

    public static void testSearchTreeNode(){
        TreeNode root = new TreeNode(1);
        insert(root,new Integer[]{2,3});
        insert(root.children.getFirst(),new Integer[]{4,5,6});
        insert(root.children.getLast(),new Integer[]{7 , 8 , 9 , 10});
        insert(root.children.getFirst().children.getFirst(),new Integer[]{11,12});

        System.out.println("the whole tree\t"+root);
        System.out.println("search 11\t"+searchTree(root,  11));
        System.out.println("search 4\t"+searchTree(root, 4));
        System.out.println("search 13\t"+searchTree(root, 13));
    }
    public static void insert(TreeNode t,Integer arr[]){
        t.children.addAll(Arrays.asList(arr).stream().map(a->new TreeNode(a)).collect(Collectors.toList()));
    }
    private static class TreeNode{
        public int key;
        public LinkedList<TreeNode> children;
        public TreeNode(int key){
            this.key = key;
            children = new LinkedList<>();
        }
        @Override
        public String toString() {
            return key +":"+ children.toString();
        }
    }
    // for undirected tree 
    // call with searchTree(root,null , val);
    public static TreeNode searchTree(TreeNode start,TreeNode parent,int val){
        if(start.key == val)return start;
        for (TreeNode child : start.children)if(child != parent){
            TreeNode ret = searchTree(child , start , val);
            if(ret != null)return ret;
        }
        return null;
    }
    // for directed tree
    // call with searchTree(root, val);
    public static TreeNode searchTree(TreeNode start,int val){
        if(start.key == val)return start;
        for (TreeNode child : start.children){
            TreeNode ret = searchTree(child , val);
            if(ret != null)return ret;
        }
        return null;
    }


    public static void p(Object s) {
        System.out.println(s);
    }

    public static void pa(int arr[]) {
        for (int i : arr)
            System.out.print(i + " ");
        System.out.println();
    }
}