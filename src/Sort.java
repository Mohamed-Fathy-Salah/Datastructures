import linear.Link;
import linear.LinkedList;

public class Sort {
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
}