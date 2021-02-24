public class Sort {
    public static void MergeSort(int[] arr, int s, int e) {
        if (e <= s)
            return;
        int m = (s + e) >> 1;
        MergeSort(arr, s, m);
        MergeSort(arr, m + 1, e);
        merge(arr, s, e);
    }

    //O(n^2) donot use extra memory
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

    //O(n) but uses extra memory
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
}