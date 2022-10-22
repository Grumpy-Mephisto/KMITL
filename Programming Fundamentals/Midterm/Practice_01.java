class Practice_01 {
    // AAAA+BBBB
    // AAA0+0BBB
    // AA00+00BB
    // A000+000B
    // *********
    // C000+000D
    // CC00+00DD
    // CCC0+0DDD
    // CCCC+DDDD

    public static void main(String[] args) {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(i < 4 && j < 4) {
                    System.out.print("A");
                } else if (i < 4 && j > 4) {
                    System.out.print("B");
                } else if(i == 4) {
                    System.out.print("*");
                } else if(j < 4 && i > 4) {
                    System.out.print("C");
                } else if(j == 4) {
                    System.out.print("+");
                /*
                    remain: print "0"
                */
                } else {
                    System.out.print("D");
                }
            }
            System.out.println();
        }
    }

}