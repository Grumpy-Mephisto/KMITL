class Lab5Q3_65437 {
    public static void main(String[] args) {
        int summary = 0;
        int i = 1;
        for(i = 1; i <= 199; i++) {
            summary = (i % 10 == 0) ? summary : summary + i;
        }
        System.out.printf("Summary of all numbers from 0 to 199 is equal => %d%n", summary);
    }
}