package nonlinear;

class Data implements Comparable<Data> {
    int key, value;

    public Data(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public int compareTo(Data b) {
        if (key > b.key)
            return 0;
        if (key < b.key)
            return -2;
        return -1;
    }

    @Override
    public String toString() {
        return "key: "+key+", value: "+value;
    }
}