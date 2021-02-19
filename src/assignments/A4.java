package assignments;


public class A4 {
    public String decimalToBinary(int n) {
        StringBuilder s = new StringBuilder();
        while (n > 0) {
            s.append(n & 1);
            n >>= 1;
        }
        return s.reverse().toString();
    }

    public String decimalToBase(int n, int b) {
        StringBuilder s = new StringBuilder();
        while (n > 0) {
            int x = n % b;
            if (x > 9)
                s.append((char) ('A' + x - 10));
            else
                s.append(x);
            n /= b;
        }
        return s.reverse().toString();
    }

    public static class TwoStacks {
        private int arr[], l, r;

        public TwoStacks() {
            arr = new int[10];
            l = 0;
            r = 9;
        }

        public void push1(int x) {
            if (l > r)
                return;
            arr[l++] = x;
        }

        public void push2(int x) {
            if (l > r)
                return;
            arr[r--] = x;
        }

        public int pop1() {
            if(l==0)return -1;
            return arr[--l];
        }

        public int pop2() {
            if(r==9)return -1;
            return arr[++r];
        }
        @Override
        public String toString() {
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < arr.length; i++)s.append(arr[i]+" ");
            return s.toString();
        }
    }
}