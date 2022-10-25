class Lab5Q5_265437 {
    public static void main(String[] args) {
        int row = 4;

        for(int i = row; i >= 1; i--) {
            for(int j = row; j >= i; j--) {
                System.out.print(j + " ");
            }
            System.out.print("\n");
        }
    }
}
