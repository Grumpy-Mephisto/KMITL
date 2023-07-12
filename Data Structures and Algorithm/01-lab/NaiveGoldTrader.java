import java.util.Scanner;

public class NaiveGoldTrader {

  static int readGoldPrices(int goldPrices[]) {
    int count = 0;
    Scanner sc = new Scanner(System.in);
    while (sc.hasNextLine()) {
      goldPrices[count] = Integer.parseInt(sc.nextLine());
      count++;
    }
    sc.close();
    return count;
  }

  static int readGoldPrices(int goldPrices[], int n) {
    for (int i = 0; i < n; i++) {
      goldPrices[i] = (int) Math.round(Math.random() * 20000 + 20000);
    }
    return n;
  }

  static String calculateElapsedTime(long milliseconds) {
    if (milliseconds < 1000) {
      return milliseconds + " ms";
    } else {
      long seconds = milliseconds / 1000;
      if (seconds < 60) {
        return seconds + " seconds";
      } else {
        long minutes = seconds / 60;
        seconds = seconds % 60;
        if (minutes < 60) {
          return minutes + " minutes " + seconds + " seconds";
        } else {
          long hours = minutes / 60;
          minutes = minutes % 60;
          return (
            hours + " hours " + minutes + " minutes " + seconds + " seconds"
          );
        }
      }
    }
  }

  public static void main(String args[]) {
    int goldPrices[] = new int[1000000];

    // Task 1: Read gold prices from text file
    int n = readGoldPrices(goldPrices);

    // Task 2: Generate random gold prices for n days
    // Describe relationship between number of days and loop count.: ความสัมพันธ์ระหว่างจำนวนวันกับจำนวนรอบการทำงานจะขึ้นอยู่กับค่า n ที่เรากำหนด หรือ จำนวนวันที่เราต้องการ
    // Describe how loop count may affect time of execution.: จำนวนรอบการทำงานจะมีผลต่อเวลาในการทำงาน โดยจะเป็นเวลาที่เพิ่มขึ้นเรื่อยๆ ตามจำนวนรอบการทำงานที่เพิ่มขึ้น
    // int n = Integer.parseInt(args[0]);
    // readGoldPrices(goldPrices, n);

    int bestBuyDate = 0;
    int bestSellDate = 0;
    int maxProfit = Integer.MIN_VALUE;
    long count = 0;

    long startTime = System.currentTimeMillis();
    for (int buyDate = 0; buyDate < n - 1; buyDate++) {
      for (int sellDate = buyDate + 1; sellDate < n; sellDate++) {
        count++;
        int profit = goldPrices[sellDate] - goldPrices[buyDate];
        if (profit > maxProfit) {
          maxProfit = profit;
          bestBuyDate = buyDate;
          bestSellDate = sellDate;
        }
      }
    }
    long endTime = System.currentTimeMillis();
    long timeTaken = endTime - startTime;

    String elapsedTime = calculateElapsedTime(timeTaken);

    System.out.println("Number of days: " + n);
    System.out.println("Max profit is: " + maxProfit);
    System.out.println("Buy date: " + (bestBuyDate + 1));
    System.out.println("Sell date: " + (bestSellDate + 1));
    System.out.println("count: " + count);
    System.out.println("Time taken: " + elapsedTime);
  }
}
