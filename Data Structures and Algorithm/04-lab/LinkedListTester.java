public class LinkedListTester {
  public static void main(String[] args) {
    MyLinkedList mList = new MyLinkedList();

    System.out.println("===== Adding =====");
    mList.add(4);
    mList.add(3);
    mList.add(7);
    System.out.println(mList.toString());

    System.out.println("===== Inserting =====");
    mList.insert(5);
    mList.insert(2);
    mList.insert(8);
    System.out.println(mList.toString());

    System.out.println("===== Finding =====");
    mList.find(5);
    mList.find(2);
    mList.find(8);
    mList.find(9);
    System.out.println(mList.toString());

    System.out.println("===== Deleting =====");
    mList.delete(5);
    mList.delete(2);
    mList.delete(8);
    mList.delete(9);
    System.out.println(mList.toString());

    System.out.println(mList.toString());
  }
}
