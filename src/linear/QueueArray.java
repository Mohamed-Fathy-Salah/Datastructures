package linear;
class QueueArray{
    private int[] arr;
    private int front ,tail,maxSize , full;
    QueueArray(int size){
        maxSize = size ;
        arr = new int[maxSize];
        front =tail = full = 0;
    }
    public boolean empty(){
        return full==0;
    }
    private boolean full(){
        return full == maxSize;
    } 
    private void check(){
        if(!full())return;
        maxSize = maxSize *2;
        int[] tmp = new int[maxSize];
        for(int i=0;i<arr.length;i++)tmp[i] = arr[i];
        arr = tmp;
    }
    public void insert(int n){
        check();
        tail %= maxSize;
        arr[tail++] = n;
        full++;
    }
    public int remove(){
        if(empty())return -1;
        full--;
        front %=maxSize;
        int ret = arr[front++];
        return ret;
    }
    public int peek(){
        if(empty())return -1;
        return arr[front];
    }
    public int getSize(){
        return full;
    }
    public void print(){
        for(int i = front,j = full; j!=0;i++ , j--){
            if(i >= maxSize)i -=maxSize;
          System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}