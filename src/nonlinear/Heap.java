package nonlinear;

public class Heap{
    private int arr[],maxSize , filled;
    public Heap(){
        maxSize = 7;
        filled = 0;
        arr = new int [maxSize];
    }
    public Heap(int arr[]){
        if(arr.length == 0){
            // this();
            return ;
        }
        filled = maxSize = arr.length;
        this.arr = arr;
        int i = (filled>>1)-1;
        while(i>=0)
            trickleDown(i--);
    }
    public void insert(int data){
        if(filled())increaseSize();
        filled++;
        trickleUp(data);
    }

    public int poll() {
        if(empty())return (Integer) null;
        int tmp = arr[0];
        arr[0] = arr[--filled];
        trickleDown(0);
        return tmp;
    }
    
    public int peek() {
        if(empty())return (Integer) null;
        return arr[0];
    }
    public int size(){return filled;}
    public boolean empty(){return filled == 0;}
    public void print(){
        System.out.print("{");
        for (int i = 0; i < filled; i++)
            System.out.print(" "+arr[i]);
        System.out.println("}");
    }
    private void increaseSize(){
        maxSize<<=1; 
        int tmp[] = new int[maxSize];
        for (int i = 0; i < arr.length; i++)tmp[i] = arr[i];
        arr = tmp;
    }
    private void trickleUp(int data) {
        int i = filled -1;
        while(i>0 && arr[parent(i)]<data)arr[i] = arr[i=parent(i)];
        arr[i] = data;
    }
    private void trickleDown(int i) {
        int r=0,l=0,tmp = arr[i];
        while((r=right(i))<filled ){
            l = r-1;
            if(arr[r]<=tmp&&arr[l]<=tmp)break;
            if(arr[r]<arr[l]){
                arr[i] = arr[l];
                i = l;
            }else{
                arr[i] = arr[r];
                i = r;
            }
        }
        l = r-1;
        if(l<filled && arr[l]>tmp){
            arr[i] = arr[l];
            i = l;
        }
        arr[i] = tmp;
    }
    private boolean filled(){return filled == maxSize;}
    private int parent(int i){return (i-1)>>1;}
    private int left(int i){return (i<<1)+1;}
    private int right(int i){return (i<<1)+2;}
}