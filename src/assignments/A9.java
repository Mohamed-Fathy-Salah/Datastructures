package assignments;

import nonlinear.Heap;

public class A9 {
    /*
     * Given two binary max heaps as arrays, make a function that take the two heaps
     * as input and merge the given heaps. What is the minimum possible time
     * complexity to make the new heap?
     */
    // time complexity O(nlogn + mlogm) where n , m are the sizes of Heaps a,b
    // i believe we could do O(n+m) using two pointer technique
    public Heap merge(Heap a, Heap b) {
        int arr[] = new int[a.size() + b.size()], i = 0;
        // O(nlogn + mlogm) where n , m are the sizes of Heaps a,b
        while (!a.empty() && !b.empty()) {
            if (a.peek() > b.peek())
                arr[i++] = a.poll();
            else
                arr[i++] = b.poll();
        }
        while (!a.empty())
            arr[i++] = a.poll();
        while (!b.empty())
            arr[i++] = b.poll();
        // my implementation of the constructor checks if the array is sorted then it
        // assignes it to the internal array as it is .so the time complexity of it is
        // O(n+m) which is the size of the array given to it
        return new Heap(arr);
    }
}
