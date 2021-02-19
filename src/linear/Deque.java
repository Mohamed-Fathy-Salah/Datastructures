package linear;
public class Deque {
    private DoublyLinkedList<Integer> l ;
    Deque(){
        l = new DoublyLinkedList<>();
    }
    public void pushFront(int n){
        l.pushFront(n);
    }
    public void pushBack(int n){
        l.pushBack(n);
    }
    public int front(){
        return l.front();
    }
    public int back(){
        return l.back();
    }
    public void popFront(){
        l.popFront();
    } 
    public void popBack(){
        l.popBack();
    }
    public int getSize(){
        return l.getSize();
    }
    public boolean isEmpty(){
        return l.isEmpty();
    }
}
