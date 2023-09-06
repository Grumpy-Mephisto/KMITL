public class Quiz1 {
    // Rotate the linked list
    // Given a singly linked list, rotate the linked list counter-clockwise by k nodes. Where k is a
    // given positive integer.
    public static MyLinkedList rotateLinkedList(MyLinkedList list, int k) {
        if (list == null || list.size() == 0 || k == 0)
            return list;

        for (int i = 0; i < k; i++) {
            Object temp = list.remove(0);
            list.add(temp);
        }
        return list;
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.add("10");
        list.add("20");
        list.add("30");
        list.add("40");
        list.add("50");
        list.add("60");

        System.out.printf("Original: %s\n", list);
        for (int i = 0; i < 4; i++) {
            list = rotateLinkedList(list, 1);
            System.out.printf("Rotate %d: %s\n", i + 1, list);
        }
    }
}
