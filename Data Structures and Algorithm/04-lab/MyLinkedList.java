public class MyLinkedList {
  public class Node {
    int data;
    Node next;

    public Node(int d) {
      data = d;
    }
  }

  Node head = null;

  public int getAt(int i) {
    Node p = head;
    while (i > 0) {
      p = p.next;
      i--;
    }

    return p.data;
  }

  public int setAt(int d, int i) {
    Node p = head;
    while (i > 0) {
      p = p.next;
      i--;
    }
    return p.data = d;
  }

  public int size() {
    int count = 0;
    Node p = head;
    while (p != null) {
      count++;
      p = p.next;
    }
    return count;
  }

  public void add(int d) {
    Node p = new Node(d);
    p.next = head;
    head = p;
  }

  public void insert(int d) {
    Node q = new Node(d);
    Node p = head;
    while (p.next != null) {
      if (p.next.data > d) {
        if (p == head) {
          q.next = head;
          head = q;
        } else {
          q.next = p.next;
          p.next = q;
        }
        return;
      }

      p = p.next;
    }
    p.next = q;
  }

  public void find(int d) {
    Node p = head;
    while (p != null) {
      if (p.data == d) {
        System.out.println("Found " + d);
        return;
      }
      p = p.next;
    }
    System.out.println("Not found " + d);
  }

  public void delete(int d) {
    Node p = head;
    Node prev = null;
    while (p != null) {
      if (p.data == d) {
        if (prev == null) {
          head = p.next;
        } else {
          prev.next = p.next;
        }
        return;
      }
      prev = p;
      p = p.next;
    }
  }

  public String toString() {
    StringBuffer sb = new StringBuffer();
    Node p = head;

    while (p != null) {
      sb.append("→ [");
      sb.append(p.data);
      sb.append("] ");
      p = p.next;
    }
    sb.append("→ null");
    return new String(sb);
  }
}
