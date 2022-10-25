class Lab5Q5_165437 {
    public static void main(String[] args) {
        int row = 10;

        // The triangle
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < row; j++) {
                if(i == j) {
                    System.out.print(" ");
                } else if (i == 9 - j) {
                    System.out.print(" ");
                } else {
                    System.out.print("x"); 
                }
            }
            System.out.println();
        }
    }
}