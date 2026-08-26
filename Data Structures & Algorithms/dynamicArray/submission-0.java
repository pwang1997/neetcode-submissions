class DynamicArray {
    private int[] arr;
    private int lastIdx = 0;
    public DynamicArray(int capacity) {
        arr = new int[capacity];
    }

    public int get(int i) {
        return arr[i];
    }

    public void set(int i, int n) {
        arr[i] = n;
    }

    public void pushback(int n) {
        if(lastIdx < arr.length) set(lastIdx++, n);
        else {
            resize();
            pushback(n);
        }
    }

    public int popback() {
        var el = arr[--lastIdx];
        arr[lastIdx] = 0;

        return el;
    }

    private void resize() {
        int newCapacity = 2 * arr.length;
        int[] newArr = Arrays.copyOf(arr, newCapacity);
        this.arr = newArr;
    }

    public int getSize() {
        return lastIdx;
    }

    public int getCapacity() {
        return arr.length;
    }
}
