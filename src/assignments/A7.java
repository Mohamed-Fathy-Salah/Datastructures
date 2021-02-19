package assignments;

public class A7 {
    /*
     * Another simple sort is the odd-even sort. The idea is to repeatedly make two
     * passes through the array. On the first pass you look at all the pairs of
     * items, a[j] and a[j+1], where j is odd (j = 1, 3, 5, ...). If their key
     * values are out of order, you swap them. On the second pass you do the same
     * for all the even values (j = 2, 4, 6, ...). You do these two passes
     * repeatedly until the array is sorted. Replace the bubbleSort() method with an
     * oddEvenSort() method. Make sure it works for varying amounts of data. You’ll
     * need to figure out how many times to do the two passes.
     */
    public int oddEvenSort(int arr[]) {
        boolean go = true;
        int cnt = 0;
        while (go) {
            go = false;
            for (int j = 0; j < 2; j++)
                for (int i = j; i + 1 < arr.length; i += 2)
                    if (arr[i + 1] < arr[i]) {
                        int t = arr[i];
                        arr[i] = arr[i + 1];
                        arr[i + 1] = t;
                        cnt++;
                        go = true;
                    }
        }
        return cnt;
    }
}
