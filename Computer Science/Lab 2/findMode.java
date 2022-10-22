class findMode {
  public static void main(String[] args) {
    int[] arr = {1,2,2,2,3,3,3,3,4,4,4,4,4,5,5,5};
    int maxCnt = Integer.MIN_VALUE;
    int mem = arr[0];
    int cur = arr[0];
    int curCnt = arr[0];
    int mode = arr[0];

    for (int i = 1; i < arr.length; i++) {
      cur = arr[i];
      if (cur == mem) {
        curCnt++;
      } else {
        if (curCnt > maxCnt) {
          mode = mem;
          maxCnt = curCnt;
        }
        mem = cur;
        curCnt = 1;
      }
    }

    if (curCnt > maxCnt) {
      mode = mem;
      maxCnt = curCnt;
    }    
  
    System.out.printf("mode = %d, freq = %d", mode, maxCnt);
  }
}
