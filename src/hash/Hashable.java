package hash;
public interface Hashable {
   public int h(int key); 
   public int f(int i); 
   public int push(int key);
   public boolean find(int key);
   public boolean isFilled();
   public int size();
   public void delete(int key);
}
