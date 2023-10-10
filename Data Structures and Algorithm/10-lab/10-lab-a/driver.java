public class driver {
    public static void main(String[] args) {
        demo1();
    }

    public static void demo1() {
        System.out.println("————— Insert and PreOrder Traversal —————");
        int[] dat = {15, 20, 10, 18, 16, 12, 8, 25, 19, 30};
        BST bst = new BST();
        for (int j = 0; j < dat.length; j++)
            bst.insert(dat[j]);
        bst.printPreOrder();
        System.out.println();

        demo2(bst);
    }

    static void demo2(BST bst) {
        System.out.println("————— More Traversal —————");
        bst.printInOrder();
        System.out.println();
        bst.printPostOrder();
        System.out.println();
        System.out.println();

        demo3(bst);
    }

    static void demo3(BST bst) {
        System.out.println("————— Search Recursive —————");
        System.out.println(bst.search(20));
        System.out.println(bst.search(25));
        System.out.println(bst.search(12));
        System.out.println(bst.search(1));
        System.out.println(bst.searchRecurse(bst.getRoot(), 10));

        System.out.println("————— Search Iterative —————");
        System.out.println(bst.searchIter(20));
        System.out.println(bst.searchIter(25));
        System.out.println(bst.searchIter(12));
        System.out.println(bst.searchIter(1));
    }
}
