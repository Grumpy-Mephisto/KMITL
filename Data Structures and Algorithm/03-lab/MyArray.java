public class MyArray {
  public int MAX_SIZE = 5;
  public int[] array;
  public int size;

  public MyArray() {
    array = new int[MAX_SIZE];
    size = 0;
  }

  public boolean isFull() {
    return size >= MAX_SIZE;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public void add(int value) {
    if (isFull()) expands();

    array[size++] = value;
  }

  public void insert(int value, int index) {
    if (isFull()) expands();

    for (int i = size; i > index; i--) {
      array[i] = array[i - 1];
    }
    array[index] = value;
    size++;
  }

  public int find(int value) {
    for (int i = 0; i < size; i++) {
      if (array[i] == value) {
        return i;
      }
    }
    return -1;
  }

  public int binarySearch(int value) {
    int low = 0;
    int high = size - 1;
    while(low <= high) {
      int mid = (low + high) / 2;
      if (array[mid] == value) {
        return mid;
      } else if (array[mid] < value) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return -1;
  }

  public void deleteU(int index) {
    for (int i = index; i < size - 1; i++) {
      array[i] = array[i + 1];
    }
    size--;
  }

  public void deleteO(int index) {
    array[index] = array[size - 1];
    size--;
  }

  public void expands() {
    MAX_SIZE *= 2;
    int newArray[] = new int[MAX_SIZE];
    System.arraycopy(array, 0, newArray, 0, size);
    array = newArray;
  }
  
  public String toString() {
    StringBuffer sb = new StringBuffer();
    sb.append("[");
    for (int i = 0; i < size; i++) {
      sb.append(array[i]);
      if (i != size - 1) {
        sb.append(", ");
      }
    }
    sb.append("]");
    return sb.toString();
  }
}