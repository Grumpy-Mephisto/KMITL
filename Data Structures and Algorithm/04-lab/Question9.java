public class Question9 {
    // Reverse a linked list in groups of given size
    public static void reverseAsGroup(MyLinkedList list, int k) {
        int i = 0;

        while (i < list.size()) {
            int start = i;
            int end = i + k - 1;
            while (start < end) {
                int temp = list.getAt(start);
                list.setAt(list.getAt(end), start);
                list.setAt(temp, end);
                start++;
                end--;
            }
            i += k;
        }
    }

    public static void main(String[] args) {
        MyLinkedList mList = new MyLinkedList();
        mList.add(1);
        mList.insert(2);
        mList.insert(3);
        mList.insert(4);
        mList.insert(5);
        mList.insert(6);
        mList.insert(7);
        mList.insert(8);
        mList.insert(9);
        System.out.println(mList.toString());

        reverseAsGroup(mList, 3);
        System.out.println("Actual: " + mList.toString());
        System.out
                .println("Expected: → [3] → [2] → [1] → [6] → [5] → [4] → [9] → [8] → [7] → null");
    }
}
