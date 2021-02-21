package assin2;
public class Assignment4 {
    private static int arr[];

    public static void main(String[] args) {
        arr = new int[10];
        for (int i = 0; i < 10; i++)
            arr[i] = (int) (Math.random() * 10)-5;
        System.out.println("original array");
        print();

        insertionSort();
        System.out.println("after sorting and removing duplicates");
        print();
    }

    public static void print(){
        System.out.print("{");
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ,");
        System.out.println("}");
    }
    public static void insertionSort() {
        for (int i = 0; i < arr.length; i++) {
            int t = arr[i], j = i;
            for (; j >= 1 && arr[j - 1] >= t; j--){
                //if duplicate give it the minimum value 
                //to be put in the first index
                if(t == arr[j-1])t = Integer.MIN_VALUE;
                arr[j] = arr[j - 1];
            }
            arr[j] = t;
        }
        //resize the array
        int s=0;
        for(;s<arr.length && arr[s]==Integer.MIN_VALUE;s++);
        int[] tmp  = new int[arr.length-s];
        for(int i=0;i<tmp.length;i++)
            tmp[i] = arr[i+s];
        arr = tmp;
    }
}
/* sample output
original array
{2 ,-1 ,-3 ,-2 ,1 ,1 ,-3 ,-5 ,-5 ,-4 ,}

after sorting and removing duplicates
{-5 ,-4 ,-3 ,-2 ,-1 ,1 ,2 ,} 
*/