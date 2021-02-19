package hash;

public class Double extends Linear {
    public Double() {
        super();
    }

    @Override
    public int f(int i) {
        return 7 - i % 7;
    }

    @Override
    public boolean find(int i) {
        int dd = f(i);
        for (int j = 0, idx = h(i); j < maxSize; j++, idx = (idx + dd) % maxSize)
            if (arr[idx] == i)
                return true;
        return false;
    }

    @Override
    public void delete(int key) {
        int dd = f(key);
        for (int j = 0, idx = h(key); j < maxSize; j++, idx = (idx + dd) % maxSize)
            if (arr[idx] == key) {
                arr[idx] = DELETED;
                filled--;
                return;
            }
    }

    @Override
    public int push(int key) {
        if (isFilled())
            increaseSize();
        filled++;
        int dd = f(key);
        for (int i = 0, idx = h(key); i < maxSize; idx = (idx + dd) % maxSize)
            if (arr[idx] == NOT_USED || arr[idx] == DELETED) {
                arr[idx] = key;
                return idx;
            }
        increaseSize();
        return push(key);
    }
}