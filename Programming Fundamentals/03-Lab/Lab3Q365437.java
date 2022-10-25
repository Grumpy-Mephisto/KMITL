class Lab3Q365437 {
    public static void main(String[] args) {
        int sum = 0;
        int i = 0;
	  int max = 1000;
        while (i < max) {
            if(i % 3 == 0 && i * 3 < 1000) {
                // System.out.println("3 => " + i); // Checking...
                sum += i;
            } 
            else if (i % 5 == 0 && i * 5 < 1000) {
                // System.out.println("5 => " + i); // Checking...
                sum += i;
            }
            i++;
        }
        System.out.printf("Summary = %d", sum);
    }
}