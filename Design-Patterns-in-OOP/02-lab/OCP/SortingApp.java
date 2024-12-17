public class SortingApp {
    private ISorter sorter;

    public SortingApp(ISorter sorter) {
        this.sorter = sorter;
    }

    public void performSort(int[] array) {
        sorter.sort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = {64, 34, 25, 12, 22, 11, 90};

        // Selection sort algorithm
        SortingApp client = new SortingApp(new SelectionSort());
        client.performSort(array);

        // Merge sort algorithm
        client = new SortingApp(new MergeSort());
        client.performSort(array);

        // Insertion sort algorithm
        client = new SortingApp(new InsertionSort());
        client.performSort(array);
    }
}
