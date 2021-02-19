package nonlinear;

import java.util.ArrayList;

public class BIT<T extends Comparable<? super T>> {
    private ArrayList<T> arr;
    public BIT() {
        arr = new ArrayList<>();
    }
    public void insert(T data){
        arr.add(data);
    }
    public int hight(){
        // todo this is not right
        return log2(arr.size()+1);
    } 
    private int log2(double x){return (int)(Math.log(x)/Math.log(2));}
    public void inorder(){
        inorder(0);
    } 
    private void inorder(int i){
        if(i>=arr.size())return ;
        inorder(2*i+1);
        System.out.println(arr.get(i));
        inorder(2*i+2);
    }
}