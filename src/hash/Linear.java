package hash;

import java.util.Arrays;

public class Linear implements Hashable {
    protected static final int NOT_USED = Integer.MIN_VALUE;
    protected static final int DELETED = Integer.MIN_VALUE - 1;
    protected int arr[];
    protected int maxSize, filled;

    public Linear() {
        filled = 0;
        maxSize = 13;
        arr = new int[maxSize];
        Arrays.fill(arr, NOT_USED);
    }

    protected void increaseSize() {
        int tmp[] = arr.clone();
        maxSize = Helper.nextPrime(maxSize);
        arr = new int[maxSize];
        Arrays.fill(arr, NOT_USED);
        for (int i = 0; i < tmp.length; i++)
            if (tmp[i] != NOT_USED && tmp[i]!=DELETED)
                push(tmp[i]);
    }

    public boolean find(int i) {
        for (int j = 0, idx = h(i); j < maxSize; j++, idx = (h(i) + f(j)) % maxSize)
            if (arr[idx] == i)
                return true;
        return false;
    }

    @Override
    public int h(int key) {
        return key % maxSize;
    }

    @Override
    public int f(int i) {
        return i;
    }

    @Override
    public boolean isFilled() {
        return filled == maxSize;
    }

    @Override
    public int push(int key) {
        if (isFilled())
            increaseSize();
        filled++;
        int hh = h(key);
        for (int i = 0, idx = hh; i < maxSize; idx = (hh + f(++i)) % maxSize)
            if (arr[idx] == NOT_USED || arr[idx] == DELETED) {
                arr[idx] = key;
                return idx;
            }
        return -1;
    }

    @Override
    public int size() {
        return filled;
    }

    public void print() {
        System.out.print("{");
        for (int i = 0; i < maxSize; i++){
            if(arr[i] == DELETED || arr[i] == NOT_USED)System.out.print("_");
            else System.out.print(arr[i]);
            System.out.print(" ,");
        }
        System.out.println("}");
    }

    @Override
    public void delete(int key) {
        for (int j = 0, idx = h(key); j < maxSize; j++, idx = (h(key) + f(j)) % maxSize)
            if (arr[idx] == key) {
                arr[idx] = DELETED;
                filled--;
                return;
            }
    }
}