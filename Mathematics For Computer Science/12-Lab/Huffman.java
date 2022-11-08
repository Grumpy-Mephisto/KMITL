import java.io.*;
import java.util.*;

public class Huffman {

  public static void printCode(HuffmanNode root, String s) {
    if (root.left == null && root.right == null) {
      System.out.println("ascii(" + (int) root.c + ") : " + s);
      return;
    }
    printCode(root.left, s + "0");
    printCode(root.right, s + "1");
  }

  public static void countLengths(
    HuffmanNode root,
    int[] charBitLength,
    int length
  ) {
    if (root.left == null && root.right == null) {
      charBitLength[(int) root.c] = length;
      return;
    }
    countLengths(root.left, charBitLength, length + 1);
    countLengths(root.right, charBitLength, length + 1);
  }

  static String Choices() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Select the Book to compress a file");
    System.out.println("1. Book 1 - The Philosopher's Stone");
    System.out.println("2. Book 2 - The Chamber of Secrets");
    System.out.println("3. Book 3 - The Prisoner of Azkaban");
    System.out.println("4. Book 4 - The Goblet of Fire");
    System.out.println("5. Book 5 - The Order of the Phoenix");
    System.out.println("6. Book 6 - The Half-Blood Prince");
    System.out.println("7. Book 7 - The Deathly Hallows");
    System.out.print("Your Choice: ");

    int choice = sc.nextInt();
    sc.close();
    String book = "";
    switch (choice) {
      case 1:
        book = "Book 1 - The Philosopher's Stone.txt";
        break;
      case 2:
        book = "Book 2 - The Chamber of Secrets.txt";
        break;
      case 3:
        book = "Book 3 - The Prisoner of Azkaban.txt";
        break;
      case 4:
        book = "Book 4 - The Goblet of Fire.txt";
        break;
      case 5:
        book = "Book 5 - The Order of the Phoenix.txt";
        break;
      case 6:
        book = "Book 6 - The Half-Blood Prince.txt";
        break;
      case 7:
        book = "Book 7 - The Deathly Hallows.txt";
        break;
      default:
        System.out.println("Invalid Choice");
        break;
    }

    return book;
  }

  static void buildCharFreqFromFile(char[] charArray, int[] charFreq) {
    try {
      String book = Choices();
      // Open file and build static code:
      FileInputStream fis = new FileInputStream(book);
      int c;
      for (int i = 0; i < charArray.length; i++) {
        // Build the static code:
        charArray[i] = (char) i;
      }

      while ((c = fis.read()) != -1) {
        // Count the frequency all ASCII characters:
        charFreq[c]++;
      }
      fis.close();
    } catch (IOException e) {
      System.out.println("Error: " + e);
    }
  }

  // main function
  public static void main(String[] args) {
    char[] charArray = new char[256];
    int[] charFreq = new int[256];
    buildCharFreqFromFile(charArray, charFreq);
    int n = charArray.length;

    PriorityQueue<HuffmanNode> q = new PriorityQueue<HuffmanNode>(
      n,
      new MyComparator()
    );

    for (int i = 0; i < n; i++) {
      HuffmanNode hn = new HuffmanNode();

      hn.c = charArray[i];
      hn.data = charFreq[i];

      hn.left = null;
      hn.right = null;

      q.add(hn);
    }

    HuffmanNode root = null;

    while (q.size() > 1) {
      HuffmanNode x = q.peek();
      q.poll();

      HuffmanNode y = q.peek();
      q.poll();

      HuffmanNode f = new HuffmanNode();

      f.data = x.data + y.data;
      f.left = x;
      f.right = y;
      q.add(f);
    }
    root = q.peek();

    int[] charBitLength = new int[n];
    printCode(root, "");
    countLengths(root, charBitLength, 0);

    int sumBit = 0;
    int sumChar = 0;
    for (int i = 0; i < n; i++) {
      System.out.println("ascii(" + i + "): " + charBitLength[i] + " ");
      sumBit += (charBitLength[i] * charFreq[i]);
      sumChar += charFreq[i];
    }
    System.out.println("Average bits per char: " + sumBit / (double) sumChar);
  }
}

class HuffmanNode {

  int data;
  char c;

  HuffmanNode left;
  HuffmanNode right;
}

class MyComparator implements Comparator<HuffmanNode> {

  public int compare(HuffmanNode x, HuffmanNode y) {
    return x.data - y.data;
  }
}
// This code is contributed by Kunwar Desh Deepak Singh
