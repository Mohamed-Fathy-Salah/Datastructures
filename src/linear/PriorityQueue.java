package linear;
public class PriorityQueue{
    private int maxSize, full;
    private int[] arr;
    PriorityQueue(int size){
        maxSize  = size;
        arr = new int[maxSize];
        full =0;
    }
    private void check(){
        if(!full())return ;
        maxSize *=2;
        int [] tmp = new int[maxSize];
        for (int i = 0; i < arr.length; i++) {
            tmp[i] = arr[i];
        }
        arr = tmp;
    }
    public void insert(int n){
        check();
        arr[full] = n;
        for(int i = full-1; i>=0 && arr[i]>arr[i+1];i--){
            int tmp = arr[i];
            arr[i] = arr[i+1];
            arr[i+1] = tmp;
        }
        full++;
    }
    public int remove(){
        if(empty())return -1;
        return arr[--full] ;
    }
    public int peek(){
        if(empty())return -1;
        return arr[full-1];
    }
    public int size(){return full;}
    public boolean empty(){return full==0;}
    public boolean full(){return full==maxSize;}
    public void print(){
        for(int i=full-1;i>=0;i--){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}