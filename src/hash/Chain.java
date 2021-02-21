package hash;

import java.util.ArrayList;

public class Chain implements Hashable {
    private ArrayList<Integer> arr[];
    private int maxSize,filled,used;
    public Chain(){
        maxSize = 13;
        arr = new ArrayList[maxSize];
        for (int i = 0; i < arr.length; i++) 
            arr[i] = new ArrayList<>();
        filled = used = 0;
    }
    private void increaseSize() {
        ArrayList<Integer> tmp[] = arr.clone();
        maxSize = Helper.nextPrime(maxSize);
        arr = new ArrayList[maxSize];
        for (int i = 0; i < arr.length; i++) 
            arr[i] = new ArrayList<>();
        filled = used = 0;
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
        if(isFilled())increaseSize();
        filled ++;
        int hh = h(key);
        arr[hh].add(key);
        if(arr[hh].size() == 1)used ++;
        return hh;
    }
    @Override
    public boolean find(int key) {
        int hh = h(key);
        for(int i:arr[hh])if(i == key)return true;
        return false;
    }
    @Override
    public boolean isFilled() {
        return (double)filled/used>=2.0;
    }
    @Override
    public int size() {
        return filled;
    }
    @Override
    public void delete(int key) {
        int hh = h(key);
        int s = arr[hh].size();
        arr[hh].remove(key);
        if(arr[hh].size()!=s){
            filled--;
            if(s == 1)used--;
        }
    }
    public void print(){
        System.out.print("{");
        for (int i = 0; i < arr.length; i++) {
            System.out.print("[");
            for (int j : arr[i])System.out.print(j+" ");
            System.out.print("]");
        }
        System.out.println("}");
    }
}
