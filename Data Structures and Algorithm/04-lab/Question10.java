public class Question10 {
    // Function to check if a singly linked list is palindrome
    public static boolean isPalindrome(MyLinkedList list) {
        if (list.size() == 0) {
            return false;
        }

        int i = 0;
        int j = list.size() - 1;

        while (i < j) {
            if (list.getAt(i) != list.getAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    public static void main(String[] args) {
        String input = "DENED";
        MyLinkedList mList = new MyLinkedList();
        for (int i = 0; i < input.length(); i++) {
            mList.add(input.charAt(i));
        }

        System.out.println(mList.toString());
        System.out.println("Actual: " + isPalindrome(mList));
        System.out.println("Expected: true");
    }
}
