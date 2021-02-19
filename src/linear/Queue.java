package linear;
public class Queue {
    private DoublyEndedList<Integer> l;
    Queue(){
        l = new DoublyEndedList<>();
    }
    public void insert(int n ){
        l.pushBack(n);
    }
    public int remove(){
        int ret = l.front();
        l.popFront();
        return ret;
    }
    public int peek(){
        return l.front();
    }
    public int getSize(){
        return l.getSize();
    }
    public boolean empty(){
        return l.isEmpty();
    }
    public void print(){
        l.print();
    }
}
