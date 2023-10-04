package code;

import java.util.Arrays;

public class MyMinHeap {
    int MAX_SIZE = 100;
    int heap[] = new int[MAX_SIZE];
    int size = 0;

    public void insert(int d) {
        int p = size++;
        heap[p] = d;
        int pp = (p - 1) / 2;

        while (p > 0 && heap[p] < heap[pp]) {
            int temp = heap[p];
            heap[p] = heap[pp];
            heap[pp] = temp;
            p = pp;
            pp = (p - 1) / 2;
        }
    }

    public int remove() {
        int root = heap[0];
        heap[0] = heap[--size];
        int p = 0;
        int l = 2 * p + 1;
        int r = 2 * p + 2;

        while (l < size) {
            int min = l;
            if (r < size && heap[r] < heap[l]) {
                min = r;
            }
            if (heap[p] <= heap[min]) {
                break;
            }
            int temp = heap[p];
            heap[p] = heap[min];
            heap[min] = temp;
            p = min;
            l = 2 * p + 1;
            r = 2 * p + 2;
        }
        return root;
    }

    public int peek() {
        return heap[0];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size >= MAX_SIZE;
    }

    public void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    @Override
    public String toString() {
        return String.format("MyMinHeap{heap=%s, size=%d}", Arrays.toString(heap), size);
    }
}
