package hash;

public class Quadratic extends Linear {
    public Quadratic(){super();}
    @Override
    public int f(int i) {
        return i*i;
    }
    @Override
    public int push(int key) {
        int idx = super.push(key);
        if(idx != -1)return idx;
        super.increaseSize();
        return push(key);
    }
}
