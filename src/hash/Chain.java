package hash;

import java.util.ArrayList;

public class Chain implements Hashable {
    private ArrayList<Integer> arr[];
    private int maxSize,filled;
    public Chain(){
        maxSize = 13;
        arr = new ArrayList[maxSize];
        for (int i = 0; i < arr.length; i++) 
            arr[i] = new ArrayList<>();
        filled = 0;
    }
    private void increaseSize() {
        ArrayList<Integer> tmp[] = arr.clone();
        maxSize = Helper.nextPrime(maxSize);
        arr = new ArrayList[maxSize];
        for (int i = 0; i < tmp.length; i++)
            for (int al : tmp[i])
                push(al);
    }
    @Override
    public int h(int key) {
        return key%maxSize;
    }
    @Override
    public int f(int i) {return 0;}
    @Override
    public int push(int key) {
        // TODO Auto-generated method stub
        return 0;
    }
    @Override
    public boolean find(int key) {
        // TODO Auto-generated method stub
        return false;
    }
    // return true if the ratio is above 2  
    @Override
    public boolean isFilled() {
        // TODO Auto-generated method stub
        return false;
    }
    @Override
    public int size() {
        return filled;
    }
    @Override
    public void delete(int key) {
        // TODO Auto-generated method stub
    }
}
