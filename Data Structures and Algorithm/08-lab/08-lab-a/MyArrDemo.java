public class MyArrDemo<T> {
    public final int MAX_SIZE = 9;
    private int size = 0;
    private Object[] arr = new Object[MAX_SIZE];

    public void add(T instance) {
        arr[size++] = instance;
    }

    public void set(int index, T instance) {
        arr[index] = instance;
    }

    public T get(int index) {
        @SuppressWarnings("unchecked")
        final T instance = (T) arr[index];
        return instance;
    }

    public void swap(int index1, int index2) {
        T temp = get(index1);
        set(index1, get(index2));
        set(index2, temp);
    }

    public int currentSize() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size - 1; i++) {
            sb.append(arr[i]);
            sb.append(", ");
        }
        sb.append(arr[size - 1]);
        sb.append("]");
        return sb.toString();
    }
}
