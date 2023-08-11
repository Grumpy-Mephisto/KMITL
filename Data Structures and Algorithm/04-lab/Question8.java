public class Question8 {
    // Add 1 to a number represented as linked list
    public static void addOne(MyLinkedList list) {
        int carry = 1;
        int sum = 0;
        int i = list.size() - 1;

        while (carry != 0 && i >= 0) {
            sum = list.getAt(i) + carry;
            carry = sum / 10;
            list.setAt(sum % 10, i);
            i--;
        }

        if (carry > 0) {
            list.add(carry);
        }
    }

    public static void main(String[] args) {
        MyLinkedList mList = new MyLinkedList();
        mList.add(1);
        mList.insert(9);
        mList.insert(9);
        mList.insert(9);
        System.out.println(mList.toString());

        addOne(mList);

        System.out.println("Actual: " + mList.toString());
        System.out.println("Expected: → [2] → [0] → [0] → [0] → null");
    }
}
