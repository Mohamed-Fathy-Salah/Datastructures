package exams;

import java.util.Stack;

public class OurMid{
    public static void main(String[] args) {
        test1b();
        test2b();
    }
    private static void test2b(){
        System.out.println(isPal("abba"));
        System.out.println(isPal("acba"));
        System.out.println(isPal("abcba"));
        System.out.println(isPal("akcba"));
    }
    private static void test1b(){
        // 2 3 18 22 25 40
        link a = new link(2);
        a.next = new link(3);
        a.next.next = new link(18);
        a.next.next.next = new link(22);
        a.next.next.next.next = new link(25);
        a.next.next.next.next.next = new link(40);

        // 5 18 20 22 25 42
        link b = new link(5);
        b.next = new link(18);
        b.next.next = new link(20);
        b.next.next.next = new link(22);
        b.next.next.next.next = new link(25);
        b.next.next.next.next.next = new link(42);

        System.out.print("intersect :");
        link c = intersect(a, b);
        while(c != null){
            System.out.print(c.val+" ");
            c = c.next;
        }
        System.out.print("\nunion :");
        c = union(a, b);
        while(c != null){
            System.out.print(c.val+" ");
            c = c.next;
        }
        System.out.println();
    }
    private static class link{
        public link next;
        public int val;
        public link(int val){
            this.val = val;
        }
    }
    private static link union(link l1,link l2){
        link ret = new link(Integer.MIN_VALUE);
        link cur = ret;
        while(l1 != null && l2 != null){
            if(l1.val > l2.val){
                if(cur.val != l2.val){
                    cur.next = new link(l2.val);
                    cur = cur.next ;
                }
                l2 = l2.next;
            }else {
                if(cur.val != l1.val){
                    cur.next = new link(l1.val);
                    cur = cur.next;
                }
                l1 = l1.next;
            }
        }
        while(l1 != null){
            if(cur.val != l1.val){
                cur.next = new link(l1.val);
                cur = cur.next;
            }
            l1 = l1.next;
        }
        while(l2 != null){
            if(cur.val != l2.val){
                cur.next = new link(l2.val);
                cur = cur.next ;
            }
            l2 = l2.next;
        }
        return ret.next;
    }
    // 1b
    private static link intersect(link a,link b){
        link ret = new link(Integer.MIN_VALUE); 
        link cur = ret;
        while(a!=null &&b!=null){
            if(a.val < b.val)a= a.next;
            else if(b.val < a.val)b= b.next;
            else {
                if(cur.val != a.val){
                    cur.next = new link(a.val);
                    cur = cur.next;
                }
                a = a.next;
                b = b.next;
            }
        }
        return ret.next;
    }

    //2b
    private static boolean isPal(String str){
        Stack<Character> s = new Stack<>();
        //abba
        //abcba
        int n  = str.length()/2,i = 0;
        for(;i<n;i++)s.push(str.charAt(i));
        i += (str.length()&1);// if odd add 1
        for(;i<str.length();i++)
            if(str.charAt(i)!= s.pop())
                return false;
        return true;
    }
}
