class Lab5 {
  public static final String RESET = "\u001B[0m";
  public static final String RED = "\u001B[31m";
  public static final String GREEN = "\u001B[32m";

  public static void main(String[] args) {
    System.out.println();
    System.out.println("How to pick up all => 16 ways");
    System.out.println("Values = {20, 50, 30, 10}");
    System.out.println("Weights = {2, 10, 5, 5}");
    System.out.println("---------------------------------------");
    System.out.println("format (weight, value) => possibility");
    System.out.println("---------------------------------------");
    System.out.println("1).  (0, 0)    => 0000");
    System.out.println("2).  (5, 10)   => 0001");
    System.out.println("3).  (5, 30)   => 0010");
    System.out.println("4).  (10, 40)  => 0011");
    System.out.println("5).  (10, 50)  => 0100");
    System.out.println("6).  (15, 60)  => 0101");
    System.out.println(GREEN + "7).  (15, 80)  => 0110" + "\t*" + RESET);
    System.out.println("8).  (20, 90)  => 0111");
    System.out.println("9).  (2,  20)  => 1000");
    System.out.println("10). (7,  30)  => 1001");
    System.out.println("11). (7,  50)  => 1010");
    System.out.println("12). (12, 60)  => 1011");
    System.out.println("13). (12, 70)  => 1100");
    System.out.println(RED + "14). (17, 80)  => 1101" + "\tx" + RESET);
    System.out.println(RED + "15). (17, 100) => 1110" + "\tx" + RESET);
    System.out.println(RED + "16). (22, 110) => 1111" + "\tx" + RESET);
    System.out.println("---------------------------------------");
    System.out.println();
  }
}
