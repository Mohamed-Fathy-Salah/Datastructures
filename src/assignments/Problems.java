package assignments;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;

public class Problems {
    private static int[] arr;
    private static StringBuilder tmp;

    static void pb(boolean x) {
        if (x)
            System.out.println("found");
        else
            System.out.println("not found");
    }

    static void p(Object i) {
        System.out.println(i);
    }

    public static void dtb2(int n, int b) {
        if (n <= 0)
            return;
        dtb2(n / b, b);
        int x = n % b;
        if (x > 9)
            x += 'A' - 10;
        else
            x += '0';
        tmp.append(Character.toChars(x));
    }

    /*
     * decimal to base func converts any decimal to any base n : the decimal number
     * b : the base return the converted number example : dtb(164,16) -->> A4
     */
    /*
     * public static String dtb(int n, int b) { Stack<Integer> s = new Stack<>();
     * while (n > 0) { int x = n % b; if (x > 9) x += 'A' - 10; else x += '0';
     * s.push(x); n /= b; } StringBuilder t = new StringBuilder(); while
     * (!s.isEmpty()) { t.append(Character.toChars(s.top())); s.pop(); } return
     * t.toString(); }
     */

    /*
     * given array return all non-duplicate values in it example
     * {1,2,2,2,65,2,3,4,5} return -> {1,2,65,3,4,5} O(n^2) ## could be done in o(n)
     */
    public static boolean contains(int[] a, int limit, int val) {
        for (int i = 0; i < limit; i++)
            if (a[i] == val)
                return true;
        return false;
    }

    public static int[] withoutDuplicates(int[] a) {
        int[] t = new int[a.length];
        int idx = 0;
        for (int i = 0; i < a.length; i++)
            if (!contains(t, idx, a[i]))
                t[idx++] = a[i];
        int[] ret = new int[idx];
        for (int i = 0; i < idx; i++)
            ret[i] = t[i];
        return ret;
    }

    public static Object[] concat(Object[] a, Object[] b) {
        Object[] c = new Object[a.length + b.length];
        for (int i = 0; i < a.length; i++)
            c[i] = a[i];
        for (int i = 0; i < b.length; i++)
            c[i + a.length] = b[i];
        return c;
    }

    // "hi brother" -> "brother hi"
    /*
     * public static void reverseSentence(String a) { Stack<StringBuilder> s = new
     * Stack<>(); s.push(new StringBuilder()); for (int i = 0; i < a.length(); i++)
     * { if (a.charAt(i) != ' ') s.top().append(a.charAt(i)); else s.push(new
     * StringBuilder()); } while (!s.isEmpty()) { System.out.println(s.top());
     * s.pop(); } }
     */
    /*
     * public static void copyStack(Stack<Integer> a, Stack<Integer> b) { if
     * (a.isEmpty()) return; int n = a.top(); a.pop(); copyStack(a, b); b.push(n); }
     */

    // public static void reverseQueue(Queue a, Queue b) {
    //     if (a.empty())
    //         return;
    //     int n = a.remove();
    //     reverseQueue(a, b);
    //     b.insert(n);
    // }

    // public static void reverseQueue(Queue q) {
    //     if (q.empty())
    //         return;
    //     int f = q.remove();
    //     reverseQueue(q);
    //     q.insert(f);
    // }

    public static void removeNegative(Stack<Integer> s) {
        if (s.empty())
            return;
        int n = s.pop();
        removeNegative(s);
        if (n >= 0)
            s.push(n);
    }

    public static void swap(int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void bubbleSort(int s, int e) {
        for (int i = e; i >= s; i--)
            for (int j = s; j < i; j++)
                if (arr[j] < arr[j + 1])
                    swap(j, j + 1);
    }

    public static void selectionSort(int s, int e) {
        for (int i = s; i <= e; i++) {
            int min = i;
            for (int j = i + 1; j <= e; j++)
                if (arr[min] > arr[j])
                    min = j;
            swap(i, min);
        }
    }

    public static void insertionSort(int s, int e) {
        for (int i = s + 1; i <= e; i++) {
            int t = arr[i], j = i;
            for (; j > s && arr[j - 1] > t; j--)
                arr[j] = arr[j - 1];
            arr[j] = t;
        }
    }

    public void dfs(ArrayList<ArrayList<Integer>> g,int i){
        Stack<Integer> s = new Stack<>();
        boolean vis[] = new boolean[g.size()];
        s.push(i);
        vis[i] =true;
        while(!s.empty()){
            int t = s.pop();
            System.out.print(t+" ");
            for (int j : g.get(t))if(!vis[j]){
                vis[j] =true;
                s.push(j);
            }
        }
    }
    public void bfs(ArrayList<ArrayList<Integer>> g,int i){
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[g.size()];
        q.add(i);
        vis[i] = true;
        while(!q.isEmpty()){
            int f = q.poll();
            System.out.print(f+" ");
            for (int  j: g.get(f))if(!vis[j]){
                vis[j] = true; 
                q.add(j);
            }
        }
    }
}
