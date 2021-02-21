package assignments;

import java.util.Arrays;

public class A1 {
    /*
     * Write and test this method: int[] withoutDuplicates(int[] a) The method
     * returns the specified array after removing all duplicates.
     */
    int[] withoutDuplicates(int[] a){
        Arrays.sort(a);
        int ret[] = new int[a.length];
        ret[0] = a[0];
        int j = 1;
        for(int i=1;i<a.length;i++)if(a[i]!=a[i-1])ret[j++] = a[i];
        int tmp[] = new int[j];
        for(int i=0;i<j;i++)tmp[i] = ret[i];
        return tmp;
    }
    /*
     * Write and test this method: Object[] concatenate(Object[] a, Object[] b) The
     * method concatenates all of a[] followed by all of b[] and returns an array as
     * a result of the concatenation.
     */
    Object[] concatente(Object[] a,Object[] b){
        Object ret[] = new Object[a.length+b.length];
        int j = 0;
        for (int i = 0; i < a.length; i++)ret[j++] = a[i];
        for (int i = 0; i < b.length; i++)ret[j++] = b[i];
        return ret;
    }
}
