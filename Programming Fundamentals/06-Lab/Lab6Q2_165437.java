class Lab6Q2_165437 {
  public static void main(String[] args) {
    int [] data = {7,1,2,-1,3,4,10,-12,3,21,-9};
    int max = data[0];
    for(int i = 0; i < data.length; i++) {
      if(data[i] > max) {
        max = data[i];
      }
    }
    System.out.print(max);
  }
}