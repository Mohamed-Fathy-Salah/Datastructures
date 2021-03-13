import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import linear.Link;
import linear.LinkedList;

public class Main {
    private static Random r = new Random();
    public static void main(String[] args) {
        int arr[] = new int[11];
        for(int i = 0;i<11;i++)arr[i] = r.nextInt(10);
        pa(arr);
        Sort.QuickSort(arr,0,10);
        pa(arr);
    }
    public static void swap(int arr[] ,int i,int j){
        int t = arr[i];
        arr[i] = arr[j] ;
        arr[j] =  t;
    }

    public static void p(Object s) {
        System.out.println(s);
    }

    public static void pa(int arr[]) {
        for (int i : arr)
            System.out.print(i + " ");
        System.out.println();
    }

    public static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++)
            if (arr[i] < arr[i - 1])
                return false;
        return true;
    }
    public static boolean isSorted(LinkedList<Integer> l){
        Link prev = l.getFirst() , cur = l.getFirst();
        while(cur!=null){
            if(cur.data.compareTo(prev.data)<0)return false;
            prev = cur;
            cur = cur.next;
        }
        return true;
    }
}