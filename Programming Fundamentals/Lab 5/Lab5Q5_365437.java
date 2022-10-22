class Lab5Q5_365437 {
    public static void main(String[] args) {
        int row = 4;
        for(int i = 1; i <= row; i++) {
            for(int space = 1; space <= row - i; space++) {
                System.out.print("  ");
            }
            for(int j = 1; j <= (2 * i) - 1; j++) {
                System.out.print("p ");
            }
            System.out.println("");
        }
    }
}
