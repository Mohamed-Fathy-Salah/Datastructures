import javax.lang.model.element.QualifiedNameable;

import linear.Link;
import linear.LinkedList;

public class Sort {
    public static void swap(int arr[],int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void bubbleSort(int arr[],int s, int e) {
        for (int i = e; i >= s; i--)
            for (int j = s; j < i; j++)
                if (arr[j] < arr[j + 1])
                    swap(arr,j, j + 1);
    }

    public static void selectionSort(int arr[],int s, int e) {
        for (int i = s; i <= e; i++) {
            int min = i;
            for (int j = i + 1; j <= e; j++)
                if (arr[min] > arr[j])
                    min = j;
            swap(arr,i, min);
        }
    }

    public static void insertionSort(int arr[],int s, int e) {
        for (int i = s + 1; i <= e; i++) {
            int t = arr[i], j = i;
            for (; j > s && arr[j - 1] > t; j--)
                arr[j] = arr[j - 1];
            arr[j] = t;
        }
    }
    public static void mergeSort(int[] arr, int s, int e) {
        if (e <= s)
            return;
        int m = (s + e) >> 1;
        mergeSort(arr, s, m);
        mergeSort(arr, m + 1, e);
        merge(arr, s, e);
    }

    // O(n^2) donot use extra memory
    private static void mergeInPlace(int[] arr, int s, int e) {
        int m = (s + e) >> 1, l = s, r = m + 1;
        while (l <= m && r <= e) {
            if (arr[r] < arr[l]) {
                int x = r, tmp = arr[r];
                while (x != l)
                    arr[x] = arr[--x];
                arr[l] = tmp;
                m++;
                r++;
            }
            l++;
        }
    }

    // O(n) but uses extra memory
    private static void merge(int[] arr, int s, int e) {
        int[] tmp = new int[e - s + 1];
        int m = (s + e) >> 1, l = s, r = m + 1, idx = 0;
        while (l <= m && r <= e) {
            if (arr[l] < arr[r])
                tmp[idx] = arr[l++];
            else
                tmp[idx] = arr[r++];
            idx++;
        }
        while (l <= m)
            tmp[idx++] = arr[l++];
        while (r <= e)
            tmp[idx++] = arr[r++];
        idx = 0;
        while (s <= e)
            arr[s++] = tmp[idx++];
    }
    public static void shellSort(int arr[]){
        int n = arr.length;
        for (int gap = n/2; gap > 0; gap /= 2){
            for (int i = gap; i < n; i += 1){
                int temp = arr[i],j = i;
                for (; j >= gap && arr[j - gap] > temp; j -= gap)
                    arr[j] = arr[j - gap];
                arr[j] = temp;
            }
        }
    }

    public static void shellSortKnuth(int arr[]){
        int n = arr.length , gap = 1;
        while(gap < n/3) gap = 3*gap +1;
        for (; gap > 0; gap= (gap-1)/3){
            for (int i = gap; i < n; i += 1){
                int temp = arr[i],j = i;
                for (; j >= gap && arr[j - gap] > temp; j -= gap)
                    arr[j] = arr[j - gap];
                arr[j] = temp;
            }
        }
    }
    public static void QuickSort(int arr[],int s,int e){
        if(s>=e)return;
        int pidx = partition(arr,s,e);
        QuickSort(arr, s, pidx-1);
        QuickSort(arr, pidx+1, e);
    }
    private static int partition (int arr[],int s,int e){
        int piv = arr[e],pidx = s-1;
        for(int i = s;i<e;i++)
            if(arr[i]<piv)
                swap(arr,i,++pidx);
        swap(arr,e,++pidx);
        return pidx;
    }
    //--------------Linked List----------------

    public static void mergeSort(LinkedList l) {
        l.setFirst(mergeSort(l.getFirst()));
    }

    private static Link mergeSort(Link head) {
        if (head == null || head.next == null)
            return head;
        Link middle = getMiddle(head);
        Link middleNext = middle.next;
        middle.next = null;
        Link left = mergeSort(head);
        Link right = mergeSort(middleNext);
        head = merge(left, right);
        return head;
    }

    private static Link merge(Link a, Link b) {
        if (a == null)
            return b;
        if (b == null)
            return a;
        Link ret;
        if (a.data.compareTo(b.data) < 0) {
            ret = a;
            ret.next = merge(a.next, b);
        } else {
            ret = b;
            ret.next = merge(a, b.next);
        }
        return ret;
    }

    private static Link getMiddle(Link head) {
        Link fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++)
            if (arr[i] < arr[i - 1])
                return false;
        return true;
    }
}