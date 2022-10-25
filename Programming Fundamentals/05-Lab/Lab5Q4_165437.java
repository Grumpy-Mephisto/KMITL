class Lab5Q4_165437 {
    public static void main(String[] args) {
        String str = "WWWWMMMMWMWMWMWMMMWWWWWM";
        int i = 0;
        int women = 0;
        int men = 0;
        
        for(i = 0; i < str.length(); i++) {
            if(str.charAt(i) == 'M'){
                men++;
            } else if((str.charAt(i) == 'W')) {
                women++;
            }
        }
        System.out.printf("\"M\" contains in str is equal => %d%n", men);
        System.out.printf("\"W\" contains in str is equal => %d%n", women);
    }
}