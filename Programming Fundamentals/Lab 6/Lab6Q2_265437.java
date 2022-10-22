class Lab6Q2_265437 {
    public static void CountGroupMagnets(String[] magnet) {
        int n = magnet.length;
        int count = 1;

        for(int i = 1; i < n; i++) {
            if(magnet[i].charAt(0) != magnet[i-1].charAt(0)) {
                count++;
            }
        }
        System.out.printf("Groups of magnet => %d groups", count);
    }
    
    public static void main(String[] args) {
        String input = "10 10 10 01 10 10";
        String[] mag = input.split(" ");

        CountGroupMagnets(mag);
    }
}
